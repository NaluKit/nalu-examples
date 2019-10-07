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

package com.github.nalukit.example.nalu.loginapplication.handler;

import com.github.nalukit.example.nalu.loginapplication.NaluLoginApplicationContext;
import com.github.nalukit.nalu.client.event.NaluApplicationEvent;
import com.github.nalukit.nalu.client.handler.AbstractHandler;
import com.github.nalukit.nalu.client.handler.annotation.Handler;
import elemental2.dom.DomGlobal;

@Handler
public class ApplicationHandler02
    extends AbstractHandler<NaluLoginApplicationContext> {

  public ApplicationHandler02() {
  }

  @Override
  public void bind() {
    this.eventBus.addHandler(NaluApplicationEvent.TYPE,
                             e -> {
                               if ("StatusEvent".equals(e.getEvent())) {
                                 // Stupid idea! It should only show, that the event was catched by the handler!
                                 DomGlobal.window.console.log("new Status:" + e.get("message"));
                               }
                             });
  }

}
