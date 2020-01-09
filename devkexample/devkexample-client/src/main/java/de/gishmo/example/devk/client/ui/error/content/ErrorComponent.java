package de.gishmo.example.devk.client.ui.error.content;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Color;

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
public class ErrorComponent
    extends AbstractComponent<IErrorComponent.Controller, HTMLElement>
    implements IErrorComponent {

  private Text errorText;

  public ErrorComponent() {
    super();
  }

  @Override
  public void render() {
    this.errorText = new Text();
    initElement(Card.create("An Error occurred!")
                    .setHeaderBackground(Color.RED_DARKEN_2)
                    .addHeaderAction(Icons.ALL.home(),
                                     e -> getController().doRouteHome())
                    .appendChild(this.errorText)
                    .element());
  }

  @Override
  public void setErrorMessage(String errorMessage) {
    this.errorText.textContent = errorMessage;
  }

}
