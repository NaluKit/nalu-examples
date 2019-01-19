/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package com.github.nalukit.example.nalu.simpleapplication.client.ui.shell.application;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import elemental2.dom.DomGlobal;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.style.ColorScheme;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@Shell("application")
public class ApplicationShell
    extends AbstractShell<NaluSimpleApplicationContext> {

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
    Layout layout = Layout.create("Nalu - Simple Application using Domino-UI")
                          .show(ColorScheme.INDIGO);

    layout.showFooter()
          .fixFooter()
          .getFooter()
          .setId("footer")
          .style()
          .setMinHeight("42px");

    layout.getLeftPanel()
          .setId("navigation");
    layout.getContentPanel()
          .appendChild(Row.create()
                          .appendChild(Column.span12()
                                             .setId("content")));

    MediaQuery.addOnMediumAndDownListener(layout::unfixLeftPanelPosition);
    MediaQuery.addOnLargeAndUpListener(layout::fixLeftPanelPosition);
  }

  @Override
  public void onAttachedComponent() {
    DomGlobal.window.console.log("ApplicationShell: 'onAttachedComponent' called");
  }

}
