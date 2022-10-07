package com.github.nalukit.nalu.complex.app.client;

import com.github.nalukit.nalu.client.application.AbstractLoader;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import com.github.nalukit.nalu.complex.app.common.ui.common.MessageFactory;
import com.github.nalukit.nalu.complex.app.shared.model.PersistanceData;
import com.github.nalukit.nalu.complex.app.shared.model.PersonSearch;
import com.github.nalukit.nalu.complex.app.shared.service.LoadApplicationServiceFactory;
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
public class AppLoader
    extends AbstractLoader<AppContext> {

  @Override
  public void load(FinishLoadCommand finishLoadCommand) {
    // enter your code here ...
    this.laodApplicationData(finishLoadCommand);
  }

  private void laodApplicationData(FinishLoadCommand finishLoadCommand) {
    LoadApplicationServiceFactory.INSTANCE.load()
                                          .onSuccess(response -> {
                                            if (response.getPersistanceData() != null) {
                                              this.context.setPersistance(response.getPersistanceData());
                                              this.context.setUserId(response.getPersistanceData()
                                                                             .getUserID());
                                            } else {
                                              this.context.setPersistance(new PersistanceData(null,
                                                                                              false,
                                                                                              new PersonSearch()));
                                            }
                                            finishLoadCommand.finishLoading();
                                          })
                                          .onFailed(response -> {
                                            MessageFactory.INSTANCE
                                                          .hideProgressBar();
                                            DomGlobal.window.alert("onFailure: Messagefactory aufrufen!");
                                          })
                                          .send();
  }

}
