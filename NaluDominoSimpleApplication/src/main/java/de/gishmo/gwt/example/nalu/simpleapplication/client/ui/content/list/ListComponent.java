/*
 * Copyright (c) 2018 - Frank Hossfeld
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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.content.list;

import com.github.mvp4g.nalu.client.component.AbstractComponent;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.Person;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.jboss.gwt.elemento.core.EventType;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.a;

public class ListComponent
  extends AbstractComponent<IListComponent.Controller, HTMLElement>
  implements IListComponent {

  private DataTable<Person>          table;
  private LocalListDataStore<Person> store;

  public ListComponent() {
  }

  @Override
  public HTMLElement render() {
    TableConfig<Person> tableConfig = new TableConfig<>();
    tableConfig.addColumn(ColumnConfig.<Person>create("name",
                                                      "Name")
                            .setCellRenderer(cell -> a().textContent(cell.getTableRow()
                                                                         .getRecord()
                                                                         .getName() + ", " + cell.getTableRow()
                                                                                                 .getRecord()
                                                                                                 .getFirstName())
                                                        .on(EventType.click,
                                                            e -> getController().doUpdate(cell.getTableRow()
                                                                                              .getRecord()))
                                                        .asElement()))
               .addColumn(ColumnConfig.<Person>create("street",
                                                      "Street")
                            .setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                  .getRecord()
                                                                  .getAddress()
                                                                  .getStreet())))
               .addColumn(ColumnConfig.<Person>create("zip",
                                                      "ZIP")
                            .textAlign("right")
                            .setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                  .getRecord()
                                                                  .getAddress()
                                                                  .getZip())))
               .addColumn(ColumnConfig.<Person>create("street",
                                                      "Street")
                            .setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                  .getRecord()
                                                                  .getAddress()
                                                                  .getStreet())))
               .addColumn(ColumnConfig.<Person>create("city",
                                                      "City")
                            .setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                  .getRecord()
                                                                  .getAddress()
                                                                  .getCity())));

    this.store = new LocalListDataStore<>();

    this.table = new DataTable<>(tableConfig,
                                 store);

    return this.table.asElement();
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
