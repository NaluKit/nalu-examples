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

package com.github.nalukit.example.nalureusecontroller.client.ui.application.shell.content.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

public class NavigationComponent
    extends AbstractComponent<INavigationComponent.Controller, HTMLElement>
    implements INavigationComponent {
  
  private TreeItem<String> searchItem;
  
  private TreeItem<String> listItem;
  
  public NavigationComponent() {
  }
  
  @Override
  public void render() {
    this.searchItem = TreeItem.create("Search persons",
                                      Icons.ALL.search())
                              .addClickListener(e -> getController().doShowSearch());
    
    this.listItem = TreeItem.create("List persons",
                                    Icons.ALL.list())
                            .addClickListener(e -> getController().doShowList());
    
    initElement(Tree.create("Navigation")
                    .appendChild(this.searchItem)
                    .appendChild(this.listItem)
                    .element());
  }
  
  @Override
  public void select(String toString) {
    switch (toString) {
      case "SEARCH":
        this.searchItem.activate();
        this.listItem.deactivate();
        break;
      case "LIST":
        this.listItem.activate();
        this.searchItem.deactivate();
        break;
      default:
        this.listItem.deactivate();
        this.searchItem.deactivate();
        break;
    }
  }
  
}
