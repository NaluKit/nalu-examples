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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.error.content.error;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.github.nalukit.nalu.client.event.model.ErrorInfo;
import com.github.nalukit.nalu.client.event.model.ErrorInfo.ErrorType;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import org.jboss.elemento.Elements;

import static import org.jboss.elemento.Elements;.div;
import static org.jboss.gwt.elemento.core.EventType.click;

public class ErrorComponent
    extends AbstractComponent<IErrorComponent.Controller, HTMLElement>
    implements IErrorComponent {

  private HTMLDivElement errorType;

  private HTMLDivElement errorRoute;

  private HTMLDivElement errorMessage;

  private HTMLButtonElement okButton;

  public ErrorComponent() {
  }

  @Override
  public void render() {
    this.errorType = Elements.div()
                             .css("headline")
                             .element();
    this.errorRoute = Elements.div()
                              .css("text")
                              .element();
    this.errorMessage = Elements.div()
                                .css("text")
                                .element();

    this.okButton = Elements.button()
                            .add("OK")
                            .css("button")
                            .on(click, e -> getController().doClickOkButton())
                            .element();

    initElement(div().add(div().style("width: 100%; text-align: center; padding: 24px;")
                               .add(div().add(this.errorType))
                               .add(Elements.div()
                                            .add("Route")
                                            .css("title"))
                               .add(Elements.div()
                                            .add(this.errorRoute))
                               .add(Elements.div()
                                            .add("Message")
                                            .css("title"))
                               .add(Elements.div()
                                            .add(this.errorRoute))
                               .add(Elements.div()
                                            .add(this.okButton))).element());
  }

  @Override
  public void edit(ErrorInfo errorInfo) {
    if (ErrorType.APPLICAITON_ERROR == errorInfo.getErrorEventType()) {
      this.errorType.textContent = "An Application Error occured!";
    } else {
      this.errorType.textContent = "A Nalu Error occured!";
    }
    this.errorRoute.textContent = errorInfo.getRoute();
    this.errorMessage.textContent = errorInfo.getMessage();
  }

}
