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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.content.detail;

import com.github.mvp4g.nalu.client.component.AbstractComponent;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.nalu.simpleapplication.client.widgets.TextField;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLElement;

import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.EventType.click;

public class DetailComponent
  extends AbstractComponent<IDetailComponent.Controller, HTMLElement>
  implements IDetailComponent {

  private TextField detailFirstName;

  private TextField detailName;

  private TextField detailStreet;

  private TextField detailZip;

  private TextField detailCity;

  private HTMLButtonElement saveButton;

  private HTMLButtonElement revertButton;

  public DetailComponent() {
  }

  @Override
  public void render() {
    initElement(div().add(div().style("width: 100%;")
                               .add(div().css("headline")
                                         .textContent("Details"))
                               .add(detailFirstName = new TextField("Firstname"))
                               .add(detailName = new TextField("Name"))
                               .add(detailStreet = new TextField("Street"))
                               .add(detailZip = new TextField("Zip"))
                               .add(detailCity = new TextField("City"))
                               .add(div().css("buttonBar")
                                         .add(button().css("button")
                                                      .textContent("Save")
                                                      .on(click,
                                                          event -> {
                                                            getController().doUpdate();
                                                          }))
                                         .add(button().css("button")
                                                      .textContent("Revert")
                                                      .on(click,
                                                          event -> {
                                                            getController().doRevert();
                                                          }))))
                     .asElement());
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
                                       .equals(detailFirstName.getText())
                       ) &&
                       (getController().getPerson()
                                       .getName()
                                       .equals(detailName.getText())
                       ) &&
                       (getController().getPerson()
                                       .getAddress()
                                       .getStreet()
                                       .equals(detailStreet.getText())
                       ) &&
                       (getController().getPerson()
                                       .getAddress()
                                       .getZip()
                                       .equals(detailZip.getText())
                       ) &&
                       (getController().getPerson()
                                       .getAddress()
                                       .getCity()
                                       .equals(detailCity.getText())
                       );
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
