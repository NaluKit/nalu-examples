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

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Person;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.exception.PersonException;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.exception.PersonNotFoundException;
import com.github.nalukit.example.nalu.simpleapplication.client.data.service.PersonService;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.client.component.AbstractPopUpComponentController;
import com.github.nalukit.nalu.client.component.IsPopUpComponentCreator;
import com.github.nalukit.nalu.client.component.annotation.PopUpController;
import elemental2.dom.DomGlobal;

@PopUpController(name = "EditorDetail",
                 componentInterface = IDetailComponent.class,
                 component = DetailComponent.class)
public class DetailPopUpController
    extends AbstractPopUpComponentController<NaluSimpleApplicationContext, IDetailComponent>
    implements IDetailComponent.Controller,
               IsPopUpComponentCreator<IDetailComponent> {

  private Person person;

  private long id;

  public DetailPopUpController() {
  }

  @Override
  public void onBeforeShow() {
    this.component.clear();
  }

  @Override
  public void show() {
    this.id = Long.parseLong(super.dataStore.get("id"));
    if (this.id == 0) {
      this.router.route("/person/search");
    }
    try {
      this.person = PersonService.get()
                                 .get(id);
      // this only works, cause the get method is not asynchron!
      this.component.edit(this.person);
      this.component.show();
      this.eventBus.fireEvent(new StatusChangeEvent("Edit person data with id: " + this.person.getId()));
    } catch (PersonNotFoundException e) {
      DomGlobal.window.alert("Panic!");
    }
  }

  @Override
  public Person getPerson() {
    return this.person;
  }

  @Override
  public IDetailComponent createPopUpComponent() {
    return new DetailComponent();
  }

  @Override
  public void doRevert() {
    if (this.component.isDirty()) {
      this.component.showDirtyAlert();
    } else {
      this.component.hide();
      this.eventBus.fireEvent(new StatusChangeEvent(""));
    }
  }

  @Override
  public void doUpdate() {
    this.person = this.component.flush(this.person);
    try {
      PersonService.get()
                   .update(this.person);
      this.component.hide();
      this.eventBus.fireEvent(new StatusChangeEvent(""));
      if (this.context.getSearchName() == null && this.context.getSearchCity() == null) {
        this.router.route("/application/person/search");
      } else {
        this.router.route("/application/person/list",
                          this.context.getSearchName(),
                          this.context.getSearchCity());
      }
    } catch (PersonException e) {
      DomGlobal.window.alert("Panic!");
    }
  }

}
