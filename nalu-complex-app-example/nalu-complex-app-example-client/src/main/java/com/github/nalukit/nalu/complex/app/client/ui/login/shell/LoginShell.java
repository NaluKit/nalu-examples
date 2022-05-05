package com.github.nalukit.nalu.complex.app.client.ui.login.shell;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import com.github.nalukit.nalu.complex.app.common.ui.Routes;
import com.github.nalukit.nalu.complex.app.common.ui.Slots;
import org.dominokit.domino.ui.grid.Column;
import org.dominokit.domino.ui.grid.Row;
import org.dominokit.domino.ui.layout.Layout;
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
@Shell(Routes.SHELL_LOGIN)
public class LoginShell
    extends AbstractShell<AppContext> {

  private Layout layout;

  public LoginShell() {
    super();
  }

  @Override
  public void attachShell() {
    this.layout = Layout.create("Nalu - Example - Login")
                        .show(ColorScheme.BLUE);

    this.layout.disableLeftPanel();

    this.layout.hideFooter()
               .hideNavBarExpand()
               .style()
               .setMinHeight("42px");

    this.layout.getNavigationBar()
               .remove();

    this.layout.getContentPanel()
               .appendChild(Row.create()
                               .appendChild(Column.span12()
                                                  .setId(Slots.SELECTOR_CONTENT)));
  }

  @Override
  public void detachShell() {
    this.layout.remove();
  }

}
