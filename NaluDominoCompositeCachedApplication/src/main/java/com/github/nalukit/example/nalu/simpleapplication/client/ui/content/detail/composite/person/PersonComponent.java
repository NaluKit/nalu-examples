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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail.composite.person;

import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail.composite.person.IPersonComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractCompositeComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.gwt.elemento.core.Elements;

public class PersonComponent
    extends AbstractCompositeComponent<Controller, HTMLElement>
    implements IPersonComponent {

  private TextBox detailFirstName;

  private TextBox detailName;

  public PersonComponent() {
  }

  @Override
  public void render() {
    this.detailFirstName = TextBox.create("First name");
    this.detailName = TextBox.create("Name");

    HTMLDivElement divElemet = Elements.div()
                                       .asElement();

    divElemet.appendChild(Card.create("Details - Person")
                              .appendChild(Row.create()
                                              .addColumn(Column.span12()
                                                               .appendChild(this.detailFirstName)))
                              .appendChild(Row.create()
                                              .addColumn(Column.span12()
                                                               .appendChild(this.detailName)))
                              .asElement());

    initElement(divElemet);
  }

  @Override
  public void edit(Person result) {
    if (result != null) {
      detailFirstName.setValue(result.getFirstName());
      detailName.setValue(result.getName());
    }
  }

  @Override
  public boolean isDirty(Person person) {
    boolean notDirty = (person.getFirstName()
                              .equals(detailFirstName.getValue())) &&

                       (person.getName()
                              .equals(detailName.getValue()));
    return !notDirty;
  }

  @Override
  public Person flush(Person person) {
    person.setFirstName(detailFirstName.getValue());
    person.setName(detailName.getValue());
    return person;
  }

}
