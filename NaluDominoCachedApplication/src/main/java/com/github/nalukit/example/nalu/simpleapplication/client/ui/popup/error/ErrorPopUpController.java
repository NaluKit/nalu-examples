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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.popup.error;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.client.component.AbstractPopUpComponentController;
import com.github.nalukit.nalu.client.component.annotation.PopUpController;

@PopUpController(name = "ErrorPresenter",
                 componentInterface = IErrorComponent.class,
                 component = ErrorComponent.class)
public class ErrorPopUpController
    extends AbstractPopUpComponentController<NaluSimpleApplicationContext, IErrorComponent>
    implements IErrorComponent.Controller {

  public ErrorPopUpController() {
  }

  @Override
  public void onBeforeShow() {
    this.component.clear();
  }

  @Override
  public void show() {
    String message = super.dataStore.get("message");
    String route = super.dataStore.get("route");
    this.component.edit(message,
                        route);
    this.component.show();
  }

}
