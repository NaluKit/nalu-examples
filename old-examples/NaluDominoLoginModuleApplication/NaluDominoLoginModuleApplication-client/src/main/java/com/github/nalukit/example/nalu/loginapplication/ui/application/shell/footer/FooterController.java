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

package com.github.nalukit.example.nalu.loginapplication.ui.application.shell.footer;

import com.github.nalukit.example.nalu.loginapplication.NaluLoginApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.event.NaluApplicationEvent;
import elemental2.dom.HTMLElement;

import java.util.Objects;

/**
 * this is the presenter of the shellCreator. The shellCreator divides the browser in
 * severeal areas.
 */
@Controller(route = "/[loginShell|applicationShell]",
            selector = "footer",
            componentInterface = IFooterComponent.class,
            component = FooterComponent.class)
public class FooterController
    extends AbstractComponentController<NaluLoginApplicationContext, IFooterComponent, HTMLElement>
    implements IFooterComponent.Controller {

  public FooterController() {
  }

  @Override
  public void start() {
    // add the handler registration to the HandlerRegistrations class of this controller
    // Doing that will help that once the controller gets stops all handler registrations
    // will be removed!
    this.handlerRegistrations.add(this.eventBus.addHandler(NaluApplicationEvent.TYPE,
                                                           e -> {
                                                             if ("StatusChangeEvent".equals(e.getEvent())) {
                                                               if (Objects.isNull(this.context.getUser())) {
                                                                 component.setStatus((String) e.get("message"));
                                                               } else {
                                                                 component.setStatus("User: " + this.context.getUser() + " -> " + e.get("message"));
                                                               }
                                                             }
                                                           }));
  }

}
