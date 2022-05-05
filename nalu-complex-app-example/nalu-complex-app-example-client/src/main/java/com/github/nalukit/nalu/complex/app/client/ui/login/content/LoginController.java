package com.github.nalukit.nalu.complex.app.client.ui.login.content;

import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.complex.app.common.ui.AbstractAppComponentController;
import com.github.nalukit.nalu.complex.app.common.ui.Routes;
import com.github.nalukit.nalu.complex.app.common.ui.Slots;
import com.github.nalukit.nalu.complex.app.common.ui.common.MessageFactory;
import com.github.nalukit.nalu.complex.app.common.util.RestResponseHandler;
import com.github.nalukit.nalu.complex.app.shared.service.LogonServiceFactory;
import com.github.nalukit.nalu.complex.app.shared.transport.request.LogonRequest;
import elemental2.dom.DomGlobal;

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
@Controller(route = Routes.ROUTE_LOGON,
            selector = Slots.SELECTOR_CONTENT,
            componentInterface = ILoginComponent.class,
            component = LoginComponent.class)
public class LoginController
    extends AbstractAppComponentController<ILoginComponent>
    implements ILoginComponent.Controller {

  public LoginController() {
  }

  @Override
  public void doLogin(String userId,
                      String password) {
    // Merken wir uns zunächst die userId & mandantNr im Contrext...
    this.context.setUserId(userId);
    // und dann melden wir uns an ...
    MessageFactory.get()
                  .showProgressBar();
    LogonRequest request = new LogonRequest(userId,
                                            password);
    LogonServiceFactory.INSTANCE.login(request)
                                .onSuccess(response -> RestResponseHandler.builder()
                                                                          .executeIfStatuscodeIsOk(() -> {
                                                                            this.context.setPersistance(response.getPersistanceData());
                                                                            this.router.route(Routes.ROUTE_HOME);
                                                                          })

                                                                          .build()
                                                                          .handle())
                                .onFailed(response -> handleOnFailed(LoginController.class,
                                                                     response,
                                                                     "doLogin",
                                                                     () -> {
                                                                       DomGlobal.window.alert("PANIC!!!!!");
                                                                       MessageFactory.get()
                                                                                     .hideProgressBar();
                                                                     }))
                                .send();
  }

}
