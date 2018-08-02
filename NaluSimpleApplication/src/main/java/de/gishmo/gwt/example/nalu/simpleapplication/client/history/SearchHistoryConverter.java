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

import de.gishmo.gwt.example.nalu.simpleapplication.client.Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus;
import com.github.mvp4g.mvp4g2.core.history.IsHistoryConverter;
import com.github.mvp4g.mvp4g2.core.history.annotation.History;

/**
 * The SearchHistoryConverter of the application.
 *
 * We use different HistroyConverter to check wheather the framework can
 * handle different converers or not!
 */@History(type = History.HistoryConverterType.DEFAULT)
public class SearchHistoryConverter
  implements IsHistoryConverter<Mvp4g2SimpleApplicationUsingElementoAndEventHandlerAnnotationEventBus> {

  private final static String DELIMITER = "+!!+";

  public SearchHistoryConverter() {
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
    eventBus.gotoSearch(convertParameter(searchName),
                        convertParameter(searchCity));
  }

  @Override
  public boolean isCrawlable() {
    // we don't want to be crawled
    return false;
  }

  public String onGotoSearch(String searchName,
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
