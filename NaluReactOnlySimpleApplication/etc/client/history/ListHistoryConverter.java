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
import de.gishmo.gwt.example.nalu.simpleapplication.client.model.ClientContext;

/**
 * The ListHistoryConverter of the application.
 * <p>
 * We use different HistroyConverter to check wheather the framework can
 * handle different converers or not!
 */
@History(type = History.HistoryConverterType.DEFAULT)
public class ListHistoryConverter
  implements IsHistoryConverter<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus> {

  private final static String DELIMITER = "+!!+";

  public ListHistoryConverter() {
  }

  @Override
  public void convertFromToken(String historyName,
                               String param,
                               Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus eventBus) {
    String searchName = "";
    String searchCity = "";
    if (param.length() > 0) {
      searchName = param.substring(0,
                                   param.indexOf(DELIMITER));
      if (param.length() > param.indexOf(DELIMITER) + DELIMITER.length()) {
        searchCity = param.substring(param.indexOf(DELIMITER) + DELIMITER.length());
      }
    }
    ClientContext.get()
                 .setPersonSearch(new PersonSearch(convertParameter(searchName),
                                                   convertParameter(searchCity)));
    if (searchName.length() > 0 || searchCity.length() > 0) {
      if ("undefined".equals(searchName) || "undefined".equals(searchCity)) {
        eventBus.gotoSearch("",
                            "");
      } else {
        eventBus.gotoList(searchName,
                          searchCity);
      }
    } else {
      eventBus.gotoSearch("",
                          "");
    }
  }

  @Override
  public boolean isCrawlable() {
    // we don't want to be crawled
    return false;
  }

  public String onGotoList(String searchName,
                           String searchCity) {
    return convertParameter(searchName) + DELIMITER + convertParameter(searchCity);
  }

  private String convertParameter(String param) {
    if (param == null) {
      return "";
    }
    if ("undefined".equals(param)) {
      return "";
    }
    return param;
  }
}
