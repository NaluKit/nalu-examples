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

package de.gishmo.gwt.example.nalu.simpleapplication.client.resources;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.i18n.client.Constants;

public interface ApplicationConstants
  extends Constants {

  ApplicationConstants CONSTANTS = GWT.create(ApplicationConstants.class);
  
  String footerText();
  
  String searchFormButton();
  
  String listFormButton();

  String searchButton();

  String searchHeadline();
  
  String searchName();

  String searchCity();

  String resetButton();
  
  String resultHeadline();
  
  String resultText();
  
  String columnName();
  
  String columnStreet();
  
  String columnPlz();
  
  String columnCity();

  String detailHeadline();
  
  String detailFirstName();
  
  String detailName();
  
  String detailStreet();
  
  String detailZip();
  
  String detailCity();

  String saveButton();
  
  String revertButton();
  
  String statusSearch();
  
  String statusListZero();
  
  String statusListOne();
    
  String statusDetail();

  String detailMessage();
  
}
