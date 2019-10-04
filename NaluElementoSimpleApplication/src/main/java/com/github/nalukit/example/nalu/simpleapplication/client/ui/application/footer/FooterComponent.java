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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.application.footer;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLLabelElement;
import org.jboss.gwt.elemento.core.builder.HtmlContentBuilder;

import static org.jboss.gwt.elemento.core.Elements.*;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
public class FooterComponent
    extends AbstractComponent<IFooterComponent.Controller, HTMLElement>
    implements IFooterComponent {

  private HtmlContentBuilder<HTMLLabelElement> status;

  public FooterComponent() {
  }

  @Override
  public void render() {
    initElement(footer().css("shellFooter")
                        .add(div().add(div().css("shellFooterLeft")
                                            .add(label().css("shellFooterLabel")
                                                        .textContent("GWT Basic training")))
                                  .add(div().css("shellFooterRight")
                                            .add(status = label().css("shellFooterStatus"))))
                        .get());
  }

  @Override
  public void setStatus(String status) {
    this.status.textContent(status);
  }

}
