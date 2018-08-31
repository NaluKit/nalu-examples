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
import com.github.mvp4g.nalu.plugin.gwt.client.annotation.Selector;
import com.github.mvp4g.nalu.plugin.gwt.client.selector.IsSelectorProvider;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.BorderLayoutContainer;
import com.sencha.gxt.widget.core.client.container.SimpleContainer;
import com.sencha.gxt.widget.core.client.container.Viewport;
import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
public class Shell
    extends AbstractShell<NaluSimpleApplicationContext> {

  private Viewport              viewport;
  private BorderLayoutContainer shell;
  @Selector("north")
  protected ContentPanel          northContainer;
  @Selector("south")
  protected ContentPanel          southContainer;
  @Selector("content")
  protected SimpleContainer       centerContainer;

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
    Viewport viewport = new Viewport();

    this.shell = new BorderLayoutContainer();
    viewport.add(this.shell);

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

    return viewport;
  }

  private ContentPanel createContentPanel() {
    ContentPanel cp = new ContentPanel();
    cp.setHeaderVisible(false);
    return cp;
  }

  @Override
  public void bind() {
    // create the sleecgtor provider so set Nalu works!
    IsSelectorProvider<Shell> provider = new ShellSelectorProviderImpl();
    provider.initialize(this);
  }
}
