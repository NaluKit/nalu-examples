package com.github.nalukit.nalu.complex.app.client.ui.login.content;

import com.github.nalukit.nalu.complex.app.common.ui.AbstractAppComponent;
import com.github.nalukit.nalu.complex.app.common.ui.UiConstants;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;
import org.jboss.elemento.Elements;

import static org.jboss.elemento.Elements.h;

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
    extends AbstractAppComponent<ILoginComponent.Controller>
    implements ILoginComponent {

  private TextBox userId;

  private TextBox password;

  private FieldsGrouping grouping;

  public LoginComponent() {
    super();
  }

  @Override
  public void render() {
    this.grouping = new FieldsGrouping();

    this.userId   = TextBox.create("User")
                           .groupBy(this.grouping)
                           .addLeftAddOn(Icons.ALL.person())
                           .floating()
                           .setRequired(true)
                           .setAutoValidation(true);
    this.password = TextBox.password("Password")
                           .groupBy(this.grouping)
                           .addLeftAddOn(Icons.ALL.security())
                           .floating()
                           .setRequired(true)
                           .setAutoValidation(true);

    Button okButton = Button.create(Icons.ALL.lock_open())
                            .setBackground(UiConstants.DEFAULT_BUTTON_COLOR)
                            .setContent("Login")
                            .block()
                            .addClickListener(e -> {
                              if (this.grouping.validate()
                                               .isValid()) {
                                getController().doLogin(this.userId.getValue(),
                                                        this.password.getValue());
                              }
                            });

    this.userId.getInputElement()
               .styler(style -> style.setPaddingLeft("6px"));
    this.password.getInputElement()
                 .styler(style -> style.setPaddingLeft("6px"));

    initElement(Row.create()
                   .appendChild(Column.span4()
                                      .offset4()
                                      .appendChild(Card.create()
                                                       .appendChild(Elements.div()
                                                                            .css(Styles.align_center)
                                                                            .css(Styles.padding_30)
                                                                            .css("avatar-container")
                                                                            .add(Elements.img("images/logo.svg")
                                                                                         .style("width: 192px")))
                                                       .appendChild(DominoElement.div()
                                                                                 .styler(style -> style.setTextAlign("center")
                                                                                                       .setMarginBottom("0px")
                                                                                                       .setMarginTop("32px")
                                                                                                       .setColor("#A9A9A9")
                                                                                                       .setFontSize("10px"))
                                                                                 .appendChild(h(3).textContent("Nalu Complex Example App")))
                                                       .appendChild(DominoElement.div()
                                                                                 .styler(style -> style.setTextAlign("center")
                                                                                                       .setMarginBottom("0px")
                                                                                                       .setMarginTop("8px")
                                                                                                       .setColor("#A9A9A9")
                                                                                                       .setFontSize("10px"))
                                                                                 .appendChild(h(4).textContent("Login")))
                                                       .appendChild(DominoElement.of(Elements.div()
                                                                                             .css(Styles.padding_30))
                                                                                 .appendChild(Row.create()
                                                                                                 .span12(c -> c.appendChild(this.userId)))
                                                                                 .appendChild(Row.create()
                                                                                                 .span12(c -> c.appendChild(this.password)))
                                                                                 .appendChild(Row.create()
                                                                                                 .span12(c -> c.appendChild(okButton.setMarginTop("32px")))))))
                   .element());
  }

}
