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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.intro;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.container.CenterLayoutContainer;

public class IntroComponent
    extends AbstractComponent<IIntroComponent.Controller, Widget>
    implements IIntroComponent {

  public IntroComponent() {
  }

  @Override
  public void render() {
    GWT.debugger();
    CenterLayoutContainer clc = new CenterLayoutContainer();
    clc.getElement()
       .getStyle()
       .setBackgroundColor("white");

    HTML label = new HTML("<div style=\"text-align: center; font-family: helvetica,arial,verdana,sans-serif; color: #3894D1; font-weight: bold;\">" +
                          "<span style=\"font-size: 24px;\">" +
                          "Welcome<br>to the<br>GXT-Nalu-Example!" +
                          "</span>" +
                          "<br><br><br>" +
                          "<span style=\"font-size: 18px;\">" +
                          "Please,<br>select a mail from the list." +
                          "</span>" +
                          "</div>");
    label.getElement()
         .getStyle()
         .setFontSize(24,
                      Unit.PX);
    clc.add(label);

    initElement(clc);
  }

}
