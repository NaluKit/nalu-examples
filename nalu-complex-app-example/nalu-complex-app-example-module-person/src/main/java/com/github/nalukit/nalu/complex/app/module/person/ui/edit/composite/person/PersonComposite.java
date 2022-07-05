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

package com.github.nalukit.nalu.complex.app.module.person.ui.edit.composite.person;

import com.github.nalukit.nalu.client.component.IsComponentCreator;
import com.github.nalukit.nalu.client.component.annotation.CompositeController;
import com.github.nalukit.nalu.complex.app.common.ui.AbstractAppCompositeController;
import com.github.nalukit.nalu.complex.app.shared.model.person.Person;

@CompositeController(componentInterface = IPersonComponent.class, component = PersonComponent.class)
public class PersonComposite
    extends AbstractAppCompositeController<IPersonComponent>
    implements IPersonComponent.Controller,
               IsComponentCreator<IPersonComponent> {

  private long id;

  public PersonComposite() {
  }

  public boolean isDirty(Person person) {
    return this.component.isDirty();
  }

  public void edit(Person person) {
    this.component.edit(person);
  }

  public Person flush(Person person) {
    return this.component.flush();
  }

  @Override
  public IPersonComponent createComponent() {
    return new PersonComponent();
  }

}
