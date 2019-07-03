package de.gishmo.example.devk.client.ui.application.shell;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import de.gishmo.example.devk.client.ApplicationContext;
import elemental2.dom.DomGlobal;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.layout.Layout;
import org.dominokit.domino.ui.mediaquery.MediaQuery;
import org.dominokit.domino.ui.style.ColorScheme;

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
@Shell("applicationShell")
public class ApplicationShell
    extends AbstractShell<ApplicationContext> {

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
    this.layout = Layout.create("Nalu - Simple Application using Domino-UI")
                        .show(ColorScheme.INDIGO);

    this.layout.showFooter()
               .fixFooter()
               .getFooter()
               .setId("footer")
               .style()
               .setMinHeight("42px");

    this.layout.getLeftPanel()
               .setId("navigation");
    this.layout.getContentPanel()
               .appendChild(Row.create()
                               .appendChild(Column.span8()
                                                  .offset2()
                                                  .setId("content")));

    MediaQuery.addOnMediumAndDownListener(layout::unfixLeftPanelPosition);
    MediaQuery.addOnLargeAndUpListener(layout::fixLeftPanelPosition);
  }

  @Override
  public void onAttachedComponent() {
    DomGlobal.window.console.log("ApplicationShell: 'onAttachedComponent' called");
  }

  @Override
  public void detachShell() {
    this.layout.remove();
  }

}
