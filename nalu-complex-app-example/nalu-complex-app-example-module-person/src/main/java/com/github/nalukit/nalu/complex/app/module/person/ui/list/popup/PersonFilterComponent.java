/*
 * Copyright (c) 2018 - Frank Hossfeld
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

package com.github.nalukit.nalu.complex.app.module.person.ui.list.popup;

import com.github.nalukit.nalu.complex.app.common.ui.AbstractAppPopUpComponent;
import com.github.nalukit.nalu.complex.app.shared.model.person.PersonSearch;
import elemental2.dom.Event;
import elemental2.dom.HTMLDivElement;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.forms.FieldsGrouping;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexJustifyContent;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.header.BlockHeader;
import org.dominokit.domino.ui.loaders.Loader;
import org.dominokit.domino.ui.loaders.LoaderEffect;
import org.dominokit.domino.ui.modals.IsModalDialog;
import org.dominokit.domino.ui.modals.ModalDialog;
import org.dominokit.domino.ui.utils.DominoElement;
import org.gwtproject.editor.client.Editor;
import org.gwtproject.editor.client.SimpleBeanEditorDriver;
import org.gwtproject.editor.client.annotation.IsDriver;

public class PersonFilterComponent
    extends AbstractAppPopUpComponent<IPersonFilterComponent.Controller>
    implements IPersonFilterComponent,
               Editor<PersonSearch> {

  @Path("name")
  TextBox name;

  @Path("city")
  TextBox city;

  private ModalDialog    dialog;
  private Loader         loader;
  private FieldsGrouping grouping;
  private Button         searchButton;

  private Driver driver;

  public PersonFilterComponent() {
  }

  @Override
  public void render() {
    this.createWidgets();
    this.createFields();
    this.build();
  }

  private void createWidgets() {
    this.dialog = ModalDialog.create()
                             .setModal(true)
                             .setType(IsModalDialog.ModalType.TOP_SHEET)
                             .setAutoClose(false);
    this.dialog.getFooterElement()
               .hide();

    this.loader = Loader.create(this.dialog.element(),
                                LoaderEffect.BOUNCE)
                        .setLoadingText("Work in Progress ...");

    this.searchButton = Button.create("Search")
                              .linkify()
                              .setWidth("120px")
                              .styler(style -> style.setMargin("5px"))
                              .addClickListener(this::onClick);
  }

  private void onClick(Event event) {
    if (!this.grouping.validate()
                      .isValid()) {
      return;
    }
    this.dialog.close();
    getController().doSearch(driver.flush());
  }

  private void createFields() {
    this.grouping = FieldsGrouping.create();
    this.name     = TextBox.create("Name")
                           .groupBy(this.grouping);
    this.city     = TextBox.create("City")
                           .groupBy(this.grouping);
  }

  private void build() {
    DominoElement<HTMLDivElement> container = DominoElement.div()
                                                           .setWidth("400px");

    container.appendChild(BlockHeader.create("Search Person ..."))
             .appendChild(this.name)
             .appendChild(this.city)
             .appendChild(FlexLayout.create()
                                    .setDirection(FlexDirection.RIGHT_TO_LEFT)
                                    .appendChild(FlexItem.create()
                                                         .appendChild(this.searchButton)));

    this.dialog.appendChild(FlexLayout.create()
                                      .setJustifyContent(FlexJustifyContent.CENTER)
                                      .setJustifyContent(FlexJustifyContent.CENTER)
                                      .appendChild(FlexItem.create()
                                                           .appendChild(container)));
  }

  @Override
  public void bind() {
    this.driver = new PersonFilterComponent_Driver_Impl();
    this.driver.initialize(this);
  }

  @Override
  public void show() {
    if (!this.dialog.isOpen()) {
      this.dialog.open();
    }
  }

  @Override
  public void hide() {
    if (this.dialog.isOpen()) {
      this.dialog.close();
    }
  }

  @Override
  public boolean isOpen() {
    return this.dialog.isOpen();
  }

  @Override
  public void edit(PersonSearch model) {
    this.driver.edit(model);
  }

  @Override
  public void lock() {
    this.loader.start();
  }

  @Override
  public void unlock() {
    this.loader.stop();
  }

  @IsDriver
  interface Driver
      extends SimpleBeanEditorDriver<PersonSearch, PersonFilterComponent> {

  }

}
