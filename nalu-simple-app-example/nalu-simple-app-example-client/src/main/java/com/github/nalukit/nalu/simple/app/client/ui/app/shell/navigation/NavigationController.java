/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package com.github.nalukit.nalu.simple.app.client.ui.app.shell.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.event.annotation.EventHandler;
import com.github.nalukit.nalu.simple.app.client.AppContext;
import com.github.nalukit.nalu.simple.app.client.event.SelectEvent;
import com.github.nalukit.nalu.simple.app.client.ui.Routes;
import com.github.nalukit.nalu.simple.app.client.ui.Slots;
import com.github.nalukit.nalu.simple.app.client.ui.common.MessageFactory;
import elemental2.dom.HTMLElement;

@Controller(route = Routes.ROUTE_HOME,
            selector = Slots.SELECTOR_NAVIGATION,
            componentInterface = INavigationComponent.class,
            component = NavigationComponent.class)
public class NavigationController
    extends AbstractComponentController<AppContext, INavigationComponent, HTMLElement>
    implements INavigationComponent.Controller {

  public NavigationController() {
  }

  @Override
  public void start() {
  }

  @EventHandler
  public void onSelect(SelectEvent event) {
    this.component.select(event.getItem());
  }

  @Override
  public void doGotoHome() {
    MessageFactory.INSTANCE
                  .showProgressBar();
    this.router.route(Routes.ROUTE_HOME);
  }

  @Override
  public void doGotoList() {
    MessageFactory.INSTANCE
                  .showProgressBar();
    this.router.route(Routes.ROUTE_HOME);
  }

}
