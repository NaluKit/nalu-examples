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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.list;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.PersonSearch;
import com.github.nalukit.example.nalu.simpleapplication.client.data.service.PersonService;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;

import java.util.List;

@Controller(route = "/application/person/list/:name/:city",
            selector = "content",
            componentInterface = IListComponent.class,
            component = ListComponent.class)
public class ListController
    extends AbstractComponentController<NaluSimpleApplicationContext, IListComponent, HTMLElement>
    implements IListComponent.Controller {

  private String name;

  private String city;

  public ListController() {
  }

  @Override
  public void start() {
    this.loadData();
  }

  @Override
  public void doRemoveControllerfromCache() {
    this.router.removeFromCache(this);
    this.context.setCachedListScreen(false);
    this.component.handleToggleButton(this.context.isCachedListScreen());
  }

  @Override
  public void doReload() {
    this.loadData();
  }

  @Override
  public void doStoreControllerInCache() {
    this.router.storeInCache(this);
    this.context.setCachedListScreen(true);
    this.component.handleToggleButton(this.context.isCachedListScreen());
  }

  @Override
  public void doUpdate(Person object) {
    this.router.route("/application/person/*/detail",
                      Long.toString(object.getId()));
  }

  @AcceptParameter("name")
  public void setName(String name) {
    this.name = name;
    this.context.setSearchName(name);
  }

  @AcceptParameter("city")
  public void setCity(String city) {
    this.city = city;
    this.context.setSearchCity(city);
  }

  private void loadData() {
    List<Person> result = PersonService.get()
                                       .get(new PersonSearch(this.name,
                                                             this.city));
    this.component.resetTable();
    this.component.setData(result);
    this.component.handleToggleButton(this.context.isCachedListScreen());
    if (result.size() == 0) {
      this.eventBus.fireEvent(new StatusChangeEvent("No person found"));
    } else if (result.size() == 1) {
      this.eventBus.fireEvent(new StatusChangeEvent("Found one person"));
    } else {
      this.eventBus.fireEvent(new StatusChangeEvent("Found " + Integer.toString(result.size()) + " persons"));
    }
  }

}
