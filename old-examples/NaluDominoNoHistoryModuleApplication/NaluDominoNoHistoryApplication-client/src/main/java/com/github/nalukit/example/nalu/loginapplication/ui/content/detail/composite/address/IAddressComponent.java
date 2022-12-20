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

package com.github.nalukit.example.nalu.loginapplication.ui.content.detail.composite.address;

import com.github.nalukit.example.nalu.loginapplication.shared.data.model.dto.Person;
import com.github.nalukit.example.nalu.loginapplication.ui.content.detail.composite.address.IAddressComponent.Controller;
import com.github.nalukit.nalu.client.component.IsComponent;
import com.github.nalukit.nalu.client.component.IsCompositeComponent;
import elemental2.dom.HTMLElement;

public interface IAddressComponent
    extends IsCompositeComponent<Controller, HTMLElement> {

  void edit(Person result);

  boolean isDirty(Person person);

  Person flush(Person person);

  interface Controller
      extends IsCompositeComponent.Controller {

  }
}
