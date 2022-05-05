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

import com.github.nalukit.nalu.client.component.AbstractCompositeComponent;
import com.github.nalukit.nalu.complex.app.shared.model.Person;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.gwtproject.editor.client.Editor;
import org.gwtproject.editor.client.SimpleBeanEditorDriver;
import org.gwtproject.editor.client.annotation.IsDriver;
import org.jboss.elemento.Elements;
import org.jboss.elemento.HtmlContentBuilder;

public class PersonComponent
    extends AbstractCompositeComponent<IPersonComponent.Controller, HTMLElement>
    implements IPersonComponent,
               Editor<Person> {

  @Path("firstName")
  TextBox detailFirstName;
  @Path("name")
  TextBox detailName;

  private Driver driver;

  public PersonComponent() {
  }

  @Override
  public void bind() {
    this.driver = new PersonComponent_Driver_Impl();
    this.driver.initialize(this);
  }

  @Override
  public void render() {
    this.detailFirstName = TextBox.create("First name");
    this.detailName      = TextBox.create("Name");

    HtmlContentBuilder<HTMLDivElement> divElemet = Elements.div();

    divElemet.add(Card.create("Details - Person")
                      .appendChild(Row.create()
                                      .addColumn(Column.span12()
                                                       .appendChild(this.detailFirstName)))
                      .appendChild(Row.create()
                                      .addColumn(Column.span12()
                                                       .appendChild(this.detailName))));

    initElement(divElemet.element());
  }

  @Override
  public void edit(Person result) {
    driver.edit(result);
  }

  @Override
  public boolean isDirty() {
    return driver.isDirty();
  }

  @Override
  public Person flush() {
    return driver.flush();
  }

  @IsDriver
  interface Driver
      extends SimpleBeanEditorDriver<Person, PersonComponent> {
  }

}
