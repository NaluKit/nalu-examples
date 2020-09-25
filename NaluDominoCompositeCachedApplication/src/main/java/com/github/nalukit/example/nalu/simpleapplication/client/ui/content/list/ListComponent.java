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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.list;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.button.ButtonSize;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.elemento.Elements;

public class ListComponent
    extends AbstractComponent<IListComponent.Controller, HTMLElement>
    implements IListComponent {
  
  private final static String CACHED_TEXT = "The controller and the component are cached. To see the caching, select a person by clicking it's name, change something and save the data. The component shows the old, not updated data. Pressing reload will update the list and now you can see the updated data.";
  
  private final static String NOT_CACHED_TEXT = "The controller and the component are not cached. You will always see the updated data.";
  
  private Button buttonStoreInCache;
  
  private Button buttonRemvoeFromCache;
  
  private Text infoText;
  
  public ListComponent() {
  }
  
  @Override
  public void render() {
    Button buttonReload = Button.createPrimary("Reload")
                                .linkify()
                                .setSize(ButtonSize.LARGE)
                                .style()
                                .setMinWidth("120px")
                                .get()
                                .addClickListener(e -> getController().doReload());
    this.buttonStoreInCache    = Button.create("Store in Chache")
                                       .setSize(ButtonSize.LARGE)
                                       .style()
                                       .setMinWidth("120px")
                                       .setMarginRight("12px")
                                       .get()
                                       .addClickListener(e -> getController().doStoreControllerInCache());
    this.buttonRemvoeFromCache = Button.create("Remove from Cache")
                                       .setSize(ButtonSize.LARGE)
                                       .style()
                                       .setMarginRight("12px")
                                       .setMinWidth("120px")
                                       .get()
                                       .addClickListener(e -> getController().doRemoveControllerfromCache());
    this.buttonRemvoeFromCache.setDisabled(true);
    
    HTMLDivElement divElement = Elements.div()
                                        .element();
    
    divElement.appendChild(Card.create("SEARCH RESULTS")
                               .appendChild(Row.create()
                                               .appendChild(Column.span12()
                                                                  .setId("compositeListForm")))
                               .element());
    
    this.infoText = new Text();
    
    divElement.appendChild(Card.create("Tool Bar")
                               .appendChild(Row.create()
                                               .setGap("10px")
                                               .addColumn(Column.span12()
                                                                .appendChild(this.infoText))
                                               .addColumn(Column.span12()
                                                                .appendChild(this.buttonStoreInCache)
                                                                .appendChild(this.buttonRemvoeFromCache)
                                                                .appendChild(buttonReload))
                                               .style()
                                               .setTextAlign("center"))
                               .element());
    
    initElement(divElement);
  }
  
  @Override
  public void handleToggleButton(boolean cached) {
    this.buttonStoreInCache.setDisabled(cached);
    this.buttonRemvoeFromCache.setDisabled(!cached);
    if (cached) {
      this.infoText.textContent = ListComponent.CACHED_TEXT;
    } else {
      this.infoText.textContent = ListComponent.NOT_CACHED_TEXT;
    }
  }
  
}
