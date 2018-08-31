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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.status;

import com.github.mvp4g.nalu.client.component.AbstractComponent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.themebuilder.base.client.config.ThemeDetails;
import com.sencha.gxt.widget.core.client.container.MarginData;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;

public class StatusComponent
  extends AbstractComponent<IStatusComponent.Controller, Widget>
  implements IStatusComponent {

  private static ThemeDetails themeDetails = GWT.create(ThemeDetails.class);

  private Label label;

  public StatusComponent() {
  }

  @Override
  public Widget render() {
    SimpleContainer container = new SimpleContainer();

    container.getElement()
             .getStyle()
             .setProperty("borderTop",
                          themeDetails.borderColor() + " 1px solid");

    this.label = new Label("loading ...");
    this.label.getElement()
              .getStyle()
              .setProperty("fontSize",
                           "24px");
    this.label.getElement()
              .getStyle()
              .setProperty("fontFamily",
                           themeDetails.panel()
                                       .font()
                                       .family());
    this.label.getElement()
              .getStyle()
              .setProperty("color",
                           themeDetails.borderColor());

    container.add(this.label,
                  new MarginData(6));


    return container;
  }

  @Override
  public void setStatus(String status) {
    this.label.setText(status);
  }
}
