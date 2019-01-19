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

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.gwt.elemento.core.Elements;

public class DetailComponent
    extends AbstractComponent<IDetailComponent.Controller, HTMLElement>
    implements IDetailComponent {

  public DetailComponent() {
  }

  @Override
  public void render() {
    HTMLDivElement divElemet = Elements.div()
                                       .asElement();
    divElemet.appendChild(Elements.div()
                                  .id("compositePerson")
                                  .asElement());
    divElemet.appendChild(Elements.div()
                                  .id("compositeAddress")
                                  .asElement());
    divElemet.appendChild(Card.create()
                              .appendChild(Row.create()
                                              .addColumn(Column.span12()
                                                               .appendChild(Button.createPrimary("Save")
                                                                                  .style()
                                                                                  .setMarginRight("20px")
                                                                                  .get()
                                                                                  .addClickListener(e -> getController().doUpdate()))
                                                               .appendChild(Button.create("Reset")
                                                                                  .addClickListener(e -> getController().doRevert())))
                                              .style()
                                              .setTextAlign("right")
                                              .setMarginTop("20px"))
                              .asElement());

    initElement(divElemet);
  }

}
