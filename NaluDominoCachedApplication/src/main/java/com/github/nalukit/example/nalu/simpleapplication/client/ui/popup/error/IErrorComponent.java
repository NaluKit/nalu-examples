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

import com.github.nalukit.example.nalu.simpleapplication.client.ui.popup.error.IErrorComponent.Controller;
import com.github.nalukit.nalu.client.component.IsPopUpComponent;

public interface IErrorComponent
    extends IsPopUpComponent<Controller> {

  void clear();

  void edit(String message,
            String route);

  void hide();

  void show();

  interface Controller
      extends IsPopUpComponent.Controller {

  }

}