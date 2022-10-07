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

package com.github.nalukit.nalu.complex.app.module.person.ui.edit;

import com.github.nalukit.nalu.client.component.IsComponentCreator;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Composite;
import com.github.nalukit.nalu.client.component.annotation.Composites;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.constraint.annotation.ParameterConstraint;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.github.nalukit.nalu.complex.app.common.event.StatusChangeEvent;
import com.github.nalukit.nalu.complex.app.common.ui.AbstractAppComponentController;
import com.github.nalukit.nalu.complex.app.common.ui.Routes;
import com.github.nalukit.nalu.complex.app.common.ui.Slots;
import com.github.nalukit.nalu.complex.app.common.ui.common.MessageFactory;
import com.github.nalukit.nalu.complex.app.module.person.constraint.IdRule;
import com.github.nalukit.nalu.complex.app.module.person.ui.edit.composite.address.AddressComposite;
import com.github.nalukit.nalu.complex.app.module.person.ui.edit.composite.person.PersonComposite;
import com.github.nalukit.nalu.complex.app.shared.model.Person;
import com.github.nalukit.nalu.complex.app.shared.service.PersonServiceFactory;
import com.github.nalukit.nalu.complex.app.shared.transport.request.PersonChangeRequest;
import com.github.nalukit.nalu.complex.app.shared.transport.request.PersonGetRequest;
import com.google.gwt.core.client.GWT;
import elemental2.dom.DomGlobal;

@Controller(route = Routes.ROUTE_PERSON_EDIT,
            selector = Slots.SELECTOR_CONTENT_APPLICATION,
            componentInterface = IPersonEditComponent.class,
            component = PersonEditComponent.class)
@Composites({ @Composite(name = "personComposite", compositeController = PersonComposite.class, selector = "composite01"),
              @Composite(name = "addressComposite", compositeController = AddressComposite.class, selector = "composite02") })
public class PersonEditController
    extends AbstractAppComponentController<IPersonEditComponent>
    implements IPersonEditComponent.Controller,
               IsComponentCreator<IPersonEditComponent> {
  private long    id;
  private Person  person;
  private boolean saved;

  public PersonEditController() {
  }

  @Override
  public String mayStop() {
    if (!this.saved) {
      boolean isPersonCompositeDirty = super.<PersonComposite>getComposite("personComposite")
                                            .isDirty(this.person);
      boolean isAddressCompositeDirty = super.<AddressComposite>getComposite("addressComposite")
                                             .isDirty(this.person);
      return isPersonCompositeDirty || isAddressCompositeDirty ? "Would you like to cancel your edits?" : null;
    } else {
      return null;
    }
  }

  @Override
  public void start() {
    if (this.id == 0) {
      this.router.route(Routes.ROUTE_PERSON_LIST);
    }
    this.saved = false;
    this.getPersonData();
  }

  private void getPersonData() {
    PersonGetRequest request = new PersonGetRequest();
    request.setId(this.id);
    PersonServiceFactory.INSTANCE.get(request)
                                 .onSuccess(response -> {
                                   this.person = response.getPerson();
                                   super.<PersonComposite>getComposite("personComposite")
                                        .edit(this.person);
                                   super.<AddressComposite>getComposite("addressComposite")
                                        .edit(this.person);
                                   this.eventBus.fireEvent(new StatusChangeEvent("Edit person data with id: " + this.person.getId()));
                                   MessageFactory.INSTANCE
                                                 .hideProgressBar();
                                 })
                                 .onFailed(failedResponse -> DomGlobal.window.alert("Panic!"))
                                 .send();
  }

  @Override
  public void stop() {
    this.eventBus.fireEvent(new StatusChangeEvent(""));
  }

  @AcceptParameter("id")
  @ParameterConstraint(rule = IdRule.class, illegalParameterRoute = Routes.ROUTE_HOME)
  public void setId(String id)
      throws RoutingInterceptionException {
    try {
      this.id = Long.parseLong(id);
    } catch (NumberFormatException e) {
      DomGlobal.window.alert("id is not valid ->  moving to home");
      throw new RoutingInterceptionException(this.getClass()
                                                 .getCanonicalName(),
                                             Routes.ROUTE_HOME);
    }
  }

  @Override
  public void doCallPerson1() {
    MessageFactory.INSTANCE
                  .showProgressBar();
    this.router.route(Routes.ROUTE_PERSON_EDIT,
                      "1");
  }

  @Override
  public void doRevert() {
    MessageFactory.INSTANCE
                  .showProgressBar();
    this.router.route(Routes.ROUTE_PERSON_LIST);
  }

  @Override
  public void doUpdate() {
    GWT.debugger();
    this.person = super.<PersonComposite>getComposite("personComposite")
                       .flush(this.person);
    this.person = super.<AddressComposite>getComposite("addressComposite")
                       .flush(this.person);

    PersonChangeRequest request = new PersonChangeRequest();
    request.setPerson(this.person);

    PersonServiceFactory.INSTANCE.update(request)
                                 .onSuccess(response -> {
                                   this.saved = true;
                                   MessageFactory.INSTANCE
                                                 .showProgressBar();
                                   this.router.route(Routes.ROUTE_PERSON_LIST);
                                 })
                                 .onFailed(failedRespnse -> DomGlobal.window.alert("Panic!"))
                                 .send();
  }

  /**
   * This is not really necessary, but it demonstrate how to implement a component creator.
   *
   * @return the created component
   */
  @Override
  public IPersonEditComponent createComponent() {
    return new PersonEditComponent();
  }

}
