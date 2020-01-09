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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.blocks.fork;

import com.github.nalukit.example.nalu.simpleapplication.client.ui.blocks.fork.IForkBlockComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractBlockComponent;
import elemental2.dom.DomGlobal;
import elemental2.dom.HTMLAnchorElement;
import org.dominokit.domino.ui.utils.DominoElement;
import org.dominokit.domino.ui.utils.ScreenMedia;

import static org.jboss.gwt.elemento.core.Elements.a;
import static org.jboss.gwt.elemento.core.Elements.img;

public class ForkBlockComponent
    extends AbstractBlockComponent<Controller>
    implements IForkBlockComponent {

  private DominoElement<HTMLAnchorElement> element;

  public ForkBlockComponent() {
  }

  @Override
  public void append() {
    DomGlobal.document.body.appendChild(this.element.element());
  }

  @Override
  public void render() {
    this.element = DominoElement.of(a().attr("href",
                                             "https://github.com/NaluKit/nalu-examples")
                                       .add(img("https://s3.amazonaws.com/github/ribbons/forkme_right_gray_6d6d6d.png").css("github-fork")
                                                                                                                       .attr("alt",
                                                                                                                             "Fork me on GitHub")));
  }

  @Override
  public void show() {
    this.element.styler(style -> style.setDisplay("block"));

  }

  @Override
  public void hide() {
    this.element.styler(style -> style.setDisplay("none"));
  }

}
