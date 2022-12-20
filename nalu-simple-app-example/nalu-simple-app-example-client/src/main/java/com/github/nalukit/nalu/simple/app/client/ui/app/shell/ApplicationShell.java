package com.github.nalukit.nalu.simple.app.client.ui.app.shell;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Composite;
import com.github.nalukit.nalu.client.component.annotation.Composites;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.nalukit.nalu.simple.app.client.AppContext;
import com.github.nalukit.nalu.simple.app.client.ui.Routes;
import com.github.nalukit.nalu.simple.app.client.ui.Slots;
import com.github.nalukit.nalu.simple.app.client.ui.app.shell.composite.ShellComposite;
import elemental2.dom.DomGlobal;
import org.dominokit.domino.ui.grid.flex.FlexDirection;
import org.dominokit.domino.ui.grid.flex.FlexItem;
import org.dominokit.domino.ui.grid.flex.FlexLayout;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.style.ColorScheme;
import org.dominokit.domino.ui.utils.DominoElement;

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
@Shell(Routes.SHELL_APP)
@Composites(@Composite(name = "shellComposite",
                       compositeController = ShellComposite.class,
                       selector = Slots.SELECTOR_SHELL_COMPOSITE))
public class ApplicationShell
    extends AbstractShell<AppContext> {

  private Layout layout;

  public ApplicationShell() {
  }

  /**
   * The ShellPresenter has to implemented this method, because the framework
   * can not do this. (It does not know, what to use).
   * <p>
   * We append the ShellView to the browser body.
   */
  @Override
  public void attachShell() {
    this.layout = Layout.create("Nalu - Complex Nalue Example")
                        .show(ColorScheme.INDIGO);

    this.layout.hideFooter()
               .getLeftPanel()
               .setId(Slots.SELECTOR_NAVIGATION);
    this.layout.getContentPanel()
               .appendChild(FlexLayout.create()
                                      .setDirection(FlexDirection.TOP_TO_BOTTOM)
                                      .appendChild(FlexItem.create()
                                                           .setOrder(1)
                                                           .appendChild(DominoElement.div()
                                                                                     .setId(Slots.SELECTOR_SHELL_COMPOSITE)))
                                      .appendChild(FlexItem.create()
                                                           .setOrder(2)
                                                           .setFlexGrow(1)
                                                           .appendChild(DominoElement.div()
                                                                                     .setId(Slots.SELECTOR_CONTENT_APPLICATION))));

    MediaQuery.addOnMediumAndDownListener(layout::unfixLeftPanelPosition);
    MediaQuery.addOnLargeAndUpListener(layout::fixLeftPanelPosition);
  }

  @Override
  public void onAttachedComponent() {
    DomGlobal.window.console.log("AppShell: 'onAttachedComponent' called");
  }

  @Override
  public void detachShell() {
    this.layout.remove();
  }

}
