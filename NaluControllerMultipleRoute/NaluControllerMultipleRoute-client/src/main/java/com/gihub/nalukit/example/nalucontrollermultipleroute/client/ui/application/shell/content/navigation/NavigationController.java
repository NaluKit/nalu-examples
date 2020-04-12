package com.gihub.nalukit.example.nalucontrollermultipleroute.client.ui.application.shell.content.navigation;

import com.gihub.nalukit.example.nalucontrollermultipleroute.client.NaluControllerMultipleRouteContext;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
@Controller(
    route = "/application/",
    selector = "navigation",
    componentInterface = INavigationComponent.class,
    component = NavigationComponent.class
)
public class NavigationController
    extends AbstractComponentController<NaluControllerMultipleRouteContext, INavigationComponent, HTMLElement>
    implements INavigationComponent.Controller {
  
  public NavigationController() {
  }
  
  @Override
  public void doNavigateTo(String target) {
    switch (target) {
      case "screen01":
        router.route("/application/screen01");
        break;
      case "screen02":
        router.route("/application/screen02");
        break;
      case "screen03":
        router.route("/application/screen03");
        break;
      case "screen04":
        router.route("/application/screen04");
        break;
      case "screen05":
        router.route("/application/screen05");
        break;
    }
  }
  
}
