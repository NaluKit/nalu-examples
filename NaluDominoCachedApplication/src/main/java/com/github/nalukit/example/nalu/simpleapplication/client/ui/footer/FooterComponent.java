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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.footer;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLHeadingElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.Styles;
import org.dominokit.domino.ui.utils.DominoElement;

import static org.jboss.gwt.elemento.core.Elements.h;

/**
 * this is the presenter of the shellCreator. The shellCreator divides the browser in
 * severeal areas.
 */
public class FooterComponent
    extends AbstractComponent<IFooterComponent.Controller, HTMLElement>
    implements IFooterComponent {

  private DominoElement<HTMLHeadingElement> messageInfo;

  public FooterComponent() {
  }

  @Override
  public void render() {
    this.messageInfo = DominoElement.of(h(4))
                                    .setTextContent("loading application ...")
                                    .style()
                                    .add(Styles.font_15,
                                         Styles.align_center)
                                    .get();

    initElement(Row.create()
                   .style()
                   .setMargin("0px")
                   .get()
                   .addColumn(Column.span5()
                                    .offset1()
                                    .appendChild(h(4).css(Styles.font_15,
                                                          Styles.align_center)
                                                     .textContent("Nalu example application using Domnio-UI")))
                   .addColumn(Column.span5()
                                    .appendChild(this.messageInfo))
                   .asElement());
  }

  @Override
  public void setStatus(String status) {
    this.messageInfo.setTextContent(status);
  }

}
