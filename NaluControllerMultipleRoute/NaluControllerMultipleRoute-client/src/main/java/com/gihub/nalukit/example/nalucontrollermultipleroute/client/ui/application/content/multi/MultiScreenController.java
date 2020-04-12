package com.gihub.nalukit.example.nalucontrollermultipleroute.client.ui.application.content.multi;

import com.gihub.nalukit.example.nalucontrollermultipleroute.client.NaluControllerMultipleRouteContext;
import com.gihub.nalukit.example.nalucontrollermultipleroute.client.event.StatusChangeEvent;
import com.gihub.nalukit.example.nalucontrollermultipleroute.shared.model.MyModel;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import elemental2.dom.HTMLElement;

/**
 * Copyright (C) 2018 - 2019 Frank Hossfeld <frank.hossfeld@googlemail.com>
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
@Controller(
    route = { "/application/screen02", "/application/screen03", "/application/screen04", "/application/screen05" },
    selector = "content",
    componentInterface = IMultiScreenComponent.class,
    component = MultiScreenComponent.class
)
public class MultiScreenController
    extends AbstractComponentController<NaluControllerMultipleRouteContext, IMultiScreenComponent, HTMLElement>
    implements IMultiScreenComponent.Controller {
  
  private MyModel model;
  
  public MultiScreenController() {
  }
  
  @Override
  public void start() {
    // Here we simulate the creation of a model.
    // In the real world we would do a server call or
    // something else to get the data.
    model = new MyModel(super.getRelatedRoute(), "This value is set using the edit method! The value is >>" + this.routeScreenMapper() + "<<");
    // now, move the data out of the model into the widgets - that's what we do next
    component.edit(model);
    // update the statusbar at the bottom of the screen
    eventBus.fireEvent(new StatusChangeEvent("active screen: >>" + this.routeScreenMapper() + "<<"));
  }
  
  private String routeScreenMapper() {
    switch (super.getRelatedRoute()) {
      case "/application/screen02":
        return "screen02";
      case "/application/screen03":
        return "screen03";
      case "/application/screen04":
        return "screen04";
      case "/application/screen05":
        return "screen05";
    }
    return "n/a";
  }
  
}
