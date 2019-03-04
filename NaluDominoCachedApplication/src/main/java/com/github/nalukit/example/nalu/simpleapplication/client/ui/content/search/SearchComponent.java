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

  private final static String CACHED_TEXT = "The controller and the component are cached. To see the caching, select a person by clicking it's name, change something and save the data. The component shows the old, not updated data. Pressing reload will update the list and now you can see the updated data.";

  private final static String NOT_CACHED_TEXT = "The controller and the component are not cached. You will always see the updated data.";

  private Button buttonStoreInCache;

  private Button buttonRemvoeFromCache;

  private Text infoText;

  public SearchComponent() {
  }

  @Override
  public void render() {
    createWidgets();

    Column columnLeft = Column.span8()
                              .appendChild(this.buttonStoreInCache)
                              .appendChild(this.buttonRemvoeFromCache);
    columnLeft.style()
              .setTextAlign("left");
    Column columnRight = Column.span4()
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
                                                  .addClickListener(e -> getController().doClickSearchButton()));
    columnRight.style()
               .setTextAlign("right");
    HTMLDivElement container = Elements.div()
                                       .asElement();
    container.appendChild(Elements.div()
                                  .id("compositeSearchForm")
                                  .asElement());
    container.appendChild(Card.create("Tool Bar")
                              .appendChild(Row.create()
                                              .setGap("10px")
                                              .addColumn(columnLeft)
                                              .addColumn(columnRight)
                              .style()
                              .setProperty("word-wrap",
                                           "nowrap"))
                              .asElement());
    initElement(container);
  }

  private void createWidgets() {
    this.buttonStoreInCache = Button.create("Store in Chache")
                                    .setSize(ButtonSize.LARGE)
                                    .style()
                                    .setMinWidth("100px")
                                    .setMarginRight("12px")
                                    .get()
                                    .addClickListener(e -> getController().doStoreControllerInCache());
    this.buttonRemvoeFromCache = Button.create("Remove from Cache")
                                       .setSize(ButtonSize.LARGE)
                                       .style()
                                       .setMarginRight("12px")
                                       .setMinWidth("100px")
                                       .get()
                                       .addClickListener(e -> getController().doRemoveControllerfromCache());
    this.buttonRemvoeFromCache.setDisabled(true);

    this.infoText = new Text();
  }

  @Override
  public void handleToggleButton(boolean cached) {
    this.buttonStoreInCache.setDisabled(cached);
    this.buttonRemvoeFromCache.setDisabled(!cached);
    if (cached) {
      this.infoText.textContent = SearchComponent.CACHED_TEXT;
    } else {
      this.infoText.textContent = SearchComponent.NOT_CACHED_TEXT;
    }
  }

}
