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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.shell;

import com.github.mvp4g.nalu.client.Nalu;
import com.github.mvp4g.nalu.client.ui.AbstractShell;
import com.github.mvp4g.nalu.client.ui.annotation.ProvidesSelector;
import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.ui.Selectors;
import elemental2.dom.CSSProperties;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.Elements.*;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@ProvidesSelector(selector = {Selectors.CONTENT,
                              Selectors.FOOTER,
                              Selectors.HEADER,
                              Selectors.NAVIGATION})
public class Shell
  extends AbstractShell<NaluSimpleApplicationContext> {

  public Shell() {
  }

  /**
   * The ShellPresenter has to implemented this method, because the framework
   * can not do this. (It does not know, what to use).
   * <p>
   * We append the ShellView to the browser body.
   */
  @Override
  public void attachShell() {
    document.body.appendChild(this.render());
  }


  private HTMLElement render() {
    document.body.style.margin = CSSProperties.MarginUnionType.of(0);

    return div().css("shell")
                .add(createNorth())
                .add(createSouth())
                .add(div().css("shellNavigation")
                          .attr(Nalu.NALU_ID_ATTRIBUTE,
                                "navigation")
                          .asElement())
                .add(div().css("shellContent")
                          .attr(Nalu.NALU_ID_ATTRIBUTE,
                                "content")
                          .asElement())
                .asElement();
  }

  private Element createNorth() {
    return header().css("shellHeader")
                   .attr(Nalu.NALU_ID_ATTRIBUTE,
                         "header")
                   .asElement();
  }

  private Element createSouth() {
    return footer().css("shellFooter")
                   .attr(Nalu.NALU_ID_ATTRIBUTE,
                         "footer")
                   .asElement();
  }
}
