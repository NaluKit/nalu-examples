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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.header;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Widget;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationCss;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationStyleFactory;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ImageResources;

public class HeaderComponent
  extends AbstractComponent<IHeaderComponent.Controller, Widget>
  implements IHeaderComponent {

  public HeaderComponent() {
  }

  @Override
  public void render() {
    ApplicationCss style = ApplicationStyleFactory.get()
                                                  .getStyle();

    FlowPanel panel = new FlowPanel();
    panel.addStyleName(style.headerPanel());

    Image image = new Image(ImageResources.INSTANCE.gwtLogo());
    image.addStyleName(style.header());
    panel.add(image);

    initElement(panel);
  }
}
