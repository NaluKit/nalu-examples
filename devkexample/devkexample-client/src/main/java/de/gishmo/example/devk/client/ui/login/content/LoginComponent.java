package de.gishmo.example.devk.client.ui.login.content;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class LoginComponent
    extends AbstractComponent<ILoginComponent.Controller, HTMLElement>
    implements ILoginComponent {

  private TextBox userId;

  private TextBox password;

  private FieldsGrouping fieldsGrouping;

  public LoginComponent() {
    super();
  }

  @Override
  public void render() {
    fieldsGrouping = FieldsGrouping.create();
    this.userId = TextBox.create("User ID")
                         .groupBy(fieldsGrouping)
                         .setLeftAddon(Icons.ALL.label());
    this.password = TextBox.create("Password")
                           .groupBy(fieldsGrouping)
                           .setLeftAddon(Icons.ALL.location_on());
    initElement(Card.create("Login Parameter")
                    .appendChild(Row.create()
                                    .addColumn(Column.span12()
                                                     .appendChild(this.userId)))
                    .appendChild(Row.create()
                                    .addColumn(Column.span12()
                                                     .appendChild(this.password)))
                    .appendChild(Row.create()
                                    .setGap("10px")
                                    .addColumn(Column.span12()
                                                     .appendChild(Button.createPrimary("Login")
                                                                        .setSize(ButtonSize.LARGE)
                                                                        .style()
                                                                        .setMinWidth("120px")
                                                                        .get()
                                                                        .addClickListener(e -> getController().doLogin(this.userId.getValue(),
                                                                                                                       this.password.getValue()))))
                                    .style()
                                    .setTextAlign("right"))
                    .element());
  }

}
