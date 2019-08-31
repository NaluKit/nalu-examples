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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.popup.error;

import com.github.nalukit.example.nalu.simpleapplication.client.ui.popup.error.IErrorComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractPopUpComponent;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.modals.ModalDialog;

import java.util.Objects;

public class ErrorComponent
    extends AbstractPopUpComponent<Controller>
    implements IErrorComponent {

  private ModalDialog dialog;

  private TextBox message;
  private TextBox route;

  public ErrorComponent() {
  }

  @Override
  public void render() {
    this.dialog = ModalDialog.create("Error Message")
                             .large()
                             .setAutoClose(false);
    this.message = TextBox.create("Message")
                          .setReadOnly(true);
    this.route = TextBox.create("Route")
                        .setReadOnly(true);

    this.dialog.appendChild(Row.create()
                               .appendChild(Column.span12()
                                                  .appendChild(this.message)))
               .appendChild(Row.create()
                               .appendChild(Column.span12()
                                                  .appendChild(this.route)));

    this.dialog.appendFooterChild(Button.createPrimary("OK")
                                        .style()
                                        .setMarginRight("20px")
                                        .get()
                                        .addClickListener(e -> hide()));
  }

  @Override
  public void bind() {
  }

  @Override
  public void clear() {
    this.message.setValue("");
    this.route.setValue("");
  }

  @Override
  public void edit(String message,
                   String route) {
    if (!Objects.isNull(message)) {
      this.message.setValue(message);
    }
    if (!Objects.isNull(route)) {
      this.route.setValue(route);
    }
  }

  @Override
  public void hide() {
    this.dialog.close();
  }

  @Override
  public void show() {
    this.dialog.open();
  }

}
