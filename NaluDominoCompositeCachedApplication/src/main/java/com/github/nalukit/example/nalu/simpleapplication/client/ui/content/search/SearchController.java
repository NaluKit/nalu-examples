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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.event.SelectEvent;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search.composite.search.SearchFormComposite;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search.composite.toolbar.ToolbarComposite;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Composite;
import com.github.nalukit.nalu.client.component.annotation.Composites;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.seo.SeoDataProvider;
import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLElement;

@Controller(route = "/application/person/search",
            selector = "content",
            component = SearchComponent.class,
            componentInterface = ISearchComponent.class)
@Composites({ @Composite(name = "searchFormComposite",
                         compositeController = SearchFormComposite.class,
                         selector = "compositeSearchForm"),
              @Composite(name = "toolbarComposite",
                         compositeController = ToolbarComposite.class,
                         selector = "compositeToolbar") })
public class SearchController
    extends AbstractComponentController<NaluSimpleApplicationContext, ISearchComponent, HTMLElement>
    implements ISearchComponent.Controller {

  public SearchController() {
  }
  
  @Override
  public void start() {
    GWT.log("SearchController - start");
  }
  
  @Override
  public void activate() {
    SeoDataProvider.get().setTitle("Example - Search Persons ...");
    GWT.log("SearchController - activate");
  }
  
  @Override
  public void deactivate() {
    GWT.log("SearchController - deactivate");
  }
  
  @Override
  public void stop() {
    GWT.log("SearchController - stop");
  }

  @Override
  public void doClickSearchButton() {
    this.router.route("/application/person/list",
                      super.<SearchFormComposite>getComposite("searchFormComposite").getSearchName(),
                      super.<SearchFormComposite>getComposite("searchFormComposite").getSearchCity());
  }

  @Override
  public void doClear() {
    super.<SearchFormComposite>getComposite("searchFormComposite").setSearchName("");
    super.<SearchFormComposite>getComposite("searchFormComposite").setSearchCity("");
  }

}
