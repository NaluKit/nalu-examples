/*
 * Copyright (c) 2018 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package com.github.nalukit.nalu.simple.app.client.ui.app.shell.composite;

import com.github.nalukit.nalu.simple.app.client.ui.AbstractAppCompositeComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.badges.Badge;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.style.Elevation;
import org.dominokit.domino.ui.themes.Theme;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.TextNode;

import java.util.List;

public class ShellCompositeComponent
    extends AbstractAppCompositeComponent<IShellCompositeComponent.Controller>
    implements IShellCompositeComponent {

  private Card card;
  private DominoElement<HTMLDivElement> innerContainer;

  public ShellCompositeComponent() {}

  @Override
  public void render() {
    this.createWidgets();
    initElement(this.build());
  }

  private void createWidgets() {
    this.card =
        Card.create().styler(style -> style.setHeight("212px)"));

    this.innerContainer = DominoElement.div().appendChild(TextNode.of("Composite of shell"));
    this.card.appendChild(this.innerContainer);
  }

  private HTMLElement build() {
    DominoElement<HTMLDivElement> container = DominoElement.div();

    container.appendChild(this.card.element());
    return container.element();
  }
}
