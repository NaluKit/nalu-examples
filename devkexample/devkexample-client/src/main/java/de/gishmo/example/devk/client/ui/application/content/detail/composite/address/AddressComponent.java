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

package de.gishmo.example.devk.client.ui.application.content.detail.composite.address;

import com.github.nalukit.nalu.client.component.AbstractCompositeComponent;
import de.gishmo.example.devk.client.ui.application.content.detail.composite.address.IAddressComponent.Controller;
import de.gishmo.example.devk.shared.model.dto.Person;
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

public class AddressComponent
    extends AbstractCompositeComponent<Controller, HTMLElement>
    implements IAddressComponent,
               Editor<Person> {

  @Path("address.street")
  TextBox detailStreet;
  @Path("address.zip")
  TextBox detailZip;
  @Path("address.city")
  TextBox detailCity;

  private Driver driver;

  public AddressComponent() {
  }

  @Override
  public void bind() {
    this.driver = new AddressComponent_Driver_Impl();
    this.driver.initialize(this);
  }

  @Override
  public void render() {
    this.detailStreet = TextBox.create("Street");
    this.detailZip = TextBox.create("ZIP");
    this.detailCity = TextBox.create("City");

    HtmlContentBuilder<HTMLDivElement> divElemet = Elements.div();

    divElemet.add(Card.create("Details - Address")
                      .appendChild(Row.create()
                                      .addColumn(Column.span12()
                                                       .appendChild(this.detailStreet)))
                      .appendChild(Row.create()
                                      .addColumn(Column.span12()
                                                       .appendChild(this.detailZip)))
                      .appendChild(Row.create()
                                      .addColumn(Column.span12()
                                                       .appendChild(this.detailCity))));

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
      extends SimpleBeanEditorDriver<Person, AddressComponent> {
  }

}
