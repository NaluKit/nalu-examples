package de.gishmo.example.devk.client.ui.error.content;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import de.gishmo.example.devk.client.ApplicationContext;
import de.gishmo.example.devk.client.Routes;
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
@Controller(route = Routes.ROUTE_ERROR,
            selector = "content",
            componentInterface = IErrorComponent.class,
            component = ErrorComponent.class)
public class ErrorController
    extends AbstractComponentController<ApplicationContext, IErrorComponent, HTMLElement>
    implements IErrorComponent.Controller {

  public ErrorController() {
  }

  @Override
  public void start() {
    // Get the error message from the router and set it.
    this.component.setErrorMessage(this.router.getNaluErrorMessage()
                                              .getErrorMessage());
  }

  @Override
  public void doRouteHome() {
    this.router.route("/application/screen01");
  }

}
