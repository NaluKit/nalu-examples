/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
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

package com.github.nalukit.nalu.simple.app.client.ui.app.shell.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.github.nalukit.nalu.simple.app.client.event.SelectEvent;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

public class NavigationComponent
    extends AbstractComponent<INavigationComponent.Controller, HTMLElement>
    implements INavigationComponent {

  private TreeItem<String> homeItem;

  private TreeItem<String> listItem;

  public NavigationComponent() {
  }

  @Override
  public void render() {
    this.homeItem = TreeItem.create("Home",
                                    Icons.ALL.search())
                            .addClickListener(e -> getController().doGotoHome());

    this.listItem = TreeItem.create("List persons",
                                    Icons.ALL.list())
                            .addClickListener(e -> getController().doGotoList());

    initElement(Tree.create("Navigation")
                    .appendChild(this.homeItem)
                    .appendChild(this.listItem)
                    .element());
  }

  @Override
  public void select(SelectEvent.Item item) {
    switch (item) {
      case HOME:
        this.homeItem.activate();
        this.listItem.deactivate();
        break;
      case LIST:
        this.listItem.activate();
        this.homeItem.deactivate();
        break;
      default:
        this.listItem.deactivate();
        this.homeItem.deactivate();
        break;
    }
  }

}
