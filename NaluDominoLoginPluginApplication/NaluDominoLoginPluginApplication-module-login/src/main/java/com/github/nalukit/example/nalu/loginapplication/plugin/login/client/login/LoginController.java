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

package com.github.nalukit.example.nalu.loginapplication.plugin.login.client.login;

import com.github.nalukit.example.nalu.loginapplication.plugin.login.client.NaluLoginApplicationContextLoginModule;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.event.NaluApplicationEvent;
import com.google.gwt.core.client.GWT;
import elemental2.dom.HTMLElement;

@Controller(route = "/loginShell/login",
            selector = "content",
            component = LoginComponent.class,
            componentInterface = ILoginComponent.class)
public class LoginController
    extends AbstractComponentController<NaluLoginApplicationContextLoginModule, ILoginComponent, HTMLElement>
    implements ILoginComponent.Controller {

  public LoginController() {
  }

  @Override
  public void start() {
    GWT.debugger();
    this.eventBus.fireEvent(NaluApplicationEvent.create()
                                                .event("StatusEvent")
                                                .data("message",
                                           "Please enter your credentials!"));
  }

  @Override
  public void doLogin(String userId,
                      String password) {
    GWT.debugger();
    this.context.setLoggedIn(true);
    this.context.setUser(userId);
    // we are always happy with the credential ....
    this.router.route("/applicationShell/person/search");
  }

}
