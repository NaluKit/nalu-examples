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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search.composite.toolbar;

import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.search.composite.toolbar.IToolbarComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractCompositeComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.gwt.elemento.core.Elements;

public class ToolbarComponent
    extends AbstractCompositeComponent<Controller, HTMLElement>
    implements IToolbarComponent {

  private final static String CACHED_TEXT = "The search data composite controller and component are cached. To see the caching, enter a search value in one or both text fields and press 'Search'. In case going back to the search screen, you will see your entered data.";

  private final static String NOT_CACHED_TEXT = "The search data composite controller and component are not cached. You will always see empty text fields when entering the screen.";

  private Button buttonStoreInCache;

  private Button buttonRemvoeFromCache;

  private Button buttonFireErrorEvent;

  private Text infoText;

  public ToolbarComponent() {
  }

  @Override
  public void render() {
    HTMLDivElement divElement = Elements.div()
                                        .asElement();

    this.buttonStoreInCache = Button.create("Store Composite Address in Chache")
                                    .setSize(ButtonSize.LARGE)
                                    .style()
                                    .setMinWidth("120px")
                                    .setMarginRight("12px")
                                    .get()
                                    .addClickListener(e -> getController().doStoreCompositeInCache());
    this.buttonRemvoeFromCache = Button.create("Remove Composite Address from Cache")
                                       .setSize(ButtonSize.LARGE)
                                       .style()
                                       .setMarginRight("12px")
                                       .setMinWidth("120px")
                                       .get()
                                       .addClickListener(e -> getController().doRemoveCompositefromCache());
   this.buttonFireErrorEvent = Button.create("Fire Error Event")
                                     .setSize(ButtonSize.LARGE)
                                     .style()
                                     .setMarginRight("12px")
                                     .setMinWidth("120px")
                                     .get()
                                     .addClickListener(e -> getController().doFireErrorEvent());
    this.buttonRemvoeFromCache.setDisabled(true);

    this.infoText = new Text();

    divElement.appendChild(Card.create("Tool Bar")
                               .appendChild(Row.create()
                                               .setGap("10px")
                                               .addColumn(Column.span12()
                                                                .appendChild(this.infoText))
                                               .styler(style -> style.setTextAlign("center"))
                                               .asElement())
                               .appendChild(Row.create()
                                               .setGap("10px")
                                               .addColumn(Column.span12()
                                                                .appendChild(this.buttonStoreInCache)
                                                                .appendChild(this.buttonRemvoeFromCache))
                                               .styler(style -> style.setTextAlign("center"))
                                               .asElement())
                               .appendChild(Row.create()
                                               .setGap("10px")
                                               .addColumn(Column.span12()
                                                                .appendChild(new Text("See Nalu error Handling in action, using the error event and a PopUpErrorController!")))
                                               .styler(style -> style.setTextAlign("center"))
                                               .styler(style -> style.setMarginTop("64px"))
                                               .asElement())
                               .appendChild(Row.create()
                                               .setGap("10px")
                                               .addColumn(Column.span12()
                                                                .appendChild(this.buttonFireErrorEvent))
                                               .styler(style -> style.setTextAlign("center"))
                                               .asElement())
                               .asElement());

    initElement(divElement);
  }

  @Override
  public void handleToggleButton(boolean cached) {
    this.buttonStoreInCache.setDisabled(cached);
    this.buttonRemvoeFromCache.setDisabled(!cached);
    if (cached) {
      this.infoText.textContent = ToolbarComponent.CACHED_TEXT;
    } else {
      this.infoText.textContent = ToolbarComponent.NOT_CACHED_TEXT;
    }
  }

}
