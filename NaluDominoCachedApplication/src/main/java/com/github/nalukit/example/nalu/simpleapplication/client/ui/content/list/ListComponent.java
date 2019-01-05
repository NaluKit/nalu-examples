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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.list;

import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.datatable.ColumnConfig;
import org.dominokit.domino.ui.datatable.DataTable;
import org.dominokit.domino.ui.datatable.TableConfig;
import org.dominokit.domino.ui.datatable.store.LocalListDataStore;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.gwt.elemento.core.Elements;
import org.jboss.gwt.elemento.core.EventType;

import java.util.ArrayList;
import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.a;

public class ListComponent
    extends AbstractComponent<IListComponent.Controller, HTMLElement>
    implements IListComponent {

  private final static String CACHED_TEXT = "The controller and the component are cached. To see the caching, select a person by clicking it's name, change something and save the data. The component shows the old, not updated data. Pressing reload will update the list and now you can see the updated data.";

  private final static String NOT_CACHED_TEXT = "The controller and the component are not cached. You will always see the updated data.";

  private DataTable<Person> table;

  private LocalListDataStore<Person> store;

  private Button buttonStoreInCache;

  private Button buttonRemvoeFromCache;

  private Button buttonReload;

  private Text infoText;

  public ListComponent() {
  }

  @Override
  public void render() {
    this.buttonReload = Button.createPrimary("Reload")
                              .linkify()
                              .setSize(ButtonSize.LARGE)
                              .style()
                              .setMinWidth("120px")
                              .get()
                              .addClickListener(e -> getController().doReload());
    this.buttonStoreInCache = Button.create("Store in Chache")
                                    .setSize(ButtonSize.LARGE)
                                    .style()
                                    .setMinWidth("120px")
                                    .setMarginRight("12px")
                                    .get()
                                    .addClickListener(e -> getController().doStoreControllerInCache());
    this.buttonRemvoeFromCache = Button.create("Remove from Cache")
                                       .setSize(ButtonSize.LARGE)
                                       .style()
                                       .setMarginRight("12px")
                                       .setMinWidth("120px")
                                       .get()
                                       .addClickListener(e -> getController().doRemoveControllerfromCache());
    this.buttonRemvoeFromCache.setDisabled(true);

    HTMLDivElement divElement = Elements.div()
                                        .asElement();

    TableConfig<Person> tableConfig = new TableConfig<>();
    tableConfig.addColumn(ColumnConfig.<Person>create("name",
                                                      "Name").setCellRenderer(cell -> a().textContent(cell.getTableRow()
                                                                                                          .getRecord()
                                                                                                          .getName() +
                                                                                                      ", " +
                                                                                                      cell.getTableRow()
                                                                                                          .getRecord()
                                                                                                          .getFirstName())
                                                                                         .on(EventType.click,
                                                                                             e -> getController().doUpdate(cell.getTableRow()
                                                                                                                               .getRecord()))
                                                                                         .asElement()))
               .addColumn(ColumnConfig.<Person>create("street",
                                                      "Street").setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                                                     .getRecord()
                                                                                                     .getAddress()
                                                                                                     .getStreet())))
               .addColumn(ColumnConfig.<Person>create("zip",
                                                      "ZIP").textAlign("right")
                                                            .setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                                                  .getRecord()
                                                                                                  .getAddress()
                                                                                                  .getZip())))
               .addColumn(ColumnConfig.<Person>create("street",
                                                      "Street").setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                                                     .getRecord()
                                                                                                     .getAddress()
                                                                                                     .getStreet())))
               .addColumn(ColumnConfig.<Person>create("city",
                                                      "City").setCellRenderer(cell -> new Text(cell.getTableRow()
                                                                                                   .getRecord()
                                                                                                   .getAddress()
                                                                                                   .getCity())));

    this.store = new LocalListDataStore<>();

    this.table = new DataTable<>(tableConfig,
                                 store);

    divElement.appendChild(Card.create("SEARCH RESULTS")
                               .appendChild(Row.create()
                                               .appendChild(Column.span12()
                                                                  .appendChild(this.table)))
                               .asElement());

    this.infoText = new Text();

    divElement.appendChild(Card.create("Tool Bar")
                               .appendChild(Row.create()
                                               .setGap("10px")
                                               .addColumn(Column.span12()
                                                                .appendChild(this.infoText))
                                               .addColumn(Column.span12()
                                                                .appendChild(this.buttonStoreInCache)
                                                                .appendChild(this.buttonRemvoeFromCache)
                                                                .appendChild(this.buttonReload))
                                               .style()
                                               .setTextAlign("center"))
                               .asElement());

    initElement(divElement);
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

  @Override
  public void handleToggleButton(boolean cached) {
    this.buttonStoreInCache.setDisabled(cached);
    this.buttonRemvoeFromCache.setDisabled(!cached);
    if (cached) {
      this.infoText.textContent = ListComponent.CACHED_TEXT;
    } else {
      this.infoText.textContent = ListComponent.NOT_CACHED_TEXT;
    }
  }

}
