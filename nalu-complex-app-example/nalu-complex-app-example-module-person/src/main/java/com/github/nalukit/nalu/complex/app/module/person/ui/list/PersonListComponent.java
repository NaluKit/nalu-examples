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

package com.github.nalukit.nalu.complex.app.module.person.ui.list;

import com.github.nalukit.nalu.complex.app.common.ui.AbstractAppComponent;
import com.github.nalukit.nalu.complex.app.shared.model.Person;
import elemental2.dom.Text;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;
import org.jboss.elemento.EventType;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.elemento.Elements.a;

public class PersonListComponent
    extends AbstractAppComponent<IPersonListComponent.Controller>
    implements IPersonListComponent {

  private DataTable<Person> table;

  private LocalListDataStore<Person> store;

  public PersonListComponent() {
  }

  @Override
  public void render() {
    TableConfig<Person> tableConfig = new TableConfig<>();
    tableConfig.setFixed(true)
               .addColumn(ColumnConfig.<Person>create("",
                                                      "")
                                      .setFixed(true)
                                      .setShowTooltip(false)
                                      .textAlign("center")
                                      .setCellRenderer(cellInfo -> Icons.ALL.mode_edit()
                                                                            .setColor(Color.GREEN)
                                                                            .styler(style -> style.setCursor("pointer"))
                                                                            .addClickListener(e -> getController().doEdit(cellInfo.getRecord()
                                                                                                                                  .getId()))
                                                                            .element())
                                      .setShowTooltip(false)
                                      .setWidth("36px"))
               .addColumn(ColumnConfig.<Person>create("name",
                                                      "Name")
                                      .setWidth("312px")
                                      .setCellRenderer(cell -> a().textContent(cell.getTableRow()
                                                                                   .getRecord()
                                                                                   .getName() + ", " + cell.getTableRow()
                                                                                                           .getRecord()
                                                                                                           .getFirstName())
                                                                  .on(EventType.click,
                                                                      e -> getController().doEdit(cell.getRecord()
                                                                                                      .getId()))
                                                                  .element()))
               .addColumn(ColumnConfig.<Person>create("street",
                                                      "Street")
                                      .setWidth("256px")
                                      .setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                            .getRecord()
                                                                            .getAddress()
                                                                            .getStreet())))
               .addColumn(ColumnConfig.<Person>create("zip",
                                                      "ZIP")
                                      .textAlign("right")
                                      .setWidth("64px")
                                      .setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                            .getRecord()
                                                                            .getAddress()
                                                                            .getZip())))
               .addColumn(ColumnConfig.<Person>create("street",
                                                      "Street")
                                      .setWidth("256px")
                                      .setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                            .getRecord()
                                                                            .getAddress()
                                                                            .getStreet())))
               .addColumn(ColumnConfig.<Person>create("city",
                                                      "City")
                                      .setWidth("256px")
                                      .setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                            .getRecord()
                                                                            .getAddress()
                                                                            .getCity())));

    this.store = new LocalListDataStore<>();

    this.table = new DataTable<>(tableConfig,
                                 store);

    initElement(Card.create("SEARCH RESULTS")
                    .addHeaderAction(Icons.ALL.filter_mdi()
                                              .clickable(),
                                     e -> this.getController()
                                              .doShowSearchPopUp())
                    .appendChild(this.table)
                    .element());

  }

  @Override
  public void resetTable() {
    this.store.setData(new ArrayList<>());
  }

  @Override
  public void setData(List<Person> result) {
    resetTable();
    this.store.setData(result);
    this.table.load();
  }

}
