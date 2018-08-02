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

import de.gishmo.gwt.example.nalu.simpleapplication.client.Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.IsShell;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import elemental2.dom.Element;

import static elemental2.dom.DomGlobal.document;

/**
 * this is the presenter of the shell. The shell divides the browser in
 * severeal areas.
 */
@Presenter(viewClass = ShellView.class, viewInterface = IShellView.class)
public class ShellPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus,
                             IShellView>
  implements IShellView.Presenter,
             IsShell<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus,
                      IShellView> {

  public ShellPresenter() {
  }

  /**
   * will be called before every event this presenter handles.
   *
   * @param eventName name of the event
   */
  public void onBeforeEvent(String eventName) {
  }
//
//  /**
//   * Set the element in the content area.
//   *
//   * @param element The element to be set in the content area
//   */
//  @EventHandler
//  public void onSetContent(Element element) {
//    view.setCenter(element);
//  }
//
//  /**
//   * Set the element in the navigation area.
//   *
//   * @param element The element to be set in the navigation area
//   */
//  @EventHandler
//  public void onSetNavigation(Element element) {
//    view.setNavigation(element);
//  }
//
//  /**
//   * The ShellPresenter has to implemented this method, because the framework
//   * can not do this. (It does not know, what to use).
//   *
//   * We append the ShellView to the browser body.
//   */
//  @Override
//  public void setShell() {
//    document.body.appendChild(view.asElement());
//  }
//
//  /**
//   * Set the status to the footer and displays it!
//   *
//   * @param status The new message to display.
//   */
//  @EventHandler
//  public void onSetStatus(String status) {
//    view.setStatus(status);
//  }
}
