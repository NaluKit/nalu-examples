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

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Mail;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;
import java.util.Objects;

@Controller(route = "/application/list",
            selector = "north",
            componentInterface = IListComponent.class,
            component = ListComponent.class)
public class ListController
    extends AbstractComponentController<NaluSimpleApplicationContext, IListComponent, Widget>
    implements IListComponent.Controller {

  public ListController() {
  }

  @Override
  public void start() {
    if (!Objects.isNull(this.router.getNaluErrorMessage())) {
      Window.alert(this.router.getNaluErrorMessage()
                              .getErrorMessage());
    }

    List<Mail> listOfEmails = this.context.getFakedMailServer()
                                          .getAllMails();
    this.component.edit(listOfEmails);
    this.eventBus.fireEvent(new StatusChangeEvent("Found: " + listOfEmails.size() + " email(s)"));
  }

  @Override
  public void doSelectRow(String id) {
    this.router.route("/application/mail",
                      id);
  }
}
