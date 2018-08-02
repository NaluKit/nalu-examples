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

import com.github.mvp4g.nalu.react.NaluReact;
import com.github.mvp4g.nalu.react.ui.IsNaluShell;
import com.github.mvp4g.nalu.react.ui.annotations.ProvidesSelector;
import elemental2.dom.CSSProperties;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.Elements.*;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@ProvidesSelector(selector = {"header", "navigation", "footer", "content"})
public class Shell
  implements IsNaluShell {

  private HTMLElement status;

  public Shell() {
  }

  /**
   * The ShellPresenter has to implemented this method, because the framework
   * can not do this. (It does not know, what to use).
   *
   * We append the ShellView to the browser body.
   */
  @Override
  public void setShell() {
    document.body.appendChild(this.render());
  }

//  /**
//   * Set the status to the footer and displays it!
//   *
//   * @param status The new message to display.
//   */
//  @EventHandler
//  public void onSetStatus(String status) {
//    view.setStatus(status);
//  }


  private HTMLElement render() {
    document.body.style.margin = CSSProperties.MarginUnionType.of(0);

    return div().css("shell")
                 .add(createNorth())
                 .add(createSouth())
                 .add(div().css("shellNavigation")
                                        .attr(NaluReact.NALU_ID_ATTRIBUTE, "navigation")
                                        .asElement())
                 .add(div().css("shellContent")
                                     .attr(NaluReact.NALU_ID_ATTRIBUTE, "content")
                                     .asElement())
                 .asElement();
  }

  private Element createNorth() {
    return header().css("shellHeader")
                   .attr(NaluReact.NALU_ID_ATTRIBUTE, "header")
                   .add(img("media/images/Gwt-logo.png").css("shellHeaderImage"))
                   .asElement();
  }

  private Element createSouth() {
    return footer().css("shellFooter")
                   .attr(NaluReact.NALU_ID_ATTRIBUTE, "footer")
                   .add(div().add(div().css("shellFooterLeft")
                                       .add(label().css("shellFooterLabel")
                                                   .textContent("GWT Basic training")))
                             .add(div().css("shellFooterRight")
                                       .add(status = div().css("shellFooterStatus")
                                                          .asElement())))
                   .asElement();
  }
}
