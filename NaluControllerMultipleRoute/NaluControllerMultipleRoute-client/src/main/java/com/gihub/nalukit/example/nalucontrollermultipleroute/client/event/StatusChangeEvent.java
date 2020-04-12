package com.gihub.nalukit.example.nalucontrollermultipleroute.client.event;

import org.gwtproject.event.shared.Event;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class StatusChangeEvent
    extends Event<StatusChangeEvent.StatusChangeEventHandler> {
  
  public static Event.Type<StatusChangeEvent.StatusChangeEventHandler> TYPE = new Event.Type<>();
  
  private final String status;
  
  public StatusChangeEvent(String status) {
    super();
    this.status = status;
  }
  
  public String getStatus() {
    return this.status;
  }
  
  @Override
  public Event.Type<StatusChangeEvent.StatusChangeEventHandler> getAssociatedType() {
    return TYPE;
  }
  
  @Override
  public void dispatch(StatusChangeEvent.StatusChangeEventHandler handler) {
    handler.onStatusChange(this);
  }
  
  public interface StatusChangeEventHandler {
    
    void onStatusChange(StatusChangeEvent event);
    
  }
  
}
