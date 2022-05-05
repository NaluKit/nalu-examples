/*
 * Copyright (C) 2018 - 2021 - Frank Hossfeld
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

package com.github.nalukit.nalu.complex.app.client.ui.common.popup.error;

import com.github.nalukit.nalu.client.component.AbstractErrorPopUpComponentController;
import com.github.nalukit.nalu.client.component.annotation.ErrorPopUpController;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import com.github.nalukit.nalu.complex.app.common.event.HideAllEvent;
import com.github.nalukit.nalu.complex.app.common.ui.Routes;
import com.github.nalukit.nalu.complex.app.common.ui.common.MessageFactory;

@ErrorPopUpController(component = ErrorComponent.class, componentInterface = IErrorComponent.class)
public class ErrorController
    extends AbstractErrorPopUpComponentController<AppContext, IErrorComponent>
    implements IErrorComponent.Controller {

  public ErrorController() {
  }

  @Override
  public void onBeforeShow() {
    this.component.clear();
  }

  @Override
  protected void show() {
    this.eventBus.fireEvent(new HideAllEvent());
    MessageFactory.get()
                  .hideProgressBar();
    this.component.edit(this.errorEventType,
                        this.route,
                        this.message,
                        this.dataStore);
    this.component.show();
  }

  @Override
  public void doRouteHome() {
    //    if (this.context.isLoggedIn()) {
    this.router.route(Routes.ROUTE_HOME);
    //    } else {
    this.router.route(Routes.ROUTE_LOGON);
    //    }
  }

}
