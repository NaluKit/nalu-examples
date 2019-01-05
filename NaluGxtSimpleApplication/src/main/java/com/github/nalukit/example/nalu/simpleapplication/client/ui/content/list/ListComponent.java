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

import com.github.nalukit.example.nalu.simpleapplication.client.data.model.MailProperties;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Mail;
import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.data.shared.SortDir;
import com.sencha.gxt.data.shared.Store;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ListComponent
    extends AbstractComponent<IListComponent.Controller, Widget>
    implements IListComponent {

  private MailProperties mailProperties;

  private Grid<Mail> grid;

  private ListStore<Mail> store;

  public ListComponent() {
  }

  @Override
  public void render() {
    SimpleContainer container = new SimpleContainer();

    this.createStore();
    this.createGrid();

    container.add(this.grid);

    initElement(container);
  }

  private void createStore() {
    this.mailProperties = GWT.create(MailProperties.class);
    store = new ListStore<>(mailProperties.key());
    Comparator<Mail> comparatorSender = new Comparator<Mail>() {
      @Override
      public int compare(Mail o1,
                         Mail o2) {
        return o1.getSender()
                 .compareTo(o2.getSender());
      }
    };
    store.addSortInfo(new Store.StoreSortInfo<>(comparatorSender,
                                                SortDir.ASC));
  }

  private void createGrid() {
    ColumnConfig<Mail, String> ccSender = new ColumnConfig<>(mailProperties.sender(),
                                                             256,
                                                             "Sender");
    ccSender.setFixed(true);
    ColumnConfig<Mail, String> ccEmail = new ColumnConfig<>(mailProperties.email(),
                                                            256,
                                                            "E-Mail");
    ccEmail.setFixed(true);
    ColumnConfig<Mail, String> ccSubject = new ColumnConfig<>(mailProperties.subject(),
                                                              512,
                                                              "subject");
    List<ColumnConfig<Mail, ?>> list = new ArrayList<>();
    list.add(ccSender);
    list.add(ccEmail);
    list.add(ccSubject);
    ColumnModel<Mail> cm = new ColumnModel<>(list);
    grid = new Grid<>(store,
                      cm);
    grid.setSize("100%",
                 "512px");
    grid.getView()
        .setStripeRows(true);
    grid.setBorders(true);
    grid.getView()
        .setAutoExpandColumn(ccSubject);
    grid.getView()
        .setForceFit(true);
  }

  @Override
  public void bind() {
    grid.addRowDoubleClickHandler(rowDoubleClickEvent -> {
      getController().doSelectRow(store.get(rowDoubleClickEvent.getRowIndex())
                                       .getId());
    });
  }

  @Override
  public void edit(List<Mail> listOfEmails) {
    this.store.clear();
    this.store.addAll(listOfEmails);
  }

}
