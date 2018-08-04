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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.content.list;

import com.github.mvp4g.nalu.client.ui.AbstractComponent;
import com.github.mvp4g.nalu.client.ui.annotations.Route;
import de.gishmo.gwt.example.nalu.simpleapplication.client.ui.Routs;
import de.gishmo.gwt.example.nalu.simpleapplication.client.ui.Selectors;
import de.gishmo.gwt.example.nalu.simpleapplication.client.widgets.TextField;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLElement;

import static org.jboss.gwt.elemento.core.Elements.div;

@Route(route = Routs.LIST, selector = Selectors.CONTENT)
public class List
  extends AbstractComponent {

  private TextField         searchName;
  private TextField         searchCity;
  private HTMLButtonElement searchButton;
  private HTMLButtonElement resetButton;

  public List() {
  }

  @Override
  public HTMLElement render() {
    return div().add(div().style("width: 100%"))
                .add(div().css("headline")
                          .textContent("Search Results"))
                .asElement();
  }

  @Override
  public void start() {

  }

  private void clickSearchButton(String searchName,
                                 String searchCity) {
    // fuer NavigatiponPresenter speichern ...
//    ClientContext.get()
//                 .setPersonSearch(new PersonSearch(searchName,
//                                                   searchCity));
//    eventBus.gotoList(searchName,
//                      searchCity);
    this.router.route("/list");
  }
}
