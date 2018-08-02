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

import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import elemental2.dom.CSSProperties;
import elemental2.dom.Element;
import elemental2.dom.HTMLElement;
import elemental2.dom.Node;

import static elemental2.dom.DomGlobal.document;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.Elements.footer;
import static org.jboss.gwt.elemento.core.Elements.header;
import static org.jboss.gwt.elemento.core.Elements.img;
import static org.jboss.gwt.elemento.core.Elements.label;

public class ShellView
  extends LazyReverseView<IShellView.Presenter>
  implements IShellView {

  private HTMLElement shell;
  private HTMLElement navigation;
  private HTMLElement content;
  private HTMLElement status;

  public ShellView() {
    super();
  }

  @Override
  public Element asElement() {
    return shell;
  }

  @Override
  public void setCenter(Element element) {
    if (content.childElementCount > 0) {
      for (int i = 0; i < content.childNodes.length; i++) {
        Node oldChild = content.childNodes.item(i);
        content.removeChild(oldChild);
      }
    }
    content.appendChild(element);
  }

  @Override
  public void setNavigation(Element element) {
    navigation.appendChild(element);
  }

  @Override
  public void setStatus(String status) {
    this.status.innerHTML = status;
  }

  public void createView() {
    document.body.style.margin = CSSProperties.MarginUnionType.of(0);

    shell = div().css("shell")
                 .add(createNorth())
                 .add(createSouth())
                 .add(navigation = div().css("shellNavigation")
                                        .asElement())
                 .add(content = div().css("shellContent")
                                     .asElement())
                 .asElement();
  }

  private Element createNorth() {
    return header().css("shellHeader")
                   .add(img("media/images/Gwt-logo.png").css("shellHeaderImage"))
                   .asElement();
  }

  private Element createSouth() {
    return footer().css("shellFooter")
                   .add(div().add(div().css("shellFooterLeft")
                                       .add(label().css("shellFooterLabel")
                                                   .textContent("GWT Basic training")))
                             .add(div().css("shellFooterRight")
                                       .add(status = div().css("shellFooterStatus")
                                                          .asElement())))
                   .asElement();
  }
}
