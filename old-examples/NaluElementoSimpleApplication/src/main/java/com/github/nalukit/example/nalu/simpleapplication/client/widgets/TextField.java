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

package com.github.nalukit.example.nalu.simpleapplication.client.widgets;

import elemental2.dom.HTMLDivElement;
import elemental2.dom.HTMLElement;
import elemental2.dom.HTMLInputElement;
import org.jboss.elemento.InputType;
import org.jboss.elemento.IsElement;

import static import org.jboss.elemento.Elements;.div;
import static import org.jboss.elemento.Elements;.input;
import static org.jboss.gwt.elemento.core.EventType.blur;
import static org.jboss.gwt.elemento.core.EventType.focus;

/**
 * The TextField class is the text widget used by the application.
 */
public class TextField
    implements IsElement<HTMLElement> {

  private HTMLElement container;

  private HTMLDivElement label;

  private HTMLInputElement textBox;

  public TextField() {
    this(null);
  }

  public TextField(String label) {
    createWidget();

    setLabel(label);
  }

  private void createWidget() {
    container = div().css("textFieldWidgetContainer",
                          "textFieldTwoRow")
                     .add(label = div().css("textFieldLabel",
                                            "visible")
                                       .element())
                     .add(div().css("textFieldDivElement")
                               .add(textBox = input(InputType.text).css("textFieldTextBox")
                                                                   .on(focus,
                                                                       event -> textBox.classList.add("yellow"))
                                                                   .on(blur,
                                                                       event -> textBox.classList.remove("yellow"))
                                                                   .element()))
                     .element();
  }

  public String getLabel() {
    return label.innerHTML;
  }

  public void setLabel(String label) {
    if (label != null && label.length() > 0) {
      this.label.innerHTML = label;
      this.label.classList.add("visible");
      this.label.classList.remove("hidden");
      this.container.classList.remove("textFieldOneRow");
      this.container.classList.add("textFieldTwoRow");
    } else {
      this.label.innerHTML = "";
      this.label.classList.add("hidden");
      this.label.classList.remove("visible");
      this.container.classList.remove("textFieldTwoRow");
      this.container.classList.add("textFieldOneRow");
    }
  }

  public String getText() {
    return textBox.value;
  }

  public void setText(String text) {
    this.textBox.value = text;
  }

  @Override
  public HTMLElement element() {
    return this.container;
  }

}
