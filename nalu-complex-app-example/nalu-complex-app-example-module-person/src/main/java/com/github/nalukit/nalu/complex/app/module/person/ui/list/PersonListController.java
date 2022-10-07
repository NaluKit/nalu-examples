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

package com.github.nalukit.nalu.complex.app.module.person.ui.list;

import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.component.event.ShowPopUpEvent;
import com.github.nalukit.nalu.client.event.annotation.EventHandler;
import com.github.nalukit.nalu.complex.app.common.event.SelectEvent;
import com.github.nalukit.nalu.complex.app.common.event.StatusChangeEvent;
import com.github.nalukit.nalu.complex.app.common.ui.AbstractAppComponentController;
import com.github.nalukit.nalu.complex.app.common.ui.Routes;
import com.github.nalukit.nalu.complex.app.common.ui.Slots;
import com.github.nalukit.nalu.complex.app.common.ui.UiConstants;
import com.github.nalukit.nalu.complex.app.common.ui.common.MessageFactory;
import com.github.nalukit.nalu.complex.app.module.person.event.PersonListEvent;
import com.github.nalukit.nalu.complex.app.shared.service.PersonServiceFactory;
import com.github.nalukit.nalu.complex.app.shared.transport.request.PersonSearchRequest;
import com.google.gwt.core.client.GWT;
import elemental2.dom.DomGlobal;

@Controller(route = Routes.ROUTE_PERSON_LIST,
            selector = Slots.SELECTOR_CONTENT_APPLICATION,
            componentInterface = IPersonListComponent.class,
            component = PersonListComponent.class)
public class PersonListController
    extends AbstractAppComponentController<IPersonListComponent>
    implements IPersonListComponent.Controller {

  public PersonListController() {
  }

  @Override
  public void start() {
    this.eventBus.fireEvent(new SelectEvent(SelectEvent.Item.LIST));
    if (this.context.isFilterPersonUsed()) {
      this.getData();
    } else {
      MessageFactory.INSTANCE
                    .showProgressBar();
      this.eventBus.fireEvent(ShowPopUpEvent.show(UiConstants.POPUP_PERSON_FILTER));
    }
  }

  @Override
  public void activate() {
    super.activate();
  }

  @EventHandler
  public void onPersonListEvent(PersonListEvent event) {
    GWT.debugger();
    if (event.getTask() == PersonListEvent.Task.REFRESH) {
      this.getData();
    }
  }

  private void getData() {
    PersonSearchRequest request = new PersonSearchRequest(this.context.getPersistance());
    PersonServiceFactory.INSTANCE.getAll(request)
                                 .onSuccess(reponse -> {
                                   this.component.resetTable();
                                   this.component.setData(reponse.getPersonList());
                                   if (reponse.getPersonList()
                                              .size() == 0) {
                                     this.eventBus.fireEvent(new StatusChangeEvent("No person found"));
                                   } else if (reponse.getPersonList()
                                                     .size() == 1) {
                                     this.eventBus.fireEvent(new StatusChangeEvent("Found one person"));
                                   } else {
                                     this.eventBus.fireEvent(new StatusChangeEvent("Found " + reponse.getPersonList()
                                                                                                     .size() + " persons"));
                                   }
                                   MessageFactory.INSTANCE
                                                 .hideProgressBar();
                                 })
                                 .onFailed(failedResponse -> DomGlobal.window.alert("PANIC!!!!!!"))
                                 .send();
  }

  @Override
  public void doEdit(long id) {
    MessageFactory.INSTANCE
                  .showProgressBar();
    this.router.route(Routes.ROUTE_PERSON_EDIT,
                      String.valueOf(id));
  }

  @Override
  public void doShowSearchPopUp() {
    this.eventBus.fireEvent(ShowPopUpEvent.show(UiConstants.POPUP_PERSON_FILTER));
  }

}
