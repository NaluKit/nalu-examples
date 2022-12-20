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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.application.content.search;

import com.github.nalukit.example.nalu.simpleapplication.client.widgets.TextField;
import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;

import static import org.jboss.elemento.Elements;.button;
import static import org.jboss.elemento.Elements;.div;
import static org.jboss.gwt.elemento.core.EventType.click;

public class SearchComponent
    extends AbstractComponent<ISearchComponent.Controller, HTMLElement>
    implements ISearchComponent {

  private TextField searchName;

  private TextField searchCity;

  public SearchComponent() {
  }

  @Override
  public void render() {
    initElement(div().add(div().style("width: 100%;")
                               .add(div().css("headline")
                                         .textContent("Search Parameter (search for: 'S' or 'D')"))
                               .add(searchName = new TextField("Name"))
                               .add(searchCity = new TextField("City"))
                               .add(div().css("buttonBar")
                                         .add(button().css("button")
                                                      .textContent("Search")
                                                      .on(click,
                                                          event -> getController().doClickSearchButton(searchName.getText(),
                                                                                                       searchCity.getText())))
                                         .add(button().css("button")
                                                      .textContent("Reset")
                                                      .on(click,
                                                          event -> {
                                                            searchName.setText("");
                                                            searchCity.setText("");
                                                          }))))
                     .element());
  }

  @Override
  public void setSearchName(String searchName) {
    this.searchName.setText(searchName);
  }

  @Override
  public void setSearchCity(String searchCity) {
    this.searchCity.setText(searchCity);
  }

}
