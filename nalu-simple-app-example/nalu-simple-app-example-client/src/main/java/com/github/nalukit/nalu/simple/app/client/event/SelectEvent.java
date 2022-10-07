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

package com.github.nalukit.nalu.simple.app.client.event;

import org.gwtproject.event.shared.Event;

public class SelectEvent
    extends Event<SelectEvent.StatusChangeHandler> {

  public static Type<StatusChangeHandler> TYPE = new Type<StatusChangeHandler>();

  private Item item;

  public SelectEvent(Item item) {
    super();

    this.item = item;
  }

  public Item getItem() {
    return item;
  }

  @Override
  public Type<StatusChangeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(StatusChangeHandler handler) {
    handler.onStatusChange(this);
  }

  public enum Item {
    HOME,
    LIST
  }



  public interface StatusChangeHandler {

    void onStatusChange(SelectEvent event);

  }

}
