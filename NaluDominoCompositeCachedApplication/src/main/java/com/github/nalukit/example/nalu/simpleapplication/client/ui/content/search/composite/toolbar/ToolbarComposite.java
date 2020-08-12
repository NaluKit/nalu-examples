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

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StoreSearchCompositeEvent;
import com.github.nalukit.nalu.client.component.AbstractCompositeController;
import com.github.nalukit.nalu.client.component.annotation.CompositeController;
import com.github.nalukit.nalu.client.component.event.HideBlockComponentEvent;
import com.github.nalukit.nalu.client.component.event.ShowBlockComponentEvent;
import com.github.nalukit.nalu.client.event.NaluErrorEvent;
import com.github.nalukit.nalu.client.event.model.ErrorInfo.ErrorType;
import elemental2.dom.HTMLElement;

@CompositeController(componentInterface = IToolbarComponent.class,
                     component = ToolbarComponent.class)
public class ToolbarComposite
    extends AbstractCompositeController<NaluSimpleApplicationContext, IToolbarComponent, HTMLElement>
    implements IToolbarComponent.Controller {

  public ToolbarComposite() {
  }

  @Override
  public void start() {
    this.component.handleToggleButton(this.context.isCachedSearchDataCompositeScreen());
  }

  @Override
  public void doRemoveCompositefromCache() {
    this.eventBus.fireEvent(new StoreSearchCompositeEvent(false));
    this.component.handleToggleButton(this.context.isCachedSearchDataCompositeScreen());
  }

  @Override
  public void doStoreCompositeInCache() {
    this.eventBus.fireEvent(new StoreSearchCompositeEvent(true));
    this.component.handleToggleButton(this.context.isCachedSearchDataCompositeScreen());
  }

  @Override
  public void doFireErrorEvent() {
    this.eventBus.fireEvent(NaluErrorEvent.createApplicationError()
                                          .route("/application/person/search")
                                          .message("Oh, nothing wrong ... only wonna show a nice error dialog!")
                                          .data("key01",
                                                "first parameter")
                                          .data("key02",
                                                "second parameter"));
  }
  
  @Override
  public void doFireHideControlledCardEvent() {
    this.eventBus.fireEvent(HideBlockComponentEvent.hide("controlledBlock"));
  }
  
  @Override
  public void doFireShowControlledCardEvent() {
    this.eventBus.fireEvent(ShowBlockComponentEvent.show("controlledBlock"));
  }
  
}
