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

package com.github.nalukit.example.nalu.simpleapplication.client.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

public class ApplicationStyleFactory {

  private static ApplicationStyleFactory factory;

  private        ApplicationCss          style;

  private ApplicationStyleFactory() {
    /* create Resources */
    Resources resources = GWT.create(Resources.class);
    this.style = resources.style();
    this.style.ensureInjected();
  }

  public static ApplicationStyleFactory get() {
    if (factory == null) {
      factory = new ApplicationStyleFactory();
    }
    return factory;
  }

  public ApplicationCss getStyle() {
    return style;
  }

  public interface Resources
      extends ClientBundle {

    @Source("ApplicationCss.css")
    ApplicationCss style();

  }
}
