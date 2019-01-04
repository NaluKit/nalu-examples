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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.error;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;

import java.util.Objects;

@Controller(route = "/error/show",
            selector = "content",
            component = ErrorComponent.class,
            componentInterface = IErrorComponent.class)
public class ErrorController
    extends AbstractComponentController<NaluSimpleApplicationContext, IErrorComponent, HTMLElement>
    implements IErrorComponent.Controller {

  public ErrorController() {
  }

  @Override
  public void start() {
    if (Objects.isNull(this.router.getNaluErrorMessage()) ||
        this.router.getNaluErrorMessage()
                   .getErrorMessage()
                   .trim()
                   .length() == 0) {
      this.router.route("/application/person/search");
    } else {
      this.component.setErrorText(this.router.getNaluErrorMessage()
                                             .getErrorMessage());
    }
  }

  @Override
  public void doRouteHome() {
    // clear the error message to avoid showing it again!
    this.router.clearNaluErrorMessage();
    // route to the search screen
    this.router.route("/application/person/search");
  }

}
