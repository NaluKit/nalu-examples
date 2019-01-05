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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.google.gwt.user.client.ui.Widget;

@Controller(route = "/application/mail/:id",
            selector = "content",
            componentInterface = IDetailComponent.class,
            component = DetailComponent.class)
public class DetailController
    extends AbstractComponentController<NaluSimpleApplicationContext, IDetailComponent, Widget>
    implements IDetailComponent.Controller {

  public DetailController() {
  }

  @AcceptParameter("id")
  public void setId(String id) {
    this.component.edit(this.context.getFakedMailServer()
                                    .getMail(id));
    this.eventBus.fireEvent(new StatusChangeEvent("Display email with id: " + id));
  }

}
