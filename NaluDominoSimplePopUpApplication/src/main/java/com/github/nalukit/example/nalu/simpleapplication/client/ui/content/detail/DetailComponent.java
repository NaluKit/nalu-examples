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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail;

import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail.IDetailComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractPopUpComponent;
import org.dominokit.domino.ui.button.Button;
import org.dominokit.domino.ui.dialogs.MessageDialog;
import org.dominokit.domino.ui.forms.TextBox;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.modals.ModalDialog;

public class DetailComponent
    extends AbstractPopUpComponent<Controller>
    implements IDetailComponent {

  private ModalDialog dialog;

  private TextBox detailFirstName;
  private TextBox detailName;
  private TextBox detailStreet;
  private TextBox detailZip;
  private TextBox detailCity;

  public DetailComponent() {
  }

  @Override
  public void render() {
    this.dialog = ModalDialog.create("Edit Person")
                             .large()
                             .setAutoClose(false);
    this.detailFirstName = TextBox.create("First name");
    this.detailName = TextBox.create("Name");
    this.detailStreet = TextBox.create("Street");
    this.detailZip = TextBox.create("ZIP");
    this.detailCity = TextBox.create("City");

    this.dialog.appendChild(Row.create()
                               .appendChild(Column.span6()
                                                  .appendChild(this.detailFirstName)
                                                  .styler(style -> style.setMarginBottom("8px")))
                               .appendChild(Column.span6()
                                                  .styler(style -> style.setTextAlign("right"))
                                                  .appendChild(this.detailName)
                                                  .styler(style -> style.setMarginBottom("8px"))))
               .appendChild(Row.create()
                               .appendChild(Column.span12()
                                                  .appendChild(this.detailStreet)))
               .appendChild(Row.create()
                               .appendChild(Column.span2()
                                                  .appendChild(this.detailZip))
                               .appendChild(Column.span10()
                                                  .appendChild(this.detailCity)));

    this.dialog.appendFooterChild(Button.createPrimary("Save")
                                        .style()
                                        .setMarginRight("20px")
                                        .get()
                                        .addClickListener(e -> getController().doUpdate()));
    this.dialog.appendFooterChild(Button.create("Reset")
                                        .addClickListener(e -> getController().doRevert()));

  }

  @Override
  public void bind() {
  }

  @Override
  public void clear() {
    this.detailFirstName.setValue("");
    this.detailName.setValue("");
    this.detailStreet.setValue("");
    this.detailZip.setValue("");
    this.detailCity.setValue("");
  }

  @Override
  public void edit(Person person) {
    if (person != null) {
      detailFirstName.setValue(person.getFirstName());
      detailName.setValue(person.getName());
      detailStreet.setValue(person.getAddress()
                                  .getStreet());
      detailZip.setValue(person.getAddress()
                               .getZip());
      detailCity.setValue(person.getAddress()
                                .getCity());
    }
  }

  @Override
  public Person flush(Person person) {
    person.setFirstName(detailFirstName.getValue());
    person.setName(detailName.getValue());
    person.getAddress()
          .setStreet(detailStreet.getValue());
    person.getAddress()
          .setZip(detailZip.getValue());
    person.getAddress()
          .setCity(detailCity.getValue());
    return person;
  }

  @Override
  public void hide() {
    this.dialog.close();
  }

  @Override
  public boolean isDirty() {
    boolean notDirty = ((getController().getPerson()
                                        .getAddress()
                                        .getStreet()
                                        .equals(detailStreet.getValue())) &&
                        (getController().getPerson()
                                        .getAddress()
                                        .getZip()
                                        .equals(detailZip.getValue())) &&
                        (getController().getPerson()
                                        .getAddress()
                                        .getCity()
                                        .equals(detailCity.getValue())) &&
                        (getController().getPerson()
                                        .getFirstName()
                                        .equals(detailFirstName.getValue())) &&
                        (getController().getPerson()
                                        .getName()
                                        .equals(detailName.getValue())));
    return !notDirty;
  }

  @Override
  public void show() {
    this.dialog.open();
  }

  @Override
  public void showDirtyAlert() {
    MessageDialog messageDialog = MessageDialog.createMessage("Revert changes?",
                                                              "All you changes will be lost!");
    Button cancelButton = Button.create("Cancel")
                                .linkify()
                                .addClickListener(e -> messageDialog.close());
    Button verwerfenButton = Button.create("Revert")
                                   .linkify()
                                   .addClickListener(e -> {
                                     messageDialog.close();
                                     dialog.close();
                                   });
    messageDialog.setAutoClose(false)
                 .warning()
                 .getFooterElement()
                 .clearElement()
                 .appendChild(verwerfenButton)
                 .appendChild(cancelButton);
    messageDialog.open();
  }

}
