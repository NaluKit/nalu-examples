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

package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.list;

import de.gishmo.gwt.example.nalu.simpleapplication.client.Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.Person;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.PersonSearch;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.service.PersonService;
import com.github.mvp4g.mvp4g2.core.ui.AbstractPresenter;
import com.github.mvp4g.mvp4g2.core.ui.IsViewCreator;
import com.github.mvp4g.mvp4g2.core.ui.annotation.EventHandler;
import com.github.mvp4g.mvp4g2.core.ui.annotation.Presenter;

import java.util.List;

@Presenter(viewClass = ListView.class, viewInterface = IListView.class, viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER)
public class ListPresenter
  extends AbstractPresenter<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus, IListView>
  implements IListView.Presenter,
             IsViewCreator<IListView> {

  public ListPresenter() {
    super();
  }

  @Override
  public void doUpdate(Person object) {
    eventBus.gotoDetail(object.getId());
  }

  @EventHandler
  public void onGotoList(String searchName,
                         String searchCity) {
    List<Person> result = PersonService.get()
                                       .get(new PersonSearch(searchName,
                                                             searchCity));
    view.resetTable();
    view.setData(result);
    eventBus.setContent(view.asElement());
    if (result.size() == 0) {
      eventBus.setStatus("No person found");
    } else if (result.size() == 1) {
      eventBus.setStatus("Found one person");
    } else {
      eventBus.setStatus("Found " + Integer.toString(result.size()) + " persons");
    }
  }

  /**
   * Because we have told mvp4g2, that this presenter will create it's view
   * (viewCreator = Presenter.VIEW_CREATION_METHOD.PRESENTER), we have to
   * implement this method.
   *
   * @return a new instance of the view.
   */
  @Override
  public IListView createView() {
    return new ListView();
  }
}
