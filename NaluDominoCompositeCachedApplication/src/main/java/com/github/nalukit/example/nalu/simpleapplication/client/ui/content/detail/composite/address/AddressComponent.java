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

import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail.composite.address.IAddressComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractCompositeComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.gwt.elemento.core.Elements;

public class AddressComponent
    extends AbstractCompositeComponent<Controller, HTMLElement>
    implements IAddressComponent {

  private TextBox detailStreet;

  private TextBox detailZip;

  private TextBox detailCity;

  public AddressComponent() {
  }

  @Override
  public void render() {
    this.detailStreet = TextBox.create("Street");
    this.detailZip = TextBox.create("ZIP");
    this.detailCity = TextBox.create("City");

    HTMLDivElement divElemet = Elements.div()
                                       .asElement();

    divElemet.appendChild(Card.create("Details - Address")
                              .appendChild(Row.create()
                                              .addColumn(Column.span12()
                                                               .appendChild(this.detailStreet)))
                              .appendChild(Row.create()
                                              .addColumn(Column.span12()
                                                               .appendChild(this.detailZip)))
                              .appendChild(Row.create()
                                              .addColumn(Column.span12()
                                                               .appendChild(this.detailCity)))
                              .asElement());

    initElement(divElemet);
  }

  @Override
  public void edit(Person result) {
    if (result != null) {
      detailStreet.setValue(result.getAddress()
                                  .getStreet());
      detailZip.setValue(result.getAddress()
                               .getZip());
      detailCity.setValue(result.getAddress()
                                .getCity());
    }
  }

  @Override
  public boolean isDirty(Person person) {
    boolean notDirty = ((person.getAddress()
                               .getStreet()
                               .equals(detailStreet.getValue())) &&

                        (person.getAddress()
                               .getZip()
                               .equals(detailZip.getValue())) &&

                        (person.getAddress()
                               .getCity()
                               .equals(detailCity.getValue())));
    return !notDirty;
  }

  @Override
  public Person flush(Person person) {
    person.getAddress()
          .setStreet(detailStreet.getValue());
    person.getAddress()
          .setZip(detailZip.getValue());
    person.getAddress()
          .setCity(detailCity.getValue());
    return person;
  }

}
