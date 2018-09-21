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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.navigation;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.Widget;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationConstants;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationCss;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationStyleFactory;

public class NavigationComponent
  extends AbstractComponent<INavigationComponent.Controller, Widget>
  implements INavigationComponent {

  private Button searchButton;

  private Button listButton;

  public NavigationComponent() {
  }

  @Override
  public void render() {
    ApplicationCss style = ApplicationStyleFactory.get()
                                                  .getStyle();
    FlowPanel panel = new FlowPanel();

    searchButton = new Button(ApplicationConstants.CONSTANTS.searchFormButton());
    searchButton.addStyleName(style.navigationButton());
    panel.add(searchButton);

    listButton = new Button(ApplicationConstants.CONSTANTS.listFormButton());
    listButton.addStyleName(style.navigationButton());
    panel.add(listButton);

    initElement(panel);
  }

  @Override
  public void bind() {
    searchButton.addClickHandler(event -> getController().doShowSearch());
    listButton.addClickHandler(event -> getController().doShowList());
  }
}
