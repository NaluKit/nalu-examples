/*
 * Copyright (C) 2018 - 2021 - Frank Hossfeld
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

package com.github.nalukit.nalu.simple.app.client.event;

import org.gwtproject.event.shared.Event;

public class HideAllEvent
    extends Event<HideAllEvent.HideAllHandler> {

  public static Type<HideAllHandler> TYPE = new Type<>();

  public HideAllEvent() {
    super();
  }

  @Override
  public Type<HideAllHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(HideAllHandler handler) {
    handler.onHideAll(this);
  }

  public interface HideAllHandler {

    void onHideAll(HideAllEvent event);

  }

}
