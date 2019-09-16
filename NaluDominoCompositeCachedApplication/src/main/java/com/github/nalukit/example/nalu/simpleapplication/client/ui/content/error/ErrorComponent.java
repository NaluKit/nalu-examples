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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.error;

import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.error.IErrorComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractErrorPopUpComponent;
import com.github.nalukit.nalu.client.event.NaluErrorEvent.ErrorType;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.Image;
import org.dominokit.domino.ui.button.Button;
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

    this.errorIcon = new Image(128,
                               128);
    this.errorIcon.setAttribute("src",
                                "media/images/bug-128.png");

    this.route = DominoElement.div()
                              .asElement();
    this.message = DominoElement.div()
                                .styler(style -> {
                                  style.setMarginBottom("12px");
                                })
                                .asElement();
    this.data = DominoElement.div()
                             .asElement();

    // TODO ...

    this.dialog.appendChild(DominoElement.div()
                                         .styler(style -> {
                                           style.setWidth("100%");
                                         })
                                         .appendChild(DominoElement.div()
                                                                   .setWidth("152px")
                                                                   .appendChild(this.errorIcon)
                                                                   .styler(style -> {
                                                                     style.setMargin("12px");
                                                                     style.setFloat("left");
                                                                     style.setAlignItems("top");
                                                                   }))
                                         .appendChild(DominoElement.div()
                                                                   //                                                                   .styler(style -> style.setWidth("100%"))
                                                                   .styler(style -> {
                                                                     style.setMargin("12px");
                                                                     style.setFloat("left");
                                                                   })
                                                                   .appendChild(DominoElement.div()
                                                                                             .setTextContent("Message:")
                                                                                             .styler(style -> {
                                                                                               style.setMarginBottom("12px");
                                                                                               style.setProperty("font-weight",
                                                                                                                 "bold");
                                                                                             }))
                                                                   .appendChild(DominoElement.div()
                                                                                             .appendChild(this.message)
                                                                                             .styler(style -> {
                                                                                               style.setMarginBottom("12px");
                                                                                               style.setProperty("font-weight",
                                                                                                                 "bold");
                                                                                             }))));

    this.dialog.appendFooterChild(Button.create("OK")
                                        .addClickListener(e -> this.hide()));
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
