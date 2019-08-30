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
package com.github.nalukit.example.nalu.loginapplication.plugin.error.client;

import com.github.nalukit.nalu.client.context.AbstractModuleContext;
import com.github.nalukit.nalu.client.context.module.IsModuleContext;

/**
 * A application context of the NaluMailApplication
 */
public class NaluLoginApplicationContextErrorModule
    extends AbstractModuleContext
    implements IsModuleContext {

  private static final String LOGGED_IN   = "loggedIn";
  private static final String SEARCH_NAME = "searchName";
  private static final String SEARCH_CITY = "searchCity";
  private static final String USER        = "user";
  private static final String VERSION     = "version";

  private boolean loggedIn;

  public NaluLoginApplicationContextErrorModule() {
    super();
  }

  public String getVersion() {
    return (String) super.getContext()
                         .get(NaluLoginApplicationContextErrorModule.VERSION);
  }

  public String getSearchCity() {
    return (String) super.getContext()
                         .get(NaluLoginApplicationContextErrorModule.SEARCH_CITY);
  }

  public void setSearchCity(String searchCity) {
    super.getContext()
         .put(NaluLoginApplicationContextErrorModule.SEARCH_CITY,
              searchCity);
  }

  public String getSearchName() {
    return (String) super.getContext()
                         .get(NaluLoginApplicationContextErrorModule.SEARCH_NAME);
  }

  public void setSearchName(String searchName) {
    super.getContext()
         .put(NaluLoginApplicationContextErrorModule.SEARCH_NAME,
              searchName);
  }

  public String getUser() {
    return (String) super.getContext()
                         .get(NaluLoginApplicationContextErrorModule.USER);
  }

  public void setUser(String user) {
    super.getContext()
         .put(NaluLoginApplicationContextErrorModule.USER,
              user);
  }

  public boolean isLoggedIn() {
    return (boolean) super.getContext()
                          .get(NaluLoginApplicationContextErrorModule.LOGGED_IN);
  }

  public void setLoggedIn(boolean loggedIn) {
    super.getContext()
         .put(NaluLoginApplicationContextErrorModule.LOGGED_IN,
              loggedIn);
  }

}
