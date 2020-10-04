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

package com.github.nalukit.example.nalu.loginapplication.ui.content.search;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;

public class SearchComponent
    extends AbstractComponent<ISearchComponent.Controller, HTMLElement>
    implements ISearchComponent {

  private TextBox searchName;

  private TextBox searchCity;

  private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

  public SearchComponent() {
  }

  @Override
  public void render() {
    this.searchName = TextBox.create("Name")
                             .groupBy(fieldsGrouping)
                             .setHelperText("search for: 'S' or 'D'")
                             .addLeftAddOn(Icons.ALL.label());

    this.searchCity = TextBox.create("City")
                             .groupBy(fieldsGrouping)
                             .addLeftAddOn(Icons.ALL.location_on());

    initElement(Card.create("Search Parameter")
                    .appendChild(Row.create()
                                    .addColumn(Column.span12()
                                                     .appendChild(this.searchName)))
                    .appendChild(Row.create()
                                    .addColumn(Column.span12()
                                                     .appendChild(this.searchCity)))
                    .appendChild(Row.create()
                                    .setGap("10px")
                                    .addColumn(Column.span12()
                                                     .appendChild(Button.create("Reset")
                                                                        .linkify()
                                                                        .style()
                                                                        .setMinWidth("120px")
                                                                        .get()
                                                                        .addClickListener(e -> {
                                                                          getController().doResetForm();
                                                                          fieldsGrouping.clear();
                                                                        }))
                                                     .appendChild(Button.createPrimary("Search")
                                                                        .setSize(ButtonSize.LARGE)
                                                                        .style()
                                                                        .setMinWidth("120px")
                                                                        .get()
                                                                        .addClickListener(e -> getController().doClickSearchButton(this.searchName.getValue(),
                                                                                                                                   this.searchCity.getValue()))))
                                    .style()
                                    .setTextAlign("right"))
                    .element());
  }

  @Override
  public void setSearchName(String searchName) {
    this.searchName.setValue(searchName);
  }

  @Override
  public void setSearchCity(String searchCity) {
    this.searchCity.setValue(searchCity);
  }
}
