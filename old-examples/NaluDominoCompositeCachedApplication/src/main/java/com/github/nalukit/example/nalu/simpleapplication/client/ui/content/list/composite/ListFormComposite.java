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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.list.composite;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.PersonSearch;
import com.github.nalukit.example.nalu.simpleapplication.client.data.service.PersonService;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.client.component.AbstractCompositeController;
import com.github.nalukit.nalu.client.component.annotation.CompositeController;
import com.github.nalukit.nalu.client.seo.SeoDataProvider;
import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLElement;

import java.util.List;

@CompositeController(componentInterface = IListFormComponent.class,
                     component = ListFormComponent.class)
public class ListFormComposite
    extends AbstractCompositeController<NaluSimpleApplicationContext, IListFormComponent, HTMLElement>
    implements IListFormComponent.Controller {
  
  private String name;
  
  private String city;
  
  public ListFormComposite() {
  }
  
  @Override
  public void start() {
    this.loadData(this.name,
                  this.city);
    GWT.log("ListFormComposite - start");
  }
  
  @Override
  public void deactivate() {
    GWT.log("ListFormComposite - deactivate");
  }
  
  @Override
  public void stop() {
    GWT.log("ListFormComposite - stop");
  }
  
  @Override
  public void doReload() {
    this.loadData(this.name,
                  this.city);
  }
  
  @Override
  public void doUpdate(Person object) {
    this.router.route("/application/person/*/detail",
                      Long.toString(object.getId()));
  }
  
  @Override
  public void activate() {
    SeoDataProvider.get()
                   .setTitle("Example - List Persons for Name:: >>" + name + "<< and city: >>" + city + "<<");
    SeoDataProvider.get()
                   .setKeywords("Personen, list, cool");
    SeoDataProvider.get()
                   .setRobots("noindex,nofollow");
    SeoDataProvider.get()
                   .setOgDescription("I am OG description for the list...");
    SeoDataProvider.get()
                   .setOgImage("http://www.gwtproject.org");
    SeoDataProvider.get()
                   .setOgSiteName("Max Mustermann");
    SeoDataProvider.get()
                   .setOgTitle("Title: Max Mustermann");
    SeoDataProvider.get()
                   .setOgType("Type: Max Mustermann");
    SeoDataProvider.get()
                   .setOgUrl("http://www.gwtproject.org");
    SeoDataProvider.get()
                   .setTwitterCard("Twitter Card for list: Max Mustermann");
    SeoDataProvider.get()
                   .setTwitterCreator("Twitter Creator for list");
    SeoDataProvider.get()
                   .setTwitterDescription("Twitter Description for list");
    SeoDataProvider.get()
                   .setTwitterImage("http://www.gwtproject.org");
    SeoDataProvider.get()
                   .setTwitterSite("http://www.gwtproject.org");
    SeoDataProvider.get()
                   .setTwitterTitle("Twitter Tittle");
    
    this.fireSatusEvent(this.component.getPersonList());
    GWT.log("ListFormComposite - activate");
  }
    
  public void loadData(String name,
                       String city) {
    this.name = name;
    this.city = city;
    List<Person> result = PersonService.get()
                                       .get(new PersonSearch(this.name,
                                                             this.city));
    this.component.resetTable();
    this.component.setData(result);
    fireSatusEvent(result);
  }
  
  private void fireSatusEvent(List<Person> result) {
    if (result.size() == 0) {
      this.eventBus.fireEvent(new StatusChangeEvent("No person found"));
    } else if (result.size() == 1) {
      this.eventBus.fireEvent(new StatusChangeEvent("Found one person"));
    } else {
      this.eventBus.fireEvent(new StatusChangeEvent("Found " + result.size() + " persons"));
    }
  }
}
