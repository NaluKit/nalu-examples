/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
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

package com.github.nalukit.example.nalu.simpleapplication.client;

import com.github.nalukit.nalu.client.context.AbstractMainContext;
import com.github.nalukit.nalu.client.event.model.ErrorInfo.ErrorType;

import java.util.Objects;

/**
 * A application context of the NaluMailApplication
 */
public class NaluSimpleApplicationContext
    extends AbstractMainContext {

  private static final String VERSION     = "version";
  private static final String SEARCH_CITY = "searchCity";
  private static final String SEARCH_NAME = "searchName";

  private static final String ERROR_TYPE    = "errorType";
  private static final String ERROR_ROUTE   = "errorRoute";
  private static final String ERROR_MESSAGE = "errorMessage";

  public NaluSimpleApplicationContext() {
    super.getContext()
         .put(NaluSimpleApplicationContext.VERSION,
              "2.0.0");
  }

  public String getVersion() {
    return (String) super.getContext()
                         .get(NaluSimpleApplicationContext.VERSION);
  }

  public String getSearchCity() {
    return (String) super.getContext()
                         .get(NaluSimpleApplicationContext.SEARCH_CITY);
  }

  public void setSearchCity(String searchCity) {
    super.getContext()
         .put(NaluSimpleApplicationContext.SEARCH_CITY,
              searchCity);
  }

  public String getSearchName() {
    return (String) super.getContext()
                         .get(NaluSimpleApplicationContext.SEARCH_NAME);
  }

  public void setSearchName(String searchName) {
    super.getContext()
         .put(NaluSimpleApplicationContext.SEARCH_NAME,
              searchName);
  }

  public ErrorType getErrorType() {
    if (Objects.isNull(super.getContext()
                            .get(NaluSimpleApplicationContext.ERROR_TYPE))) {
      return null;
    }
    return ErrorType.valueOf((String) super.getContext()
                                           .get(NaluSimpleApplicationContext.ERROR_TYPE));
  }

  public void setErrorType(ErrorType errorType) {
    if (Objects.isNull(errorType)) {
      super.getContext()
           .put(NaluSimpleApplicationContext.ERROR_TYPE,
                null);
    } else {
      super.getContext()
           .put(NaluSimpleApplicationContext.ERROR_TYPE,
                errorType.toString());
    }
  }

  public String getErrorRoute() {
    return (String) super.getContext()
                         .get(NaluSimpleApplicationContext.ERROR_ROUTE);
  }

  public void setErrorRoute(String errorRoute) {
    super.getContext()
         .put(NaluSimpleApplicationContext.ERROR_ROUTE,
              errorRoute);
  }

  public String getErrorMessage() {
    return (String) super.getContext()
                         .get(NaluSimpleApplicationContext.ERROR_MESSAGE);
  }

  public void setErrorMessage(String errorMessage) {
    super.getContext()
         .put(NaluSimpleApplicationContext.ERROR_MESSAGE,
              errorMessage);
  }

}
