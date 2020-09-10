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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.navigation;

import com.github.nalukit.example.nalu.simpleapplication.client.event.SelectEvent.Select;
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

  private TreeItem<String> composite01Item;

  private TreeItem<String> composite02Item;

  private TreeItem<String> logoffItem;

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

    this.composite01Item = TreeItem.create("Composite Conditional Test 01",
                                           Icons.ALL.view_agenda())
                                   .addClickListener(e -> getController().doShowComposites01Test());

    this.composite02Item = TreeItem.create("Composite Conditional Test 02",
                                           Icons.ALL.view_list())
                                   .addClickListener(e -> getController().doShowComposites02Test());
    this.logoffItem = TreeItem.create("Logoff",
                                      Icons.ALL.view_list())
                                   .addClickListener(e -> getController().doLogoff());

    initElement(Tree.create("Navigation")
                    .appendChild(this.searchItem)
                    .appendChild(this.listItem)
                    .appendChild(this.composite01Item)
                    .appendChild(this.composite02Item)
                    .appendChild(this.logoffItem)
                    .element());
  }

  @Override
  public void select(Select selected) {
    switch (selected) {
      case SEARCH:
        this.searchItem.activate();
        this.listItem.deactivate();
        this.composite01Item.deactivate();
        this.composite02Item.deactivate();
        break;
      case LIST:
        this.listItem.activate();
        this.searchItem.deactivate();
        this.composite01Item.deactivate();
        this.composite02Item.deactivate();
        break;
      case COMPOSITE01:
        this.listItem.deactivate();
        this.searchItem.deactivate();
        this.composite01Item.activate();
        this.composite02Item.deactivate();
        break;
      case COMPOSITE02:
        this.listItem.deactivate();
        this.searchItem.deactivate();
        this.composite01Item.deactivate();
        this.composite02Item.activate();
        break;
      default:
        this.listItem.deactivate();
        this.searchItem.deactivate();
        this.composite01Item.deactivate();
        this.composite02Item.deactivate();
        break;
    }
  }

}
