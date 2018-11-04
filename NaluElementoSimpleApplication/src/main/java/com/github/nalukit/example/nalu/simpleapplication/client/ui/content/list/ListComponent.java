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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.list;

import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;

import java.util.List;

import static org.jboss.gwt.elemento.core.Elements.*;
import static org.jboss.gwt.elemento.core.EventType.click;

public class ListComponent
    extends AbstractComponent<IListComponent.Controller, HTMLElement>
    implements IListComponent {

  private String name;

  private String city;

  private HTMLElement container;

  private HTMLElement resultTable;

  public ListComponent() {
  }

  @Override
  public void render() {
    initElement(this.container = div().add(div().style("width: 100%"))
                                      .add(div().css("headline")
                                                .textContent("Search Results"))
                                      .asElement());
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCity(String city) {
    this.city = city;
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
    this.container.appendChild(createTable(result));
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
                                      (event) -> update(person))))
               .add(td().textContent(person.getAddress()
                                           .getStreet()))
               .add(td().textContent(person.getAddress()
                                           .getZip()))
               .add(td().textContent(person.getAddress()
                                           .getCity()))
               .asElement();
  }

  private void update(Person object) {
    this.getController()
        .doUpdate(object);
  }

}
