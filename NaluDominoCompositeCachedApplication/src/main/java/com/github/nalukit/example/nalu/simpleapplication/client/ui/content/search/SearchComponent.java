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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.gwt.elemento.core.Elements;

public class SearchComponent
    extends AbstractComponent<ISearchComponent.Controller, HTMLElement>
    implements ISearchComponent {

  public SearchComponent() {
  }

  @Override
  public void render() {
    HTMLDivElement container = Elements.div()
                                       .element();
    container.appendChild(Elements.div()
                                  .id("compositeSearchForm")
                                  .element());
    container.appendChild(Card.create("Action Bar")
                              .appendChild(Row.create()
                                              .setGap("10px")
                                              .addColumn(Column.span12()
                                                               .appendChild(Button.create("Reset")
                                                                                  .linkify()
                                                                                  .setSize(ButtonSize.LARGE)
                                                                                  .style()
                                                                                  .setMinWidth("100px")
                                                                                  .get()
                                                                                  .addClickListener(e -> getController().doClear()))
                                                               .appendChild(Button.createPrimary("Search")
                                                                                  .setSize(ButtonSize.LARGE)
                                                                                  .style()
                                                                                  .setMinWidth("100px")
                                                                                  .get()
                                                                                  .addClickListener(e -> getController().doClickSearchButton()))
                                              .styler(style -> style.setTextAlign("right")))
                                              .style()
                                              .setProperty("word-wrap",
                                                           "nowrap"))
                              .element());
    container.appendChild(Elements.div()
                                  .id("compositeToolbar")
                                  .element());
    initElement(container);
  }

}
