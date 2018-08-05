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

package de.gishmo.gwt.example.nalu.simpleapplication.client.history;

import com.github.mvp4g.mvp4g2.core.history.IsHistoryConverter;
import com.github.mvp4g.mvp4g2.core.history.annotation.History;
import de.gishmo.gwt.example.nalu.simpleapplication.client.Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.PersonSearch;

/**
 * The DetailHistoryConverter of the application.
 *
 * We use different HistroyConverter to check wheather the framework can
 * handle different converers or not!
 */
@History(type = History.HistoryConverterType.DEFAULT)
public class DetailHistoryConverter
  implements IsHistoryConverter<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus> {

  private final static String DELIMITER = "+!!+";

  public DetailHistoryConverter() {
  }

  @Override
  public void convertFromToken(String historyName,
                               String param,
                               Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus eventBus) {
    ClientContext.get()
                 .setPersonSearch(new PersonSearch("",
                                                   ""));
    try {
      long id = Long.parseLong(param);
      eventBus.gotoDetail(id);
    } catch (NumberFormatException e) {
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

  @Override
  public boolean isCrawlable() {
    // we don't want to be crawled
    return false;
  }

  public String onGotoDetail(long id) {
    return Long.toString(id);
  }
}
