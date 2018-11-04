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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;

import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.EventType.click;

public class NavigationComponent
    extends AbstractComponent<INavigationComponent.Controller, HTMLElement>
    implements INavigationComponent {

  public NavigationComponent() {
  }

  @Override
  public void render() {
    initElement(div().add(button().css("navigationButton")
                                  .textContent("Search")
                                  .on(click,
                                      event -> showSearch())
                                  .asElement())
                     .add(button().css("navigationButton")
                                  .textContent("List")
                                  .on(click,
                                      event -> showList())
                                  .asElement())
                     .asElement());
  }

  private void showSearch() {
    getController().doShowSearch();
  }

  private void showList() {
    getController().doShowList();
  }
}
