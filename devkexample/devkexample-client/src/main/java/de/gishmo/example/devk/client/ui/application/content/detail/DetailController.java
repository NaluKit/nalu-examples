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

package de.gishmo.example.devk.client.ui.application.content.detail;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.IsComponentCreator;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Composite;
import com.github.nalukit.nalu.client.component.annotation.Composites;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.constraint.annotation.ParameterConstraint;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import de.gishmo.example.devk.client.ApplicationContext;
import de.gishmo.example.devk.client.Routes;
import de.gishmo.example.devk.client.constraint.IdRule;
import de.gishmo.example.devk.client.event.SelectEvent;
import de.gishmo.example.devk.client.event.StatusChangeEvent;
import de.gishmo.example.devk.client.ui.application.content.detail.composite.address.AddressComposite;
import de.gishmo.example.devk.client.ui.application.content.detail.composite.person.PersonComposite;
import de.gishmo.example.devk.shared.model.dto.Person;
import de.gishmo.example.devk.shared.model.service.PersonServiceFactory;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

@Controller(route = Routes.ROUTE_DETAIL,
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
    extends AbstractComponentController<ApplicationContext, IDetailComponent, HTMLElement>
    implements IDetailComponent.Controller,
               IsComponentCreator<IDetailComponent> {

  private Person person;

  private long id;

  public DetailController() {
  }

  public DetailController(Person person) {
    this.person = person;
  }

  @Override
  public String mayStop() {
    boolean isPersonCompositeDirty = super.<PersonComposite>getComposite("personComposite")
                                          .isDirty(this.person);
    boolean isAddressCompositeDirty = super.<AddressComposite>getComposite("AddressComposite")
                                           .isDirty(this.person);
    return isPersonCompositeDirty || isAddressCompositeDirty ? "Would you like to cancel your edits?" : null;
  }

  @Override
  public void start() {
    if (this.id == 0) {
      this.router.route(Routes.ROUTE_SEARCH);
    }
    PersonServiceFactory.INSTANCE.get(Long.toString(id))
                                 .onSuccess(response -> {
                                   this.person = response.getPerson();
                                   super.<PersonComposite>getComposite("personComposite")
                                        .edit(this.person);
                                   super.<AddressComposite>getComposite("AddressComposite")
                                        .edit(this.person);
                                   this.eventBus.fireEvent(new StatusChangeEvent("Edit person data with id: " +
                                                                                 this.person.getId()));

                                   this.eventBus.fireEvent(new SelectEvent(SelectEvent.Select.DETAIL));
                                 })
                                 .onFailed(failedResponse -> DomGlobal.window.alert("Panic!"))
                                 .send();
  }

  @Override
  public void stop() {
    this.eventBus.fireEvent(new StatusChangeEvent(""));
  }

  @AcceptParameter("id")
  @ParameterConstraint(rule = IdRule.class,
                       illegalParameterRoute = Routes.ROUTE_ERROR)
  public void setId(String id)
      throws RoutingInterceptionException {
    try {
      this.id = Long.parseLong(id);
    } catch (NumberFormatException e) {
      DomGlobal.window.alert("id is not valid ->  moving to search");
      throw new RoutingInterceptionException(this.getClass()
                                                 .getCanonicalName(),
                                             Routes.ROUTE_SEARCH,
                                             this.context.getSearchName(),
                                             this.context.getSearchCity());
    }
  }

  @Override
  public void doCallPerson1() {
    this.router.route(Routes.ROUTE_DETAIL,
                      "1");
  }

  @Override
  public Person getPerson() {
    return this.person;
  }

  @Override
  public void doRevert() {
    this.router.route("/applicationShell/person/list",
                      this.context.getSearchName(),
                      this.context.getSearchCity());
  }

  @Override
  public void doUpdate() {
    this.person = super.<PersonComposite>getComposite("personComposite")
                       .flush(this.person);
    this.person = super.<AddressComposite>getComposite("AddressComposite")
                       .flush(this.person);
    PersonServiceFactory.INSTANCE.update(this.person)
                                 .onSuccess(response -> {
                                   if (this.context.getSearchName() == null && this.context.getSearchCity() == null) {
                                     this.router.route(Routes.ROUTE_SEARCH);
                                   } else {
                                     this.router.route(Routes.ROUTE_LIST,
                                                       this.context.getSearchName(),
                                                       this.context.getSearchCity());
                                   }
                                 })
                                 .onFailed(failedRespnse -> DomGlobal.window.alert("Panic!"))
                                 .send();
  }

  @Override
  public IDetailComponent createComponent() {
    return new DetailComponent();
  }

}
