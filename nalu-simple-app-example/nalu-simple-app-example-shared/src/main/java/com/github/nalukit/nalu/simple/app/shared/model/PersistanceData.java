/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
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

package com.github.nalukit.nalu.simple.app.shared.model;

import org.dominokit.jackson.annotation.JSONMapper;

@SuppressWarnings("serial")
@JSONMapper
public class PersistanceData {

  private String       userID;
  private boolean      loggedIn;
  private boolean      personFilterUsed;
  private PersonSearch personSearch;

  /* for serialization only */
  @SuppressWarnings("unused")
  public PersistanceData() {
    super();

    this.loggedIn         = false;
    this.personFilterUsed = false;
  }

  public PersistanceData(String userID,
                         boolean loggedIn,
                         PersonSearch personSearch) {
    this();
    this.userID       = userID;
    this.loggedIn     = loggedIn;
    this.personSearch = personSearch;
  }

  public String getUserID() {
    return userID;
  }

  public void setUserID(String userID) {
    this.userID = userID;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }

  public PersonSearch getPersonSearch() {
    return personSearch;
  }

  public void setPersonSearch(PersonSearch personSearch) {
    this.personSearch = personSearch;
  }

  public boolean isPersonFilterUsed() {
    return personFilterUsed;
  }

  public void setPersonFilterUsed(boolean personFilterUsed) {
    this.personFilterUsed = personFilterUsed;
  }
}
