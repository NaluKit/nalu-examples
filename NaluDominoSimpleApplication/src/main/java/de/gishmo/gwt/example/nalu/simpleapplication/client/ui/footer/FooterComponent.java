/*
 * Copyright (c) 2018 - Frank Hossfeld
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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.footer;

import com.github.mvp4g.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.column.Column;
import org.dominokit.domino.ui.row.Row;
import org.dominokit.domino.ui.style.Style;

import static org.jboss.gwt.elemento.core.Elements.h;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
public class FooterComponent
  extends AbstractComponent<IFooterComponent.Controller, HTMLElement>
  implements IFooterComponent {

  private HTMLElement messageInfo;

  public FooterComponent() {
  }

  @Override
  public HTMLElement render() {
    this.messageInfo = h(4).textContent("loading application ...")
                           .asElement();

    return Row.create()
              .style()
              .setMargin("0px")
              .css("demo-footer")
              .get()
              .addColumn(Style.of(Column.span6())
                              .get()
                              .addElement(h(4).textContent("Nalu example application using Domnio-UI")))
              .addColumn(Style.of(Column.span6())
                              .setTextAlign("right")
                              .get()
                              .addElement(this.messageInfo))
              .asElement();
  }

  @Override
  public void setStatus(String status) {
    this.messageInfo.textContent = status;
  }
}
