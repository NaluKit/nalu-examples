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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.navigation;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.event.SelectEvent;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;

@Controller(route = "/application",
            selector = "navigation",
            componentInterface = INavigationComponent.class,
            component = NavigationComponent.class)
public class NavigationController
    extends AbstractComponentController<NaluSimpleApplicationContext, INavigationComponent, HTMLElement>
    implements INavigationComponent.Controller {

  public NavigationController() {
  }

  @Override
  public void start() {
    this.eventBus.addHandler(SelectEvent.TYPE,
                             e -> component.select(e.getSelect()));
  }
  
  @Override
  public void doLogoff() {
    this.router.route("/loginShell/login");
  }
  
  @Override
  public void doShowSearch() {
    this.router.route("/application/person/search");
  }

  @Override
  public void doShowList() {
    this.router.route("/application/person/list",
                      this.context.getSearchName(),
                      this.context.getSearchCity());
  }

  @Override
  public void doShowComposites01Test() {
    this.router.route("/application/test/composite01/conditional",
                      String.valueOf(System.currentTimeMillis()));
  }

  @Override
  public void doShowComposites02Test() {
    this.router.route("/application/test/composite02/conditional",
                      String.valueOf(System.currentTimeMillis()));
  }

}
