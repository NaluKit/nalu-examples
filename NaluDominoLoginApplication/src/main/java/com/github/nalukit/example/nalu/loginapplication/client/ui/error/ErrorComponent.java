/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package com.github.nalukit.example.nalu.loginapplication.client.ui.error;

import com.github.nalukit.example.nalu.loginapplication.client.ui.error.IErrorComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractErrorPopUpComponent;
import com.github.nalukit.nalu.client.event.model.ErrorInfo.ErrorType;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Image;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.grid.flex.FlexAlign;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.utils.DominoElement;

import java.util.Map;

public class ErrorComponent
    extends AbstractErrorPopUpComponent<Controller>
    implements IErrorComponent {

  private ModalDialog dialog;

  private Image errorIcon;

  private HTMLDivElement route;
  private HTMLDivElement message;
  private HTMLDivElement data;

  public ErrorComponent() {
  }

  @Override
  public void render() {
    this.dialog = ModalDialog.create(">>To Be Set<<")
                             .large()
                             .setAutoClose(false);

    this.errorIcon = new Image(64,
                               64);
    this.errorIcon.setAttribute("src",
                                "media/images/bug-128.png");
    this.route = DominoElement.div()
                              .asElement();
    this.message = DominoElement.div()
                                .styler(style -> {
                                  style.setMarginBottom("12px");
                                })
                                .asElement();
    DominoElement messageElement = DominoElement.div()
                                                .styler(style -> {
                                                  style.setWidth("100%");
                                                })
                                                .appendChild(DominoElement.div()
                                                                          //                                                                   .styler(style -> style.setWidth("100%"))
                                                                          .styler(style -> style.setFloat("left"))
                                                                          .appendChild(DominoElement.div()
                                                                                                    .setTextContent("Route:")
                                                                                                    .styler(style -> {
                                                                                                      style.setMarginBottom("6px");
                                                                                                      style.setProperty("font-weight",
                                                                                                                        "bold");
                                                                                                    }))
                                                                          .appendChild(DominoElement.div()
                                                                                                    .appendChild(this.route)
                                                                                                    .styler(style -> {
                                                                                                      style.setMarginBottom("24px");
                                                                                                      style.setProperty("font-weight",
                                                                                                                        "bold");
                                                                                                    }))
                                                                          .appendChild(DominoElement.div()
                                                                                                    .setTextContent("Message:")
                                                                                                    .styler(style -> {
                                                                                                      style.setMarginBottom("6px");
                                                                                                      style.setProperty("font-weight",
                                                                                                                        "bold");
                                                                                                    }))
                                                                          .appendChild(DominoElement.div()
                                                                                                    .appendChild(this.message)
                                                                                                    .styler(style -> {
                                                                                                      style.setMarginBottom("24px");
                                                                                                      style.setProperty("font-weight",
                                                                                                                        "bold");
                                                                                                    })));

    FlexLayout flexLayout = FlexLayout.create()
                                      .style()
                                      .add("fill-height")
                                      .get()
                                      .setDirection(FlexDirection.LEFT_TO_RIGHT);

    FlexItem flexItemLeft = FlexItem.create()
                                    .setAlignSelf(FlexAlign.START)
                                    .setOrder(1)
                                    .setFlexGrow(1)
                                    .appendChild(this.errorIcon);
    flexLayout.appendChild(flexItemLeft);

    FlexItem flexItemRight = FlexItem.create()
                                     .styler(style -> style.setMarginLeft("24px"))
                                     .setAlignSelf(FlexAlign.START)
                                     .setOrder(2)
                                     .appendChild(messageElement);
    flexLayout.appendChild(flexItemRight);

    this.dialog.appendChild(flexLayout);

    this.dialog.appendFooterChild(Button.create("OK")
                                        .addClickListener(e -> {
                                          this.hide();
                                          this.getController()
                                              .doRouteHome();
                                        }));
  }

  @Override
  public void clear() {

  }

  @Override
  public void edit(ErrorType errorEventType,
                   String route,
                   String message,
                   Map<String, String> dataStore) {
    if (ErrorType.NALU_INTERNAL_ERROR == errorEventType) {
      this.dialog.getHeaderElement()
                 .setTextContent("Nalu Internal Error");
    } else {
      this.dialog.getHeaderElement()
                 .setTextContent("Application Error");
    }
    this.route.textContent = route;
    this.message.textContent = message;
  }

  @Override
  public void hide() {
    this.dialog.close();
  }

  @Override
  public void show() {
    this.dialog.open();
  }

}
