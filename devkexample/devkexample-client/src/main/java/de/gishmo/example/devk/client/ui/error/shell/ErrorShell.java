package de.gishmo.example.devk.client.ui.error.shell;

import com.github.nalukit.nalu.client.component.AbstractShell;
import com.github.nalukit.nalu.client.component.annotation.Shell;
import de.gishmo.example.devk.client.ApplicationContext;
import elemental2.dom.CSSProperties;
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
@Shell("errorShell")
public class ErrorShell
    extends AbstractShell<ApplicationContext> {

  private Layout layout;

  public ErrorShell() {
    super();
  }

  @Override
  public void attachShell() {
    layout = Layout.create("Nalu - Simple Application using Domino-UI - Error Message")
                   .show(ColorScheme.INDIGO);
    layout.showFooter()
          .fixFooter()
          .getFooter()
          .asElement().style.minHeight = CSSProperties.MinHeightUnionType.of("42px");
    layout.getFooter()
          .setId("footer");
    layout.disableLeftPanel();
    layout.getContentPanel()
          .setId("content");
  }

  @Override
  public void detachShell() {
    this.layout.remove();
  }

}
