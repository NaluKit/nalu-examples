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

import com.github.mvp4g.nalu.client.ui.AbstractComponent;
import com.github.mvp4g.nalu.client.ui.annotations.Route;
import de.gishmo.gwt.example.nalu.simpleapplication.client.ui.Selectors;
import elemental2.dom.HTMLElement;

import static org.jboss.gwt.elemento.core.Elements.*;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@Route(route = "/", selector = Selectors.FOOTER)
public class Footer
  extends AbstractComponent {

  private HTMLElement status;

  public Footer() {
  }

  @Override
  public HTMLElement render() {
    return footer().css("shellFooter")
                   .add(div().add(div().css("shellFooterLeft")
                                       .add(label().css("shellFooterLabel")
                                                   .textContent("GWT Basic training")))
                             .add(div().css("shellFooterRight")
                                       .add(status = div().css("shellFooterStatus")
                                                          .asElement())))
                   .asElement();
  }

  @Override
  public void start() {

  }
}
