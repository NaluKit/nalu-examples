/*
 * Copyright (c) 2018 - Frank Hossfeld
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

package com.github.nalukit.example.nalu.loginapplication.ui.shell.application.navigation;

import com.github.nalukit.example.nalu.loginapplication.core.client.NaluLoginApplicationContext;
import com.github.nalukit.example.nalu.loginapplication.event.SelectEvent;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;

@Controller(route = "/applicationShell",
            selector = "navigation",
            componentInterface = INavigationComponent.class,
            component = NavigationComponent.class)
public class NavigationController
    extends AbstractComponentController<NaluLoginApplicationContext, INavigationComponent, HTMLElement>
    implements INavigationComponent.Controller {

  public NavigationController() {
  }

  @Override
  public void start() {
    this.eventBus.addHandler(SelectEvent.TYPE,
                             e -> component.select(e.getSelect()
                                                    .toString()));
  }

  @Override
  public void doShowSearch() {
    this.router.route("/applicationShell/person/search",
                      this.context.getSearchName(),
                      this.context.getSearchCity());
  }

  @Override
  public void doShowList() {
    this.router.route("/applicationShell/person/list",
                      this.context.getSearchName(),
                      this.context.getSearchCity());
  }
}
