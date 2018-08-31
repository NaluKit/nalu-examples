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

package de.gishmo.gwt.example.nalu.simpleapplication.client.data.model;

import com.google.gwt.editor.client.Editor;
import com.sencha.gxt.core.client.ValueProvider;
import com.sencha.gxt.data.shared.ModelKeyProvider;
import com.sencha.gxt.data.shared.PropertyAccess;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.Mail;

public interface MailProperties
  extends PropertyAccess<Mail> {

  @Editor.Path("id")
  ModelKeyProvider<Mail> key();

  @Editor.Path("sender")
  ValueProvider<Mail, String> sender();

  @Editor.Path("email")
  ValueProvider<Mail, String> email();

  @Editor.Path("subject")
  ValueProvider<Mail, String> subject();

  @Editor.Path("body")
  ValueProvider<Mail, String> body();

  @Editor.Path("read")
  ValueProvider<Mail, Boolean> read();

}
