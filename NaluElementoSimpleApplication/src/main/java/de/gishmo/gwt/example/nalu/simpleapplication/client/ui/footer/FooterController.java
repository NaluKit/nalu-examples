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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.footer;

import com.github.mvp4g.nalu.client.component.AbstractComponentController;
import com.github.mvp4g.nalu.client.component.annotation.Controller;
import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import elemental2.dom.HTMLElement;
import org.gwtproject.event.shared.HandlerRegistration;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@Controller(route = "/",
            selector = "footer",
            componentInterface = IFooterComponent.class,
            component = FooterComponent.class)
public class FooterController
    extends AbstractComponentController<NaluSimpleApplicationContext, IFooterComponent, HTMLElement>
    implements IFooterComponent.Controller {

  private HandlerRegistration registration;

  public FooterController() {
  }

  @Override
  public void start() {
    this.registration = this.eventBus.addHandler(StatusChangeEvent.TYPE,
                                                 e -> component.setStatus(e.getStatus()));
  }

  @Override
  public void stop() {
    this.registration.removeHandler();
  }
}
