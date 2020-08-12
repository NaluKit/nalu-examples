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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.blocks.controlled;

import com.github.nalukit.nalu.client.component.AbstractBlockComponent;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.utils.TextNode;

public class ControlledBlockComponent
    extends AbstractBlockComponent<IControlledBlockComponent.Controller>
    implements IControlledBlockComponent {

  private static final String text = "This block controller is managed by " +
                                     "events. The controls to managed the " +
                                     "block can be found on the search page.";

  private HTMLDivElement element;

  public ControlledBlockComponent() {
  }

  @Override
  public void append() {
    DomGlobal.document.body.appendChild(this.element);
  }

  @Override
  public void render() {
    Card card = Card.create("Controlled Card",
                            "Description text here...")
                    .appendChild(TextNode.of(text))
                    .addHeaderAction(Icons.ALL.more_vert(),
                                     (event) -> {
                                       DomGlobal.console.info("More action selected");
                                     })
                    .styler(style -> {
                      style.setBottom("0px");
                      style.setLeft("0px");
                      style.setWidth("256px");
                      style.setHeight("192px");
                      style.setPosition("absolute");
                      style.setProperty("tab-index", "1000");
                      style.setZIndex(1000);
                    });
    this.element = card.element();
  }

  @Override
  public void show() {
    this.element.style.display = "block";
  }

  @Override
  public void hide() {
    this.element.style.display = "none";
  }

}
