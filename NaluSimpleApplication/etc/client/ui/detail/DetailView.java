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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.detail;

import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.nalu.simpleapplication.client.widgets.TextField;
import com.github.mvp4g.mvp4g2.core.ui.LazyReverseView;
import elemental2.dom.Element;
import elemental2.dom.HTMLButtonElement;
import elemental2.dom.HTMLDivElement;

import static org.jboss.gwt.elemento.core.Elements.button;
import static org.jboss.gwt.elemento.core.Elements.div;
import static org.jboss.gwt.elemento.core.EventType.click;


public class DetailView
  extends LazyReverseView<IDetailView.Presenter>
  implements IDetailView {

  private HTMLDivElement container;

  private TextField detailFirstName;
  private TextField detailName;
  private TextField detailStreet;
  private TextField detailZip;
  private TextField detailCity;

  private HTMLButtonElement saveButton;
  private HTMLButtonElement revertButton;

  private Person person;

  public DetailView() {
    super();
  }

  public void createView() {
    container = div().add(div().style("width: 100%;")
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
                                                            updateDetailForm();
                                                            getPresenter().doUpdate(person);
                                                          }))
                                         .add(button().css("button")
                                                      .textContent("Revert")
                                                      .on(click,
                                                          event -> {
                                                            getPresenter().doRevert();
                                                          }))))
                     .asElement();
  }

  private void updateDetailForm() {
    person.setFirstName(detailFirstName.getText());
    person.setName(detailName.getText());
    person.getAddress()
          .setStreet(detailStreet.getText());
    person.getAddress()
          .setZip(detailZip.getText());
    person.getAddress()
          .setCity(detailCity.getText());
  }

  @Override
  public Element asElement() {
    return container;
  }

  @Override
  public boolean isDirty() {
    boolean notDirty = (person.getFirstName()
                              .equals(detailFirstName.getText())
                       ) &&
                       (person.getName()
                              .equals(detailName.getText())
                       ) &&
                       (person.getAddress()
                              .getStreet()
                              .equals(detailStreet.getText())
                       ) &&
                       (person.getAddress()
                              .getZip()
                              .equals(detailZip.getText())
                       ) &&
                       (person.getAddress()
                              .getCity()
                              .equals(detailCity.getText())
                       );
    return !notDirty;
  }

  @Override
  public void setUpData(Person person) {
    this.person = person;
    setDetailForm();
  }

  private void setDetailForm() {
    if (person != null) {
      detailFirstName.setText(person.getFirstName());
      detailName.setText(person.getName());
      detailStreet.setText(person.getAddress()
                                 .getStreet());
      detailZip.setText(person.getAddress()
                              .getZip());
      detailCity.setText(person.getAddress()
                               .getCity());
    }
  }
}
