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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.error.content.error;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.google.gwt.user.client.ui.Widget;
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
    if (Objects.isNull(this.context.getErrorInfo())) {
      this.router.route("application/search");
      return;
    }
    this.component.edit(this.context.getErrorInfo());
  }

  @Override
  public void doClickOkButton() {
    this.context.setErrorInfo(null);
    this.router.route("application/search");
  }

}
