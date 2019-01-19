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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search.composite;

import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search.composite.ISearchFormComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractCompositeComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;
import org.jboss.gwt.elemento.core.Elements;

public class SearchFormComponent
    extends AbstractCompositeComponent<Controller, HTMLElement>
    implements ISearchFormComponent {

  private TextBox searchName;

  private TextBox searchCity;

  private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

  public SearchFormComponent() {
  }

  @Override
  public void render() {
    this.searchName = TextBox.create("Name")
                             .groupBy(fieldsGrouping)
                             .setHelperText("search for: 'S' or 'D'")
                             .setLeftAddon(Icons.ALL.label());

    this.searchCity = TextBox.create("City")
                             .groupBy(fieldsGrouping)
                             .setLeftAddon(Icons.ALL.location_on());

    HTMLDivElement divElemet = Elements.div()
                                       .asElement();

    divElemet.appendChild(Card.create("Details - Person")
                              .appendChild(Row.create()
                                              .addColumn(Column.span12()
                                                               .appendChild(this.searchName)))
                              .appendChild(Row.create()
                                              .addColumn(Column.span12()
                                                               .appendChild(this.searchCity)))
                              .asElement());

    initElement(divElemet);
  }

  @Override
  public String getSearchName() {
    return this.searchName.getValue();
  }

  @Override
  public void setSearchName(String searchName) {
    this.searchName.setValue(searchName);
  }

  @Override
  public String getSearchCity() {
    return this.searchCity.getValue();
  }

  @Override
  public void setSearchCity(String searchCity) {
    this.searchCity.setValue(searchCity);
  }

}
