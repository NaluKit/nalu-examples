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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.compositetest.composite.composite03;

import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.compositetest.composite.composite03.IComposite03Component.Controller;
import com.github.nalukit.nalu.client.component.AbstractCompositeComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.gwt.elemento.core.Elements;

public class Composite03Component
    extends AbstractCompositeComponent<Controller, HTMLElement>
    implements IComposite03Component {

  private final static String TEXT = "Composite B";

  public Composite03Component() {
  }

  @Override
  public void render() {
    HTMLDivElement divElement = Elements.div()
                                        .element();

    divElement.appendChild(Card.create("Composite B")
                               .appendChild(Row.create()
                                               .setGap("10px")
                                               .addColumn(Column.span12()
                                                                .appendChild(Elements.div()
                                                                                     .textContent(TEXT)))
                                               .styler(style -> style.setTextAlign("center"))
                                               .element())
                               .element());

    initElement(divElement);
  }

}
