package com.github.nalukit.nalu.complex.app.common;

import com.github.nalukit.nalu.client.context.AbstractModuleContext;
import com.github.nalukit.nalu.client.context.IsModuleContext;
import com.github.nalukit.nalu.complex.app.shared.model.PersistanceData;
import com.github.nalukit.nalu.complex.app.shared.model.person.PersonSearch;

/**
 * Copyright (C) 2018 - 2021 Frank Hossfeld <frank.hossfeld@googlemail.com>
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class AppContext
    extends AbstractModuleContext
    implements IsModuleContext {

  //  private final static String EDIT_MODE                        = "EDIT_MODE";
  private final static String PERSISTANCE = "PERSISTANCE";
  private final static String USER_ID     = "USER_ID";

  public AppContext() {
    super();

    //    this.setEditMode(EditMode.BROWSE);
  }

  //  public EditMode getEditMode() {
  //    return (EditMode) super.getApplicationContext()
  //                           .get(AhiContext.EDIT_MODE);
  //  }
  //
  //  public void setEditMode(EditMode editMode) {
  //    super.getApplicationContext()
  //         .put(AhiContext.EDIT_MODE,
  //              editMode);
  //  }

  public String getUserId() {
    return (String) super.getApplicationContext()
                         .get(AppContext.USER_ID);

  }

  public void setUserId(String userId) {
    super.getApplicationContext()
         .put(AppContext.USER_ID,
              userId);
  }

  public PersistanceData getPersistance() {
    return (PersistanceData) super.getApplicationContext()
                                  .get(AppContext.PERSISTANCE);
  }

  public void setPersistance(PersistanceData persistanceData) {
    super.getApplicationContext()
         .put(AppContext.PERSISTANCE,
              persistanceData);
  }

  public boolean isFilterPersonUsed() {
    return this.getPersistance()
               .isPersonFilterUsed();
  }

  public void setFilterPersonUsed(boolean used) {
    this.getPersistance()
        .setPersonFilterUsed(used);
  }

  public PersonSearch getPersonSearch() {
    return this.getPersistance()
               .getPersonSearch();
  }

  public void setPersonSearch(PersonSearch search) {
    this.getPersistance()
        .setPersonSearch(search);
  }

  public boolean isLoggedIn() {
    return this.getPersistance() != null;
  }
}
