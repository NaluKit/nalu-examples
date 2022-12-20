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
package com.github.nalukit.example.nalu.loginapplication.core.client;

import com.github.nalukit.nalu.client.application.IsContext;

/**
 * A application context of the NaluMailApplication
 */
public class NaluLoginApplicationContext
    implements IsContext {

  private String version;

  private String searchName;

  private String searchCity;

  private boolean loggedIn;

  public NaluLoginApplicationContext() {
    this.version = "2.0.0";
    this.loggedIn = false;
  }

  public String getVersion() {
    return version;
  }

  public String getSearchCity() {
    return searchCity;
  }

  public void setSearchCity(String searchCity) {
    this.searchCity = searchCity;
  }

  public String getSearchName() {
    return searchName;
  }

  public void setSearchName(String searchName) {
    this.searchName = searchName;
  }

  public boolean isLoggedIn() {
    return loggedIn;
  }

  public void setLoggedIn(boolean loggedIn) {
    this.loggedIn = loggedIn;
  }
}
