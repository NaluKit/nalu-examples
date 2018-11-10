/*
 * Copyright (c) 2018 - Frank Hossfeld
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
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.google.gwt.user.client.ui.Widget;
import elemental2.dom.DomGlobal;

@Controller(route = "/application/detail/:id",
            selector = "content",
            componentInterface = IDetailComponent.class,
            component = DetailComponent.class)
public class DetailController
    extends AbstractComponentController<NaluSimpleApplicationContext, IDetailComponent, Widget>
    implements IDetailComponent.Controller {

  private Person person;

  private long id;

  public DetailController() {
  }

  @Override
  public String mayStop() {
    return this.component.isDirty() ? "Would youlike to cancel your edits?" : null;
  }

  @Override
  public void start() {
    if (this.id == 0) {
      this.router.route("/application/search");
    }
    try {
      this.person = PersonService.get()
                                 .get(id);
      this.component.edit(this.person);
      this.eventBus.fireEvent(new StatusChangeEvent("Edit person data with id: " + this.person.getId()));
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
                                             "/application/search",
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
    this.router.route("/application/list",
                      this.context.getSearchName(),
                      this.context.getSearchCity());
  }

  @Override
  public void doUpdate() {
    try {
      PersonService.get()
                   .update(this.component.flush(this.person));
      if (this.context.getSearchName() == null && this.context.getSearchCity() == null) {
        this.router.route("/application/search");
      } else {
        this.router.route("/application/list",
                          this.context.getSearchName(),
                          this.context.getSearchCity());
      }
    } catch (PersonException e) {
      DomGlobal.window.alert("Panic!");
    }

  }

  @Override
  public String getHRef() {
    return "#" +
           this.router.generateHash("/application/search",
                                    this.context.getSearchName(),
                                    this.context.getSearchCity());
  }
}
