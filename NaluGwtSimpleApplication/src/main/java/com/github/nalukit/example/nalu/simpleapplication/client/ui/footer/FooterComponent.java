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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.footer;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ResizeLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationConstants;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationCss;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationStyleFactory;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
public class FooterComponent
  extends AbstractComponent<IFooterComponent.Controller, Widget>
  implements IFooterComponent {

  private Label status;

  public FooterComponent() {
  }

  @Override
  public void render() {
    ApplicationCss style = ApplicationStyleFactory.get()
                                                  .getStyle();
    ResizeLayoutPanel footerPanel = new ResizeLayoutPanel();
    footerPanel.addStyleName(style.footerPanel());

    FlowPanel panel = new FlowPanel();
    footerPanel.add(panel);

    FlowPanel left = new FlowPanel();
    left.addStyleName(style.footerLeft());
    panel.add(left);

    FlowPanel right = new FlowPanel();
    right.addStyleName(style.footerRight());
    panel.add(right);

    Label label = new Label(ApplicationConstants.CONSTANTS.footerText());
    label.addStyleName(style.footerLabel());
    left.add(label);

    status = new Label("");
    status.addStyleName(style.footerStatus());
    right.add(status);

    initElement(footerPanel);
  }

  @Override
  public void setStatus(String status) {
    this.status.setText(status);
  }
}
