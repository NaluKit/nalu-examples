/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.exception.PersonException;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.exception.PersonNotFoundException;
import com.github.nalukit.example.nalu.simpleapplication.client.data.service.PersonService;
import com.github.nalukit.example.nalu.simpleapplication.client.event.SelectEvent;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail.composite.address.AddressComposite;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail.composite.person.PersonComposite;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Composite;
import com.github.nalukit.nalu.client.component.annotation.Composites;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

@Controller(route = "/application/person/:id/detail",
            selector = "content",
            componentInterface = IDetailComponent.class,
            component = DetailComponent.class)
@Composites({ @Composite(name = "personComposite",
                         compositeController = PersonComposite.class,
                         selector = "compositePerson"),
              @Composite(name = "AddressComposite",
                         compositeController = AddressComposite.class,
                         selector = "compositeAddress") })
public class DetailController
    extends AbstractComponentController<NaluSimpleApplicationContext, IDetailComponent, HTMLElement>
    implements IDetailComponent.Controller {

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
      this.router.route("/person/search");
    }
    try {
      this.person = PersonService.get()
                                 .get(id);
      super.<PersonComposite>getComposite("personComposite").edit(this.person);
      super.<AddressComposite>getComposite("AddressComposite").edit(this.person);
      this.eventBus.fireEvent(new StatusChangeEvent("Edit person data with id: " + this.person.getId()));

      this.eventBus.fireEvent(new SelectEvent(SelectEvent.Select.DETAIL));
    } catch (PersonNotFoundException e) {
      DomGlobal.window.alert("Panic!");
    }
  }

  @Override
  public void stop() {
    this.eventBus.fireEvent(new StatusChangeEvent(""));
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
                                             "/application/person/search");
    }
  }

  @Override
  public Person getPerson() {
    return this.person;
  }

  @Override
  public void doRevert() {
    this.router.route("/application/person/list");
  }

  @Override
  public void doUpdate() {
    this.person = super.<PersonComposite>getComposite("personComposite").flush(this.person);
    this.person = super.<AddressComposite>getComposite("AddressComposite").flush(this.person);
    try {
      PersonService.get()
                   .update(this.person);
      if (this.context.getSearchName() == null && this.context.getSearchCity() == null) {
        this.router.route("/application/person/search");
      } else {
        this.router.route("/application/person/list",
                          this.context.getSearchName(),
                          this.context.getSearchCity());
      }
    } catch (PersonException e) {
      DomGlobal.window.alert("Panic!");
    }

  }

}
