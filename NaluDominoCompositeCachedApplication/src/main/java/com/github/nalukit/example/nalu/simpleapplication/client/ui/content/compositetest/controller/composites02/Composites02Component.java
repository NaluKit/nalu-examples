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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.compositetest.controller.composites02;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.elemento.Elements;

public class Composites02Component
    extends AbstractComponent<IComposites02Component.Controller, HTMLElement>
    implements IComposites02Component {

  public Composites02Component() {
  }

  @Override
  public void render() {
    HTMLDivElement divElement = Elements.div()
                                       .element();
    divElement.appendChild(Card.create("Composites 02")
                               .appendChild(Row.create()
                                               .setGap("10px")
                                               .addColumn(Column.span12()
                                                                .appendChild(Elements.div()
                                                                                     .textContent("This is composites Component 02")))
                                               .styler(style -> style.setTextAlign("center"))
                                               .element())
                               .element());
    divElement.appendChild(Elements.div()
                                  .id("composite01")
                                  .element());
    divElement.appendChild(Elements.div()
                                  .id("composite02")
                                  .element());
    divElement.appendChild(Elements.div()
                                  .id("composite03")
                                  .element());

    initElement(divElement);
  }

}
