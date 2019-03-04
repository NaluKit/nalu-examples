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

package com.github.nalukit.example.nalu.loginapplication.core.client.tracking.event;

import org.gwtproject.event.shared.Event;

public class LinkSelectedEvent
    extends Event<LinkSelectedEvent.ButtonPressedHandler> {

  public static Type<ButtonPressedHandler> TYPE = new Type<ButtonPressedHandler>();

  private String message;

  public LinkSelectedEvent(String message) {
    super();
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  @Override
  public Type<ButtonPressedHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(ButtonPressedHandler handler) {
    handler.onButtonPressed(this);
  }

  public interface ButtonPressedHandler {

    void onButtonPressed(LinkSelectedEvent event);

  }

}
