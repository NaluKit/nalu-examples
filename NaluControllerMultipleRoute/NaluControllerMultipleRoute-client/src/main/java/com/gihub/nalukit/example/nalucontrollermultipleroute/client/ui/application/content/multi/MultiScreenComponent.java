package com.gihub.nalukit.example.nalucontrollermultipleroute.client.ui.application.content.multi;

import com.gihub.nalukit.example.nalucontrollermultipleroute.shared.model.MyModel;
import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;
import org.dominokit.domino.ui.Typography.Paragraph;
import org.dominokit.domino.ui.cards.Card;

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
public class MultiScreenComponent
    extends AbstractComponent<IMultiScreenComponent.Controller, HTMLElement>
    implements IMultiScreenComponent {
  
  private Card card;
  
  public MultiScreenComponent() {
    super();
  }
  
  @Override
  public void edit(MyModel model) {
    // That's a good place to move your data out of the model into the widgets.
    // 
    // Using GWT 2.x you can use the editor framework and in this case
    // it is a good idea to edit and flush the data inside the presenter.
    card.setTitle(model.getActiveScreen());
    card.getBody().appendChild(Paragraph.create("Route: >>" + model.getActiveRoute() + "<<"));
  }
  
  @Override
  public void render() {
    card = Card.create("");
    initElement(card.element());
  }
  
}
