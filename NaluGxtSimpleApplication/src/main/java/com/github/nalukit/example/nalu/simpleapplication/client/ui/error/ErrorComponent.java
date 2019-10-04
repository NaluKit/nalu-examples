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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.error;

import com.github.nalukit.example.nalu.simpleapplication.client.ui.ImageResources;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.error.IErrorComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractErrorPopUpComponent;
import com.github.nalukit.nalu.client.event.model.ErrorInfo.ErrorType;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.SimpleLayoutPanel;
import com.sencha.gxt.core.client.dom.ScrollSupport.ScrollMode;
import com.sencha.gxt.core.client.util.Margins;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer.BorderLayoutData;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;

import java.util.Map;
import java.util.Objects;

public class ErrorComponent
    extends AbstractErrorPopUpComponent<Controller>
    implements IErrorComponent {

  /* ThemeDetails des aktuell verwendeten Themes */
  private static ThemeDetails            themeDetails = GWT.create(ThemeDetails.class);
  private        Dialog                  dialog;
  private        BorderLayoutContainer   blc;
  private        VerticalLayoutContainer center;

  public ErrorComponent() {
  }

  private void setUpElementWithTextThemeDetails(Element element,
                                                boolean bold) {
    element.getStyle()
           .setProperty("fontSize",
                        themeDetails.panel()
                                    .font()
                                    .size());
    element.getStyle()
           .setProperty("fontFamily",
                        themeDetails.panel()
                                    .font()
                                    .family());
    element.getStyle()
           .setProperty("color",
                        "black");
    if (bold) {
      element.getStyle()
             .setProperty("fontWeight",
                          "bold");
    }
  }

  @Override
  public void render() {
    Image bugImage = new Image(ImageResources.IMAGES.bug());

    this.blc = new BorderLayoutContainer();
    this.blc.setSize("100%",
                     "100%");

    ContentPanel cpWest = new ContentPanel();
    cpWest.setHeaderVisible(false);
    cpWest.setBodyStyle("background-color: white; padding: 12px");
    cpWest.setLayoutData(new BorderLayoutData(88));
    SimpleLayoutPanel sp = new SimpleLayoutPanel();
    sp.setWidget(bugImage);
    cpWest.setWidget(sp);
    this.blc.setWestWidget(cpWest);

    ContentPanel cpCenter = new ContentPanel();
    cpCenter.setHeaderVisible(false);
    cpCenter.setBodyStyle("background-color: white; padding: 12px");
    this.center = new VerticalLayoutContainer();
    this.center.setScrollMode(ScrollMode.AUTOY);
    cpCenter.setWidget(this.center);
    this.blc.setCenterWidget(cpCenter);

    this.dialog = new Dialog();
    this.dialog.setPixelSize(450,
                             300);
    this.dialog.setHeading("Error Message");
    this.dialog.setResizable(false);
    this.dialog.setBodyBorder(false);
    this.dialog.setHideOnButtonClick(true);
    this.dialog.setClosable(false);
    this.dialog.setWidget(this.blc);

  }

  @Override
  public void bind() {
    this.dialog.getButton(PredefinedButton.OK)
               .addSelectHandler(e -> getController().doNavigateToIntro());
  }

  @Override
  public void clear() {
    this.center.clear();
  }

  @Override
  public void edit(ErrorType errorEventType,
                   String route,
                   String message,
                   Map<String, String> dataStore) {
    Label errorType = new Label();
    errorType.getElement()
             .getStyle()
             .setProperty("fontSize",
                          "18px");
    this.setUpElementWithTextThemeDetails(errorType.getElement(),
                                          true);
    if (ErrorType.APPLICAITON_ERROR == errorEventType) {
      errorType.setText("An Application Error occured!");
    } else {
      errorType.setText("A Nalu Error occured!");
    }
    this.center.add(errorType,
                    new VerticalLayoutData(1,
                                           -1,
                                           new Margins(0,
                                                       0,
                                                       12,
                                                       0)));

    if (!Objects.isNull(route)) {
      printMessage("Route:",
                   route);
    }

    printMessage("Error:",
                 message);
    this.blc.forceLayout();
  }

  private void printMessage(String headline,
                            String text) {
    Label headlineLine = new Label(headline);
    this.setUpElementWithTextThemeDetails(headlineLine.getElement(),
                                          true);
    this.center.add(headlineLine,
                    new VerticalLayoutData(1,
                                           -1));
    Label textLabel = new Label(text);
    this.setUpElementWithTextThemeDetails(textLabel.getElement(),
                                          false);
    this.center.add(textLabel,
                    new VerticalLayoutData(1,
                                           -1,
                                           new Margins(0,
                                                       0,
                                                       12,
                                                       0)));
  }

  @Override
  public void hide() {
    this.dialog.hide();
  }

  @Override
  public void show() {
    this.dialog.show();
    this.dialog.center();
  }

}
