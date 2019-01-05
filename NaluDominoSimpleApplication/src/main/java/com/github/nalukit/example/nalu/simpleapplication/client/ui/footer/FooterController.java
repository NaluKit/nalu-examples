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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.footer;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;

/**
 * this is the presenter of the shellCreator. The shellCreator divides the browser in
 * severeal areas.
 */
@Controller(route = "/application",
            selector = "footer",
            componentInterface = IFooterComponent.class,
            component = FooterComponent.class)
public class FooterController
    extends AbstractComponentController<NaluSimpleApplicationContext, IFooterComponent, HTMLElement>
    implements IFooterComponent.Controller {

  public FooterController() {
  }

  @Override
  public void start() {
    // add the handler registration to the HandlerRegistrations class of this controller
    // Doing that will help that once the controller gets stops all handler registrations
    // will be removed!
    this.handlerRegistrations.add(this.eventBus.addHandler(StatusChangeEvent.TYPE,
                                                           e -> component.setStatus(e.getStatus())));
  }

}
