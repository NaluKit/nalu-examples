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
import com.google.gwt.cell.client.Cell;
import com.google.gwt.cell.client.ClickableTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.client.ui.*;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.nalu.simpleapplication.client.resources.ApplicationConstants;
import de.gishmo.gwt.example.nalu.simpleapplication.client.resources.ApplicationCss;
import de.gishmo.gwt.example.nalu.simpleapplication.client.resources.ApplicationStyleFactory;

import java.util.ArrayList;
import java.util.List;

public class ListComponent
  extends AbstractComponent<IListComponent.Controller, Widget>
  implements IListComponent {

  private CellTable<Person> resultTable;

  public ListComponent() {
  }

  @Override
  public void render() {
    ApplicationCss style = ApplicationStyleFactory.get()
                                                  .getStyle();
    ScrollPanel panel = new ScrollPanel();

    FlowPanel resultPanel = new FlowPanel();
    resultPanel.addStyleName(style.resultPanel());
    panel.add(resultPanel);

    Label headline = new Label(ApplicationConstants.CONSTANTS.resultHeadline());
    headline.addStyleName(style.headline());
    resultPanel.add(headline);

    resultTable = new CellTable<>();
    resultPanel.add(resultTable);
    resultTable.setEmptyTableWidget(new HTML(ApplicationConstants.CONSTANTS.resultText()));
    Column<Person, String> nameColumn = addColumn(new ClickableTextCell(),
                                                  ApplicationConstants.CONSTANTS.columnName(),
                                                  person -> person.getName() + ", " + person.getFirstName(),
                                                  (index, object, value) -> getController().doUpdate(object));

    Column<Person, String> streetColumn = addColumn(new TextCell(),
                                                    ApplicationConstants.CONSTANTS.columnStreet(),
                                                    person -> person.getAddress()
                                                                    .getStreet(),
                                                    null);

    Column<Person, String> plzColumn = addColumn(new TextCell(),
                                                 ApplicationConstants.CONSTANTS.columnPlz(),
                                                 person -> person.getAddress()
                                                                 .getZip(),
                                                 null);
    plzColumn.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_RIGHT);

    Column<Person, String> cityColumn = addColumn(new TextCell(),
                                                  ApplicationConstants.CONSTANTS.columnCity(),
                                                  person -> person.getAddress()
                                                                  .getCity(),
                                                  null);

    // Tabellen und Spalten-Breite setzen
    resultTable.setWidth("100%");
    resultTable.setColumnWidth(nameColumn,
                               "40%");
    resultTable.setColumnWidth(streetColumn,
                               "25%");
    resultTable.setColumnWidth(plzColumn,
                               "10%");
    resultTable.setColumnWidth(cityColumn,
                               "25%");

    resetTable();

    initElement(resultTable);
  }

  /**
   * Add a column with a header.
   *
   * @param <C>        the cell generator
   * @param cell       the cell used to render the column
   * @param headerText the header string
   * @param getter     the value getter for the cell
   */
  private <C> Column<Person, C> addColumn(Cell<C> cell,
                                          String headerText,
                                          final GetValue<C> getter,
                                          FieldUpdater<Person, C> fieldUpdater) {
    Column<Person, C> column = new Column<Person, C>(cell) {
      @Override
      public C getValue(Person object) {
        return getter.getValue(object);
      }
    };
    column.setFieldUpdater(fieldUpdater);
    resultTable.addColumn(column,
                          headerText);
    return column;
  }

  @Override
  public void resetTable() {
    // Row-Count zurück setzen
    resultTable.setRowCount(0,
                            true);
    // Mit leerer Liste fuellen ... Brauch man das wirklich ... ?????
    resultTable.setRowData(0,
                           new ArrayList<>());
  }

  @Override
  public void setData(List<Person> result) {
    resultTable.setRowData(result);
  }

  /**
   * Get a cell value from a record.
   *
   * @param <C> the cell generator
   */
  private interface GetValue<C> {
    C getValue(Person person);
  }
}
