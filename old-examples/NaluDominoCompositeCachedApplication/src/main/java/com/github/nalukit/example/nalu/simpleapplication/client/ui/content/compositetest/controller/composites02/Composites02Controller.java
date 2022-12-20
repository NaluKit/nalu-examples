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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.compositetest.controller.composites02;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.compositetest.composite.CompositesCondition;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.compositetest.composite.composite01.Composite01Composite;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.compositetest.composite.composite02.Composite02Composite;
import com.github.nalukit.example.nalu.simpleapplication.client.ui.content.compositetest.composite.composite03.Composite03Composite;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.AcceptParameter;
import com.github.nalukit.nalu.client.component.annotation.Composite;
import com.github.nalukit.nalu.client.component.annotation.Composites;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import elemental2.dom.HTMLElement;

@Controller(route = "/application/test/composite02/conditional/:config",
            selector = "content",
            componentInterface = IComposites02Component.class,
            component = Composites02Component.class)
@Composites({ @Composite(name = "composite01",
                         compositeController = Composite01Composite.class,
                         selector = "composite01"),
              @Composite(name = "composite02",
                         compositeController = Composite02Composite.class,
                         selector = "composite02",
                         condition = CompositesCondition.class),
              @Composite(name = "composite03",
                         compositeController = Composite03Composite.class,
                         selector = "composite03",
                         condition = CompositesCondition.class) })
public class Composites02Controller
    extends AbstractComponentController<NaluSimpleApplicationContext, IComposites02Component, HTMLElement>
    implements IComposites02Component.Controller {

  @SuppressWarnings("unsued")
  private String config;

  public Composites02Controller() {
  }

  @Override
  public void start() {
  }

  @AcceptParameter("config")
  public void setConfig(String config)
      throws RoutingInterceptionException {
    this.config = config;
  }

}
