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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail.composite.address;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.nalu.client.component.AbstractCompositeController;
import com.github.nalukit.nalu.client.component.annotation.CompositeController;
import com.google.gwt.core.client.GWT;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLElement;

@CompositeController(componentInterface = IAddressComponent.class,
                     component = AddressComponent.class)
public class AddressComposite
    extends AbstractCompositeController<NaluSimpleApplicationContext, IAddressComponent, HTMLElement>
    implements IAddressComponent.Controller {

  private Person person;

  private long id;

  public AddressComposite() {
  }

  @Override
  public void activate() {
    DomGlobal.window.alert("address composite activate-method");
  }

  @Override
  public void start() {
    GWT.debugger();
    DomGlobal.window.alert("address composite start-method");
  }

  public boolean isDirty(Person person) {
    return this.component.isDirty(person);
  }

  public void edit(Person person) {
    this.component.edit(person);
  }

  public Person flush(Person person) {
    return this.component.flush(person);
  }

}
