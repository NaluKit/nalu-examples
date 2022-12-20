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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.application.content.detail;

import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationConstants;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationCss;
import com.github.nalukit.example.nalu.simpleapplication.client.resources.ApplicationStyleFactory;
import com.github.nalukit.example.nalu.simpleapplication.client.widgets.TextField;
import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;

public class DetailComponent
    extends AbstractComponent<IDetailComponent.Controller, Widget>
    implements IDetailComponent {

  private TextField detailFirstName;

  private TextField detailName;

  private TextField detailStreet;

  private TextField detailZip;

  private TextField detailCity;

  private Button saveButton;

  private Button revertButton;

  //  private Person person;

  public DetailComponent() {
  }

  @Override
  public void render() {
    ApplicationCss style = ApplicationStyleFactory.get()
                                                  .getStyle();

    ScrollPanel panel = new ScrollPanel();

    FlowPanel detailPanel = new FlowPanel();
    detailPanel.addStyleName(style.detailPanel());
    panel.add(detailPanel);

    Label headline = new Label(ApplicationConstants.CONSTANTS.detailHeadline());
    headline.addStyleName(style.headline());
    detailPanel.add(headline);

    detailFirstName = new TextField(ApplicationConstants.CONSTANTS.detailFirstName());
    detailPanel.add(detailFirstName);

    detailName = new TextField(ApplicationConstants.CONSTANTS.detailName());
    detailPanel.add(detailName);

    detailStreet = new TextField(ApplicationConstants.CONSTANTS.detailStreet());
    detailPanel.add(detailStreet);

    detailZip = new TextField(ApplicationConstants.CONSTANTS.detailZip());
    detailPanel.add(detailZip);

    detailCity = new TextField(ApplicationConstants.CONSTANTS.detailCity());
    detailPanel.add(detailCity);

    FlowPanel buttonBar = new FlowPanel();
    buttonBar.addStyleName(style.searchPanelButtonBar());
    detailPanel.add(buttonBar);

    saveButton = new Button(ApplicationConstants.CONSTANTS.saveButton());
    saveButton.addStyleName(style.button());
    buttonBar.add(saveButton);

    revertButton = new Button(ApplicationConstants.CONSTANTS.revertButton());
    revertButton.addStyleName(style.button());
    buttonBar.add(revertButton);

    Anchor anchor = new Anchor("Quick link to search screen");
    anchor.getElement()
          .getStyle()
          .setMarginLeft(6,
                         Style.Unit.PX);
    anchor.setHref(getController().getHRef());
    detailPanel.add(anchor);

    initElement(panel);
  }

  public void bind() {
    saveButton.addClickHandler(event -> {
      getController().doUpdate();
    });

    revertButton.addClickHandler(event -> getController().doRevert());
  }

  @Override
  public void edit(Person result) {
    if (result != null) {
      detailFirstName.setText(result.getFirstName());
      detailName.setText(result.getName());
      detailStreet.setText(result.getAddress()
                                 .getStreet());
      detailZip.setText(result.getAddress()
                              .getZip());
      detailCity.setText(result.getAddress()
                               .getCity());
    }
  }

  @Override
  public boolean isDirty() {
    boolean notDirty = (getController().getPerson()
                                       .getFirstName()
                                       .equals(detailFirstName.getText())) &&
                       (getController().getPerson()
                                       .getName()
                                       .equals(detailName.getText())) &&
                       (getController().getPerson()
                                       .getAddress()
                                       .getStreet()
                                       .equals(detailStreet.getText())) &&
                       (getController().getPerson()
                                       .getAddress()
                                       .getZip()
                                       .equals(detailZip.getText())) &&
                       (getController().getPerson()
                                       .getAddress()
                                       .getCity()
                                       .equals(detailCity.getText()));
    return !notDirty;
  }

  @Override
  public Person flush(Person person) {
    person.setFirstName(detailFirstName.getText());
    person.setName(detailName.getText());
    person.getAddress()
          .setStreet(detailStreet.getText());
    person.getAddress()
          .setZip(detailZip.getText());
    person.getAddress()
          .setCity(detailCity.getText());
    return person;
  }

}
