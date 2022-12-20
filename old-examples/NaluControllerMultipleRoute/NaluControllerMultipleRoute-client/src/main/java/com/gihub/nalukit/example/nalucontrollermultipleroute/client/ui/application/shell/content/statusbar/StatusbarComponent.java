package com.gihub.nalukit.example.nalucontrollermultipleroute.client.ui.application.shell.content.statusbar;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.style.Style;
import org.jboss.elemento.Elements;

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
public class StatusbarComponent
    extends AbstractComponent<IStatusbarComponent.Controller, HTMLElement>
    implements IStatusbarComponent {
  
  private HTMLDivElement messageInfo;
  
  public StatusbarComponent() {
    super();
  }
  
  @Override
  public void edit(String message) {
    messageInfo.textContent = message;
  }
  
  @Override
  public void render() {
    messageInfo = Elements.div()
                          .element();
    initElement(Row.create()
                   .style()
                   .setMargin("0px")
                   .add("demo-footer")
                   .get()
                   .addColumn(Style.of(Column.span6())
                                   .get()
                                   .appendChild(Elements.h(4)
                                                        .textContent("Nalu example application using Domino-UI")))
                   .addColumn(Style.of(Column.span6())
                                   .setTextAlign("right")
                                   .get()
                                   .appendChild(this.messageInfo))
                   .element());
  }
  
}
