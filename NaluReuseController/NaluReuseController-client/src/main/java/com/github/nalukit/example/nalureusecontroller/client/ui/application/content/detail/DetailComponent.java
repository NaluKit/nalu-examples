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

package com.github.nalukit.example.nalureusecontroller.client.ui.application.content.detail;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.jboss.elemento.Elements;

public class DetailComponent
    extends AbstractComponent<IDetailComponent.Controller, HTMLElement>
    implements IDetailComponent {
  
  private Button backButton;
  private Button forwardButton;
  
  public DetailComponent() {
  }
  
  @Override
  public void render() {
    HTMLDivElement divElemet = Elements.div()
                                       .element();
    divElemet.appendChild(Elements.div()
                                  .id("splitterPerson")
                                  .element());
    divElemet.appendChild(Elements.div()
                                  .id("splitterAddress")
                                  .element());
    divElemet.appendChild(Card.create()
                              .appendChild(Row.create()
                                              .addColumn(Column.span6()
                                                               .appendChild(this.backButton = Button.create("<<")
                                                                                                    .medium()
                                                                                                    .style()
                                                                                                    .setMarginRight("20px")
                                                                                                    .get()
                                                                                                    .addClickListener(e -> getController().doGoBack()))
                                                               .appendChild(this.forwardButton = Button.create(">>")
                                                                                                       .medium()
                                                                                                       .addClickListener(e -> getController().doGoForward()))
                                                               .styler(style -> style.setTextAlign("left")))
                                              .addColumn(Column.span6()
                                                               .appendChild(Button.createPrimary("Save")
                                                                                  .medium()
                                                                                  .style()
                                                                                  .setMarginRight("20px")
                                                                                  .get()
                                                                                  .addClickListener(e -> getController().doUpdate()))
                                                               .appendChild(Button.create("Reset")
                                                                                  .medium()
                                                                                  .addClickListener(e -> getController().doRevert()))
                                                               .styler(style -> style.setTextAlign("right")))
                                              .style()
                                              .setMarginTop("20px"))
                              .element());
    
    initElement(divElemet);
  }
  
  @Override
  public void setBackButtonDisabled(boolean disabled) {
    this.backButton.setDisabled(disabled);
    
  }
  
  @Override
  public void setGoOnButtonDisabled(boolean disabled) {
    this.forwardButton.setDisabled(disabled);
  }
  
}
