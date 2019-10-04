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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.shell;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.nalukit.nalu.plugin.gwt.client.annotation.Selector;
import com.github.nalukit.nalu.plugin.gwt.client.selector.IsSelectorProvider;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@Shell("application")
public class ApplicationShell
    extends AbstractShell<NaluSimpleApplicationContext> {

  protected ContentPanel northContainer;

  protected ContentPanel southContainer;

  protected SimpleContainer centerContainer;

  private Viewport viewport;

  private BorderLayoutContainer shell;

  public ApplicationShell() {
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

  /**
   * The ShellPresenter has to implemented this method, because the framework
   * can not do this. (It does not know, what to use).
   * <p>
   * We remove the ShellView from the browser body.
   */
  @Override
  public void detachShell() {
    this.viewport.removeFromParent();
  }

  private Widget render() {
    this.viewport = new Viewport();

    this.shell = new BorderLayoutContainer();
    this.viewport.add(this.shell);

    this.northContainer = createContentPanel();
    BorderLayoutContainer.BorderLayoutData bldNorth = new BorderLayoutContainer.BorderLayoutData(.4);
    bldNorth.setCollapsible(true);
    bldNorth.setSplit(true);
    this.shell.setNorthWidget(this.northContainer,
                              bldNorth);

    this.southContainer = createContentPanel();
    BorderLayoutContainer.BorderLayoutData bldSouth = new BorderLayoutContainer.BorderLayoutData(36);
    this.shell.setSouthWidget(this.southContainer,
                              bldSouth);

    this.centerContainer = new SimpleContainer();
    this.shell.setCenterWidget(this.centerContainer);

    return this.viewport;
  }

  private ContentPanel createContentPanel() {
    ContentPanel cp = new ContentPanel();
    cp.setHeaderVisible(false);
    return cp;
  }

  @Override
  public void bind(ShellLoader loader) {
    // create the selector provider so set Nalu works!
    IsSelectorProvider<ApplicationShell> provider = new ApplicationShellSelectorProviderImpl();
    provider.initialize(this);
    loader.continueLoading();
  }

  @Override
  public void onAttachedComponent() {
    this.shell.forceLayout();
  }

  @Selector("north")
  public void setNorthContainer(IsWidget widget) {
    this.northContainer.add(widget);
  }

  @Selector("south")
  public void setSouthContainer(IsWidget widget) {
    this.southContainer.add(widget);
  }

  @Selector("content")
  public void setContent(IsWidget widget) {
    this.centerContainer.add(widget);
  }

}
