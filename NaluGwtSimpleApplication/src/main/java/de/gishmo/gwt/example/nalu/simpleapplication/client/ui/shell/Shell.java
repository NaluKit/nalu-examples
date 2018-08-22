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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.shell;

import com.github.mvp4g.nalu.client.component.AbstractShell;
import com.google.gwt.dom.client.Style;
import com.google.gwt.user.client.ui.*;
import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.resources.ApplicationCss;
import de.gishmo.gwt.example.nalu.simpleapplication.client.resources.ApplicationStyleFactory;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
public class Shell
    extends AbstractShell<NaluSimpleApplicationContext> {

  private ResizeLayoutPanel shell;
  private ApplicationCss style;

  public Shell() {
    super();
  }

  /**
   * The ShellPresenter has to implemented this method, because the framework
   * can not do this. (It does not know, what to use).
   * <p>
   * We append the ShellView to the browser body.
   */
  @Override
  public void attachShell() {
    RootLayoutPanel.get()
                   .add(this.render());
  }

  private Widget render() {
    this.style = ApplicationStyleFactory.get()
                                        .getStyle();

    shell = new ResizeLayoutPanel();
    shell.setSize("100%",
                  "100%");
    //shell.addResizeHandler(event -> forceLayout());

    DockLayoutPanel panel = new DockLayoutPanel(Style.Unit.PX);
    panel.setSize("100%",
                  "100%");
    shell.add(panel);

    Widget header = createNorth();
    panel.addNorth(header,
                   128);

    Widget footer = createSouth();
    panel.addSouth(footer,
                   42);

    Widget navigation = createNavigation();
    panel.addWest(navigation,
                  212);

    Widget content = createContent();
    panel.add(content);

    return panel;
  }

  private Widget createContent() {
    FlowPanel panel = new FlowPanel();
    panel.getElement()
         .setId("content");
    return panel;
  }

  private Widget createNavigation() {
    FlowPanel panel = new FlowPanel();
    panel.addStyleName(style.navigationPanel());
    panel.getElement()
         .setId("navigation");
    return panel;
  }

  private Widget createNorth() {
    SimpleLayoutPanel panel = new SimpleLayoutPanel();
    panel.addStyleName(style.headerPanel());
    panel.getElement()
         .setId("header");
    return panel;
  }

  private Widget createSouth() {
    ResizeLayoutPanel footerPanel = new ResizeLayoutPanel();
    footerPanel.getElement()
               .setId("footer");
    return footerPanel;
  }

//    private void forceLayout() {
//      if (shell.isAttached()) {
//        Widget parent = shell.getParent();
//        if (parent != null) {
//          int parentWidth = parent.getOffsetWidth();
//          footerPanel.setWidth(Integer.toString(parentWidth) + "px");
//        }
//      }
//    }
}
