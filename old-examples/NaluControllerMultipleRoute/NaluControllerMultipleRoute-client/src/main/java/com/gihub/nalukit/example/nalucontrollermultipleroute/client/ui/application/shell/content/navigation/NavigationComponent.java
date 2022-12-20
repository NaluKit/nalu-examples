package com.gihub.nalukit.example.nalucontrollermultipleroute.client.ui.application.shell.content.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.icons.Icons;
import org.dominokit.domino.ui.tree.Tree;
import org.dominokit.domino.ui.tree.TreeItem;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class NavigationComponent
    extends AbstractComponent<INavigationComponent.Controller, HTMLElement>
    implements INavigationComponent {
  
  private TreeItem Screen01Item;
  
  private TreeItem Screen02Item;
  
  private TreeItem Screen03Item;
  
  private TreeItem Screen04Item;
  
  private TreeItem Screen05Item;
  
  public NavigationComponent() {
    super();
  }
  
  @Override
  public void render() {
    this.Screen01Item = TreeItem.create("Screen01",
                                        Icons.ALL.list())
                                .addClickListener(e -> getController().doNavigateTo("screen01"));
    this.Screen02Item = TreeItem.create("Screen02",
                                        Icons.ALL.list())
                                .addClickListener(e -> getController().doNavigateTo("screen02"));
    this.Screen03Item = TreeItem.create("Screen03",
                                        Icons.ALL.list())
                                .addClickListener(e -> getController().doNavigateTo("screen03"));
    this.Screen04Item = TreeItem.create("Screen04",
                                        Icons.ALL.list())
                                .addClickListener(e -> getController().doNavigateTo("screen04"));
    this.Screen05Item = TreeItem.create("Screen05",
                                        Icons.ALL.list())
                                .addClickListener(e -> getController().doNavigateTo("screen05"));
    Tree tree = Tree.create("Navigation");
    tree.appendChild(Screen01Item);
    tree.appendChild(Screen02Item);
    tree.appendChild(Screen03Item);
    tree.appendChild(Screen04Item);
    tree.appendChild(Screen05Item);
    initElement(tree.element());
  }
  
}
