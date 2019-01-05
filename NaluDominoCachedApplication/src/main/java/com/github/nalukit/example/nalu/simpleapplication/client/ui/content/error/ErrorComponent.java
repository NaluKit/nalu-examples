/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.error;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;

public class ErrorComponent
    extends AbstractComponent<IErrorComponent.Controller, HTMLElement>
    implements IErrorComponent {

  private Text errorText;

  private FieldsGrouping fieldsGrouping = FieldsGrouping.create();

  public ErrorComponent() {
  }

  @Override
  public void render() {
    this.errorText = new Text("");

    initElement(Card.create("An Error occurred!")
                    .setHeaderBackground(Color.RED_DARKEN_2)
                    .addHeaderAction(Icons.ALL.home(),
                                     e -> getController().doRouteHome())
                    .appendChild(this.errorText)
                    .asElement());
  }

  @Override
  public void setErrorText(String errorMessage) {
    this.errorText.textContent = errorMessage;
  }

}
