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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.application.content.detail.composite.conditional;

import com.github.nalukit.example.nalu.simpleapplication.client.ui.application.content.detail.composite.conditional.IConditionComponent.Controller;
import com.github.nalukit.nalu.client.component.AbstractCompositeComponent;
import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.Text;
import org.dominokit.domino.ui.cards.Card;
import org.dominokit.domino.ui.style.Color;
import org.jboss.elemento.Elements;

public class ConditionComponent
    extends AbstractCompositeComponent<Controller, HTMLElement>
    implements IConditionComponent {

  public ConditionComponent() {
  }

  @Override
  public void render() {
    HTMLDivElement divElemet = Elements.div()
                                       .element();

    divElemet.appendChild(Card.create()
                              .setBackground(Color.AMBER)
                              .appendChild(new Text("This composite is conditional. In case you see this composite, you have selected 'Homer Simpson'!"))
                              .element());

    initElement(divElemet);
  }

}
