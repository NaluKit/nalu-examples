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

package de.gishmo.example.devk.client.ui.application.content.list;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import de.gishmo.example.devk.client.ApplicationContext;
import de.gishmo.example.devk.client.Routes;
import de.gishmo.example.devk.client.event.SelectEvent;
import de.gishmo.example.devk.client.event.StatusChangeEvent;
import de.gishmo.example.devk.client.service.PersonServiceFactory;
import de.gishmo.example.devk.shared.model.dto.Person;
import de.gishmo.example.devk.shared.model.dto.PersonSearch;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

@Controller(route = Routes.ROUTE_LIST,
            selector = "content",
            componentInterface = IListComponent.class,
            component = ListComponent.class)
public class ListController
    extends AbstractComponentController<ApplicationContext, IListComponent, HTMLElement>
    implements IListComponent.Controller {

  private String name;

  private String city;

  public ListController() {
  }

  @Override
  public void start() {
    PersonServiceFactory.INSTANCE.getAll(new PersonSearch(this.name,
                                                          this.city))
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
                                     this.eventBus.fireEvent(new StatusChangeEvent("Found " +
                                                                                   Integer.toString(reponse.getPersonList()
                                                                                                           .size()) +
                                                                                   " persons"));
                                   }
                                 })
                                 .onFailed(failedResponse -> {
                                   DomGlobal.window.alert("PANIC!!!!!!");
                                 })
                                 .send();
    this.eventBus.fireEvent(new SelectEvent(SelectEvent.Select.LIST));
  }

  @Override
  public void doUpdate(Person object) {
    this.router.route("/applicationShell/person/detail",
                      Long.toString(object.getId()));
  }

  @AcceptParameter("name")
  public void setName(String name) {
    this.name = name;
  }

  @AcceptParameter("city")
  public void setCity(String city) {
    this.city = city;
  }

}
