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
package com.github.nalukit.example.nalu.loginapplication;

import com.github.nalukit.example.nalu.loginapplication.module.login.client.NaluLoginApplicationContextLoginModule;
import com.github.nalukit.nalu.client.context.AbstractMainContext;
import com.github.nalukit.nalu.client.context.IsContext;

import elemental2.dom.DomGlobal;

/**
 * A application context of the NaluMailApplication
 */
public class NaluLoginApplicationContext
    extends AbstractMainContext
    implements IsContext {

  public static interface Keys {
    public static final String SEARCH_NAME = "searchName";
    public static final String SEARCH_CITY = "searchCity";
    public static final String VERSION     = "version";
  }
  
  public NaluLoginApplicationContext() {
    super();
    initialize();
  }

  private void initialize() {
    super.getContext()
         .put(NaluLoginApplicationContextLoginModule.Keys.LOGGED_IN,
              false);
    super.getContext()
         .put(Keys.VERSION,
              "2.0.0");
  }

  public String getVersion() {
    return (String) super.getContext()
                         .get(Keys.VERSION);
  }

  public String getSearchCity() {
    return (String) super.getContext()
                         .get(Keys.SEARCH_CITY);
  }

  public void setSearchCity(String searchCity) {
    super.getContext()
         .put(Keys.SEARCH_CITY,
              searchCity);
  }

  public String getSearchName() {
    return (String) super.getContext()
                         .get(Keys.SEARCH_NAME);
  }

  public void setSearchName(String searchName) {
    super.getContext()
         .put(Keys.SEARCH_NAME,
              searchName);
  }

  public String getUser() {
      DomGlobal.window.console.log("getUser");

    return (String) super.getContext()
                         .get(NaluLoginApplicationContextLoginModule.Keys.USER);
  }

}
