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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.error.shell;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.nalukit.nalu.plugin.gwt.client.annotation.Selector;
import com.github.nalukit.nalu.plugin.gwt.client.selector.IsSelectorProvider;
import com.google.gwt.dom.client.Style;
import com.google.gwt.dom.client.Style.TextAlign;
import com.google.gwt.dom.client.Style.Unit;
import com.google.gwt.user.client.ui.*;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@Shell("error")
public class ErrorShell
    extends AbstractShell<NaluSimpleApplicationContext> {

  private SimpleLayoutPanel contentWidget;

  public ErrorShell() {
    super();
  }

  /**
   * The ShellPresenter has to implemented this method, because the framework
   * can not do this. (It does not know, what to use).
   * <p>
   * We append the shell to the browser body.
   */
  @Override
  public void attachShell() {
    RootLayoutPanel.get()
                   .add(this.render());
  }

  private Widget render() {
    ResizeLayoutPanel shell = new ResizeLayoutPanel();
    shell.setSize("100%",
                  "100%");
    //shell.addResizeHandler(event -> forceLayout());

    DockLayoutPanel panel = new DockLayoutPanel(Style.Unit.PX);
    panel.setSize("100%",
                  "100%");
    shell.add(panel);

    this.contentWidget = createContent();
    panel.add(this.contentWidget);

    return panel;
  }

  private SimpleLayoutPanel createContent() {
    SimpleLayoutPanel panel = new SimpleLayoutPanel();
    panel.getElement()
         .setId("content");
    panel.getElement()
         .getStyle()
         .setMarginTop(48,
                       Unit.PX);
    panel.getElement()
         .getStyle()
         .setTextAlign(TextAlign.CENTER);
    return panel;
  }

  @Override
  public void bind(ShellLoader loader) {
    IsSelectorProvider<ErrorShell> provider = new ErrorShellSelectorProviderImpl();
    provider.initialize(this);
    loader.continueLoading();
  }

  @Selector("content")
  public void setContent(Widget widget) {
    this.contentWidget.clear();
    this.contentWidget.add(widget);
  }

}
