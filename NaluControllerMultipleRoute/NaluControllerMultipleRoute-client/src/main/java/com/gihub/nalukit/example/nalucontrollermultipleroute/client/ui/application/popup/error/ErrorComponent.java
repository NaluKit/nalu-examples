package com.gihub.nalukit.example.nalucontrollermultipleroute.client.ui.application.popup.error;

import com.github.nalukit.nalu.client.component.AbstractErrorPopUpComponent;
import com.github.nalukit.nalu.client.event.model.ErrorInfo;
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

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class ErrorComponent
    extends AbstractErrorPopUpComponent<IErrorComponent.Controller>
    implements IErrorComponent {
  
  ModalDialog dialog;
  
  private HTMLDivElement route;
  
  private HTMLDivElement message;
  
  private DominoElement<HTMLDivElement> content;
  
  public ErrorComponent() {
    super();
  }
  
  @Override
  public void render() {
    dialog = ModalDialog.create("to be set")
                        .large()
                        .setAutoClose(false);
    Image errorIcon = new Image(64,
                                64);
    route   = DominoElement.div()
                           .styler(style -> style.setMarginBottom("12px"))
                           .element();
    message = DominoElement.div()
                           .styler(style -> style.setMarginBottom("12px"))
                           .element();
    content = DominoElement.div();
    DominoElement<HTMLDivElement> messageElement = DominoElement.div()
                                                                .styler(style -> style.setWidth("100%"))
                                                                .appendChild(DominoElement.div()
                                                                                          .styler(style -> style.setFloat("left"))
                                                                                          .appendChild(DominoElement.div()
                                                                                                                    .setTextContent("Route:")
                                                                                                                    .styler(style -> {
                                                                                                                      style.setMarginBottom("6px");
                                                                                                                      style.setProperty("font-weight",
                                                                                                                                        "bold");
                                                                                                                    }))
                                                                                          .appendChild(DominoElement.div()
                                                                                                                    .appendChild(route)
                                                                                                                    .styler(style -> {
                                                                                                                      style.setMarginBottom("24px");
                                                                                                                      style.setProperty("font-weight",
                                                                                                                                        "normal");
                                                                                                                    }))
                                                                                          .appendChild(DominoElement.div()
                                                                                                                    .setTextContent("Message:")
                                                                                                                    .styler(style -> {
                                                                                                                      style.setMarginBottom("6px");
                                                                                                                      style.setProperty("font-weight",
                                                                                                                                        "bold");
                                                                                                                    }))
                                                                                          .appendChild(DominoElement.div()
                                                                                                                    .appendChild(message)
                                                                                                                    .styler(style -> {
                                                                                                                      style.setMarginBottom("24px");
                                                                                                                      style.setProperty("font-weight",
                                                                                                                                        "normal");
                                                                                                                    }))
                                                                                          .appendChild(content));
    FlexLayout flexLayout = FlexLayout.create()
                                      .style()
                                      .add("fill-height")
                                      .get()
                                      .setDirection(FlexDirection.LEFT_TO_RIGHT);
    FlexItem flexItemLeft = FlexItem.create()
                                    .setAlignSelf(FlexAlign.START)
                                    .setOrder(1)
                                    .appendChild(errorIcon);
    flexLayout.appendChild(flexItemLeft);
    FlexItem flexItemRight = FlexItem.create()
                                     .styler(style -> style.setMarginLeft("24px"))
                                     .setAlignSelf(FlexAlign.START)
                                     .setFlexGrow(1)
                                     .setOrder(2)
                                     .appendChild(messageElement);
    flexLayout.appendChild(flexItemRight);
    dialog.appendChild(flexLayout);
    this.dialog.appendFooterChild(Button.create("OK")
                                        .large()
                                        .linkify()
                                        .styler(style -> style.setWidth("128px"))
                                        .addClickListener(e -> {
                                          this.hide();
                                          this.getController()
                                              .doRouteHome();
                                        }));
  }
  
  @Override
  public void show() {
    dialog.open();
  }
  
  @Override
  public void hide() {
    dialog.close();
  }
  
  @Override
  public void bind() {
  }
  
  @Override
  public void clear() {
  }
  
  @Override
  public void edit(ErrorInfo.ErrorType errorEventType,
                   String route,
                   String message,
                   Map<String, String> dataStore) {
    content.clearElement();
    if (ErrorInfo.ErrorType.NALU_INTERNAL_ERROR == errorEventType) {
      dialog.getHeaderElement()
            .setTextContent("Nalu Internal Error");
    } else {
      dialog.getHeaderElement()
            .setTextContent("Application Error");
    }
    this.route.textContent   = route;
    this.message.textContent = message;
    dataStore.keySet()
             .forEach(d -> createContentItem(d,
                                             dataStore.get(d)));
  }
  
  private void createContentItem(String label,
                                 String value) {
    this.content.appendChild(DominoElement.div()
                                          .setTextContent(label)
                                          .styler(style -> {
                                            style.setMarginBottom("6px");
                                            style.setProperty("font-weight",
                                                              "bold");
                                          }))
                .appendChild(DominoElement.div()
                                          .setTextContent(value)
                                          .styler(style -> {
                                            style.setMarginBottom("24px");
                                            style.setProperty("font-weight",
                                                              "normal");
                                          }));
  }
  
}
