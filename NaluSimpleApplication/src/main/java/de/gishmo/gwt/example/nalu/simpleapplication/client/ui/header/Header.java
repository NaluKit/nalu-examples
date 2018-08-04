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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.header;

import com.github.mvp4g.nalu.client.ui.AbstractComponent;
import com.github.mvp4g.nalu.client.ui.annotations.Route;
import de.gishmo.gwt.example.nalu.simpleapplication.client.ui.Selectors;
import elemental2.dom.HTMLElement;

import static org.jboss.gwt.elemento.core.Elements.header;
import static org.jboss.gwt.elemento.core.Elements.img;

@Route(route = "/", selector = Selectors.HEADER)
public class Header
  extends AbstractComponent {

  public Header() {
  }

  @Override
  public HTMLElement render() {
    return header().css("shellHeader")
                   .add(img("media/images/Gwt-logo.png").css("shellHeaderImage"))
                   .asElement();
  }

  @Override
  public void start() {

  }
}
