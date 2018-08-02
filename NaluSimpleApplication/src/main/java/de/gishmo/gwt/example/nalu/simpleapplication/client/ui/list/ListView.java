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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.list;

import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;

import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.col;
import static org.jboss.gwt.elemento.core.Elements.colgroup;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.table;
import static org.jboss.gwt.elemento.core.Elements.td;
import static org.jboss.gwt.elemento.core.Elements.th;
import static org.jboss.gwt.elemento.core.Elements.thead;
import static org.jboss.gwt.elemento.core.Elements.tr;
import static org.jboss.gwt.elemento.core.EventType.click;

public class ListView
  extends LazyReverseView<IListView.Presenter>
  implements IListView {

  private HTMLElement container;
  private HTMLElement resultTable;

  public ListView() {
    super();
  }

  public void createView() {
    container = div().add(div().style("width: 100%"))
                     .add(div().css("headline")
                               .textContent("Search Results"))
                     .asElement();
  }

  @Override
  public Element asElement() {
    return container;
  }

  @Override
  public void resetTable() {
    if (resultTable != null) {
      container.removeChild(resultTable);
      resultTable = null;
    }
  }

  @Override
  public void setData(List<Person> result) {
    resetTable();
    container.appendChild(createTable(result));
  }

  private HTMLElement createTable(List<Person> result) {
    resultTable = table().css("resultTable")
                         .add(colgroup().add(col().style("width: 40%;"))
                                        .add(col().style("width: 25%;"))
                                        .add(col().style("width: 10%;"))
                                        .add(col().style("width: 25%;")))
                         .add(thead().add(th().css("resultTableHeader")
                                              .textContent("Name"))
                                     .add(th().css("resultTableHeader")
                                              .textContent("Street"))
                                     .add(th().css("resultTableHeader")
                                              .textContent("Zip"))
                                     .add(th().css("resultTableHeader")
                                              .textContent("City")))
                         .asElement();

    for (Person person : result) {
      resultTable.appendChild(this.createTableDataRow(person));
    }

    return resultTable;
  }

  private HTMLElement createTableDataRow(Person person) {
    return tr().add(td().add(div().css("resultTableLink")
                                  .textContent(person.getName() + ", " + person.getFirstName())
                                  .on(click,
                                      (event) -> getPresenter().doUpdate(person))))
               .add(td().textContent(person.getAddress()
                                           .getStreet()))
               .add(td().textContent(person.getAddress()
                                           .getZip()))
               .add(td().textContent(person.getAddress()
                                           .getCity()))
               .asElement();
  }
}
