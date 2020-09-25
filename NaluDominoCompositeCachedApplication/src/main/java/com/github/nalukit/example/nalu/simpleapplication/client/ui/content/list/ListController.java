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
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.list.composite.ListFormComposite;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Composite;
import com.github.nalukit.nalu.client.component.annotation.Composites;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.seo.SeoDataProvider;
import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLElement;

@Controller(route = "/application/person/list/:name/:city",
            selector = "content",
            componentInterface = IListComponent.class,
            component = ListComponent.class)
@Composites({ @Composite(name = "listFormComposite",
                         compositeController = ListFormComposite.class,
                         selector = "compositeListForm") })
public class ListController
    extends AbstractComponentController<NaluSimpleApplicationContext, IListComponent, HTMLElement>
    implements IListComponent.Controller {
  
  private String name;
  
  private String city;
  
  public ListController() {
  }
  
  @Override
  public void doReload() {
    super.<ListFormComposite>getComposite("listFormComposite").doReload();
  }
  
  @Override
  public void doRemoveControllerfromCache() {
    this.router.removeFromCache(this);
    this.context.setCachedListScreen(false);
    this.component.handleToggleButton(this.context.isCachedListScreen());
  }
  
  @Override
  public void doStoreControllerInCache() {
    this.router.storeInCache(this);
    this.context.setCachedListScreen(true);
    this.component.handleToggleButton(this.context.isCachedListScreen());
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
                   .setTwitterDescription("Twitter DEscription for list");
    SeoDataProvider.get()
                   .setTwitterImage("http://www.gwtproject.org");
    SeoDataProvider.get()
                   .setTwitterSite("http://www.gwtproject.org");
    SeoDataProvider.get()
                   .setTwitterTitle("Twitter Tittle");
     
    GWT.log("ListController - activate");
  }
  
  @Override
  public void deactivate() {
    GWT.log("ListController - deactivate");
  }
  
  @Override
  public void start() {
    super.<ListFormComposite>getComposite("listFormComposite").loadData(this.name,
                                                                        this.city);
    GWT.log("ListController - start");
  }
  
  @Override
  public void stop() {
    GWT.log("ListController - stop");
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
  
}
