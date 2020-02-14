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
package com.github.nalukit.example.nalu.loginapplication.module.login.client;

import com.github.nalukit.nalu.client.context.AbstractModuleContext;
import com.github.nalukit.nalu.client.context.module.IsModuleContext;

import elemental2.dom.DomGlobal;

/**
 * A application context of the NaluMailApplication
 */
public class NaluLoginApplicationContextLoginModule
    extends AbstractModuleContext
    implements IsModuleContext {

  public static interface Keys {
    public static final String LOGGED_IN   = "loggedIn";
    public static final String USER        = "user";
  }
  
  public NaluLoginApplicationContextLoginModule() {
    super();
  }

  public void setUser(String user) {
      DomGlobal.window.console.log("setUser " + user);

    super.getContext()
         .put(Keys.USER,
              user);
  }

  public boolean isLoggedIn() {
    DomGlobal.window.console.log("isLoggedIn");

    return (boolean) super.getContext()
                          .get(Keys.LOGGED_IN);
  }

  public void setLoggedIn(boolean loggedIn) {
    DomGlobal.window.console.log("setLoggedIn " + loggedIn);

    super.getContext()
         .put(Keys.LOGGED_IN,
              loggedIn);
  }

}
