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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.navigation;

import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;
import de.gishmo.gwt.example.nalu.simpleapplication.client.Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus;
import de.gishmo.gwt.example.nalu.simpleapplication.client.model.ClientContext;
import elemental2.dom.Element;

@Presenter(viewClass = NavigationView.class, viewInterface = INavigationView.class)
public class NavigationPresenter
  extends AbstractSimpleApplicationPresenter<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus, INavigationView>
  implements INavigationView.Presenter {

  public NavigationPresenter() {
  }

  @Override
  public void bind() {
    eventBus.setNavigation(asElement());
  }

  public Element asElement() {
    return view.asElement();
  }

  @Override
  public void doShowList() {
    if (ClientContext.get()
                     .getPersonSearch() != null) {
      eventBus.gotoList(ClientContext.get()
                                     .getPersonSearch()
                                     .getName(),
                        ClientContext.get()
                                     .getPersonSearch()
                                     .getCity());
    } else {
      eventBus.gotoSearch("",
                          "");
    }
  }

  @Override
  public void doShowSearch() {
    if (ClientContext.get()
                     .getPersonSearch() != null) {
      eventBus.gotoSearch(ClientContext.get()
                                     .getPersonSearch()
                                     .getName(),
                        ClientContext.get()
                                     .getPersonSearch()
                                     .getCity());
    } else {
      eventBus.gotoSearch("",
                          "");
    }
  }
}
