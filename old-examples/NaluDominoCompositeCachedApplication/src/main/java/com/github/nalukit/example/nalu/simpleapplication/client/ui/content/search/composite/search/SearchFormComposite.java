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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search.composite.search;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StoreSearchCompositeEvent;
import com.github.nalukit.nalu.client.component.AbstractCompositeController;
import com.github.nalukit.nalu.client.component.annotation.CompositeController;
import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLElement;

@CompositeController(componentInterface = ISearchFormComponent.class,
                     component = SearchFormComponent.class)
public class SearchFormComposite
    extends AbstractCompositeController<NaluSimpleApplicationContext, ISearchFormComponent, HTMLElement>
    implements ISearchFormComponent.Controller {

  public SearchFormComposite() {
  }

  @Override
  public void start() {
    super.handlerRegistrations.compose(this.eventBus.addHandler(StoreSearchCompositeEvent.TYPE,
                                                                e -> {
                                                                  if (e.isCached()) {
                                                                    this.router.storeInCache(this);
                                                                    this.context.setCachedSearchDataCompositeScreen(true);
                                                                  } else {
                                                                    this.router.removeFromCache(this);
                                                                    this.context.setCachedSearchDataCompositeScreen(false);
                                                                  }
                                                                }));
    GWT.log("SeqrchComposite - start");
  }
  
  @Override
  public void activate() {
    GWT.log("SeqrchComposite - activate");
  }
  
  @Override
  public void deactivate() {
    GWT.log("SeqrchComposite - deactivate");
  }
  
  @Override
  public void stop() {
    GWT.log("SeqrchComposite - stop");
  }

  public String getSearchName() {
    return this.component.getSearchName();
  }

  public void setSearchName(String searchName) {
    this.component.setSearchName(searchName);
  }

  public String getSearchCity() {
    return this.component.getSearchCity();
  }

  public void setSearchCity(String searchCity) {
    this.component.setSearchCity(searchCity);
  }

}
