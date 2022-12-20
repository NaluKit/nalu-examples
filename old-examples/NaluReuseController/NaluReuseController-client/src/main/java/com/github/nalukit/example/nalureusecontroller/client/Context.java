package com.github.nalukit.example.nalureusecontroller.client;

import com.github.nalukit.nalu.client.context.IsContext;
import com.github.nalukit.nalu.client.event.model.ErrorInfo;

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
public class Context
    implements IsContext {
  
  private String version;
  
  private String searchName;
  
  private String searchCity;
  
  private ErrorInfo errorInfo;
  
  public Context() {
    this.version = "2.0.0";
  }
  
  public String getVersion() {
    return version;
  }
  
  public String getSearchCity() {
    return searchCity;
  }
  
  public void setSearchCity(String searchCity) {
    this.searchCity = searchCity;
  }
  
  public String getSearchName() {
    return searchName;
  }
  
  public void setSearchName(String searchName) {
    this.searchName = searchName;
  }
  
  public ErrorInfo getErrorInfo() {
    return errorInfo;
  }
  
  public void setErrorInfo(ErrorInfo errorInfo) {
    this.errorInfo = errorInfo;
  }
  
}
