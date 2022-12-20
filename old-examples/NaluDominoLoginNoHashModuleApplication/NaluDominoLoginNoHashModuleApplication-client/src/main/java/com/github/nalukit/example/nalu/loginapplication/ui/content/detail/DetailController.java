/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package com.github.nalukit.example.nalu.loginapplication.ui.content.detail;

import com.github.nalukit.example.nalu.loginapplication.NaluLoginApplicationContext;
import com.github.nalukit.example.nalu.loginapplication.event.SelectEvent;
import com.github.nalukit.example.nalu.loginapplication.shared.data.model.dto.Person;
import com.github.nalukit.example.nalu.loginapplication.shared.data.model.exception.PersonException;
import com.github.nalukit.example.nalu.loginapplication.shared.data.model.exception.PersonNotFoundException;
import com.github.nalukit.example.nalu.loginapplication.shared.data.service.PersonService;
import com.github.nalukit.example.nalu.loginapplication.ui.content.detail.composite.address.AddressComposite;
import com.github.nalukit.example.nalu.loginapplication.ui.content.detail.composite.person.PersonComposite;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.IsComponentCreator;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Composite;
import com.github.nalukit.nalu.client.component.annotation.Composites;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.event.NaluApplicationEvent;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

@Controller(route = "/applicationShell/person/:id/detail",
            selector = "content",
            componentInterface = IDetailComponent.class,
            component = DetailComponent.class)
@Composites({ @Composite(name = "personComposite",
                         compositeController = PersonComposite.class,
                         selector = "splitterPerson"),
              @Composite(name = "AddressComposite",
                         compositeController = AddressComposite.class,
                         selector = "splitterAddress") })
public class DetailController
    extends AbstractComponentController<NaluLoginApplicationContext, IDetailComponent, HTMLElement>
    implements IDetailComponent.Controller,
               IsComponentCreator<IDetailComponent> {

  private Person person;

  private long id;

  public DetailController() {
  }

  @Override
  public String mayStop() {
    boolean isPersonCompositeDirty = super.<PersonComposite>getComposite("personComposite").isDirty(this.person);
    boolean isAddressCompositeDirty = super.<AddressComposite>getComposite("AddressComposite").isDirty(this.person);
    return isPersonCompositeDirty || isAddressCompositeDirty ? "Would you like to cancel your edits?" : null;
  }

  @Override
  public void start() {
    if (this.id == 0) {
      this.router.route("applicationShell/person/search");
    }
    try {
      this.person = PersonService.get()
                                 .get(id);
      super.<PersonComposite>getComposite("personComposite").edit(this.person);
      super.<AddressComposite>getComposite("AddressComposite").edit(this.person);
      this.eventBus.fireEvent(NaluApplicationEvent.create()
                                                  .event("StatusChangeEvent")
                                                  .data("message",
                                                        "Edit person data with id: " + this.person.getId()));

      this.eventBus.fireEvent(new SelectEvent(SelectEvent.Select.DETAIL));
    } catch (PersonNotFoundException e) {
      DomGlobal.window.alert("Panic!");
    }
  }

  @Override
  public void stop() {
    this.eventBus.fireEvent(NaluApplicationEvent.create()
                                                .event("StatusChangeEvent")
                                                .data("message",
                                                      ""));
  }

  @AcceptParameter("id")
  public void setId(String id)
      throws RoutingInterceptionException {
    try {
      this.id = Long.parseLong(id);
    } catch (NumberFormatException e) {
      DomGlobal.window.alert("id is not valid ->  moving to search");
      throw new RoutingInterceptionException(this.getClass()
                                                 .getCanonicalName(),
                                             "/applicationShell/person/search",
                                             this.context.getSearchName(),
                                             this.context.getSearchCity());
    }
  }

  @Override
  public Person getPerson() {
    return this.person;
  }

  @Override
  public void doRevert() {
    // tracking button click
    this.eventBus.fireEvent(NaluApplicationEvent.create()
                                                .event("ButtonPressedEvent")
                                                .data("message",
                                                      "DetailController: revert button pressed"));
    // revert data
    this.router.route("/applicationShell/person/list",
                      this.context.getSearchName(),
                      this.context.getSearchCity());
  }

  @Override
  public void doUpdate() {
    // tracking button click
    this.eventBus.fireEvent(NaluApplicationEvent.create()
                                                .event("ButtonPressedEvent")
                                                .data("message",
                                                      "DetailController: update button pressed"));
    // update data
    this.person = super.<PersonComposite>getComposite("personComposite").flush(this.person);
    this.person = super.<AddressComposite>getComposite("AddressComposite").flush(this.person);
    try {
      PersonService.get()
                   .update(this.person);
      if (this.context.getSearchName() == null && this.context.getSearchCity() == null) {
        this.router.route("/applicationShell/person/search");
      } else {
        this.router.route("/applicationShell/person/list",
                          this.context.getSearchName(),
                          this.context.getSearchCity());
      }
    } catch (PersonException e) {
      DomGlobal.window.alert("Panic!");
    }

  }

  @Override
  public IDetailComponent createComponent() {
    return new DetailComponent();
  }

}
