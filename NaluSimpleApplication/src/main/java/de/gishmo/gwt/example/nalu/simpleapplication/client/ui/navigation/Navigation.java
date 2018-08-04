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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.navigation;

import com.github.mvp4g.nalu.client.ui.AbstractComponent;
import com.github.mvp4g.nalu.client.ui.annotations.Route;
import de.gishmo.gwt.example.nalu.simpleapplication.client.model.ClientContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.ui.Selectors;
import elemental2.dom.HTMLElement;

import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.EventType.click;

@Route(route = "/", selector = Selectors.NAVIGATION)
public class Navigation
  extends AbstractComponent {


  public Navigation() {
  }

  @Override
  public HTMLElement render() {
    return div().add(button().css("navigationButton")
                             .textContent("Search")
                             .on(click,
                                 event -> showSearch())
                             .asElement())
                .add(button().css("navigationButton")
                             .textContent("List")
                             .on(click,
                                 event -> showList())
                             .asElement())
                .asElement();
  }

  @Override
  public void start() {

  }

  private void showSearch() {
    if (ClientContext.get()
                     .getPersonSearch() != null) {
//      eventBus.gotoSearch(ClientContext.get()
//                                       .getPersonSearch()
//                                       .getName(),
//                          ClientContext.get()
//                                       .getPersonSearch()
//                                       .getCity());
    } else {
      this.router.route("/search");
    }
  }

  private void showList() {
    if (ClientContext.get()
                     .getPersonSearch() != null) {
//      eventBus.gotoList(ClientContext.get()
//                                     .getPersonSearch()
//                                     .getName(),
//                        ClientContext.get()
//                                     .getPersonSearch()
//                                     .getCity());
    } else {
      this.router.route("/list");
    }
  }
}
