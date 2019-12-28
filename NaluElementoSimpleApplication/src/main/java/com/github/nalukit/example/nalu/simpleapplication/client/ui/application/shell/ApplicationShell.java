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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.application.shell;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import elemental2.dom.CSSProperties;
import elemental2.dom.Element;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.Elements.*;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@Shell("application")
public class ApplicationShell
    extends AbstractShell<NaluSimpleApplicationContext> {

  private HTMLDivElement shell;

  public ApplicationShell() {
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

  /**
   * The ShellPresenter has to implemented this method, because the framework
   * can not do this. (It does not know, what to use).
   * <p>
   * We remmove the ShellView from the browser body.
   */
  @Override
  public void detachShell() {
    document.body.removeChild(this.shell);
  }

  private HTMLElement render() {
    document.body.style.margin = CSSProperties.MarginUnionType.of(0);

    this.shell = div().css("shell")
                      .add(createNorth())
                      .add(createSouth())
                      .add(div().css("shellNavigation")
                                .attr("id",
                                      "navigation"))
                      .add(div().css("shellContent")
                                .attr("id",
                                      "content"))
                      .element();

    return this.shell;
  }

  private Element createNorth() {
    return header().css("shellHeader")
                   .attr("id",
                         "header")
                   .element();
  }

  private Element createSouth() {
    return footer().css("shellFooter")
                   .attr("id",
                         "footer")
                   .element();
  }

}
