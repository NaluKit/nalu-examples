package de.gishmo.example.devk.shared.model;

import java.lang.String;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class MyModel {
  private String uuid;

  private String activeScreen;

  public MyModel() {
    uuid = GUID.get();
  }

  public MyModel(String activeScreen) {
    uuid = GUID.get();
    this.activeScreen = activeScreen;
  }

  public String getUuid() {
    return this.uuid;
  }

  public String getActiveScreen() {
    return this.activeScreen;
  }

  public void setActiveScreen(String activeScreen) {
    this.activeScreen = activeScreen;
  }
}
