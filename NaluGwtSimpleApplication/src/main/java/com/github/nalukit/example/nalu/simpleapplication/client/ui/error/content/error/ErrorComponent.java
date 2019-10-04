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

import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationConstants;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationCss;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationStyleFactory;
import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.github.nalukit.nalu.client.event.model.ErrorInfo;
import com.github.nalukit.nalu.client.event.model.ErrorInfo.ErrorType;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.*;

public class ErrorComponent
    extends AbstractComponent<IErrorComponent.Controller, Widget>
    implements IErrorComponent {

  private Label errorType;

  private Label errorRoute;

  private Label errorMessage;

  private Button okButton;

  public ErrorComponent() {
  }

  @Override
  public void render() {
    ApplicationCss style = ApplicationStyleFactory.get()
                                                  .getStyle();
    ScrollPanel panel = new ScrollPanel();

    FlowPanel errorPanel = new FlowPanel();
    errorPanel.addStyleName(style.searchPanel());
    panel.add(errorPanel);

    this.errorType = new Label();
    this.errorType.addStyleName(style.headline());
    errorPanel.add(this.errorType);

    Label labelTitleRoute = new Label(ApplicationConstants.CONSTANTS.titleRoute());
    labelTitleRoute.addStyleName(style.title());
    errorPanel.add(labelTitleRoute);

    this.errorRoute = new Label();
    this.errorRoute.addStyleName(style.text());
    errorPanel.add(this.errorRoute);

    Label labelTitleMessage = new Label(ApplicationConstants.CONSTANTS.titleMessage());
    labelTitleMessage.addStyleName(style.title());
    errorPanel.add(labelTitleMessage);

    this.errorMessage = new Label();
    this.errorMessage.addStyleName(style.text());
    errorPanel.add(this.errorMessage);

    this.okButton = new Button(ApplicationConstants.CONSTANTS.okButton());
    this.okButton.addStyleName(style.button());
    this.okButton.getElement()
                 .getStyle()
                 .setMarginTop(92,
                               Unit.PX);
    errorPanel.add(this.okButton);

    initElement(panel);
  }

  @Override
  public void edit(ErrorInfo errorInfo) {
    if (ErrorType.APPLICAITON_ERROR == errorInfo.getErrorEventType()) {
      this.errorType.setText("An Application Error occured!");
    } else {
      this.errorType.setText("A Nalu Error occured!");
    }
    this.errorRoute.setText(errorInfo.getRoute());
    this.errorMessage.setText(errorInfo.getMessage());
  }

  @Override
  public void bind() {
    this.okButton.addClickHandler(e -> getController().doClickOkButton());
  }

}
