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

package com.github.nalukit.nalu.complex.app.module.person.event;

import org.gwtproject.event.shared.Event;

public class PersonListEvent
    extends Event<PersonListEvent.PersonListHandler> {

  public static Type<PersonListHandler> TYPE = new Type<>();
  private       Task                    task;

  public PersonListEvent(Task task) {
    super();
    this.task = task;
  }

  public Task getTask() {
    return task;
  }

  @Override
  public Type<PersonListHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(PersonListHandler handler) {
    handler.onPersonListEvent(this);
  }

  public enum Task {

    REFRESH

  }



  public interface PersonListHandler {

    void onPersonListEvent(PersonListEvent event);

  }

}
