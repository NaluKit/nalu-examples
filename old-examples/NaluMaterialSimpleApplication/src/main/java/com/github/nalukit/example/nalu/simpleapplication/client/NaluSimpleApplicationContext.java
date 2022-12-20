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

package com.github.nalukit.example.nalu.simpleapplication.client;

import com.github.nalukit.example.nalu.simpleapplication.client.data.service.FakedService;
import com.github.nalukit.nalu.client.context.IsContext;

/**
 * A application context of the NaluMailApplication
 */
public class NaluSimpleApplicationContext
    implements IsContext {

  private String version;

  private FakedService fakedService;

  public NaluSimpleApplicationContext() {
    this.version = "2.0.0";
    this.fakedService = new FakedService();
  }

  public String getVersion() {
    return version;
  }

  public FakedService getFakedService() {
    return fakedService;
  }

}
