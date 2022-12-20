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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search.composite.toolbar;

import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search.composite.toolbar.IToolbarComponent.Controller;
import com.github.nalukit.nalu.client.component.IsCompositeComponent;
import elemental2.dom.HTMLElement;

public interface IToolbarComponent
    extends IsCompositeComponent<Controller, HTMLElement> {

  void handleToggleButton(boolean cached);

  interface Controller
      extends IsCompositeComponent.Controller {

    void doRemoveCompositefromCache();

    void doStoreCompositeInCache();

    void doFireErrorEvent();
  
    void doFireHideControlledCardEvent();
  
    void doFireShowControlledCardEvent();
  
  }

}
