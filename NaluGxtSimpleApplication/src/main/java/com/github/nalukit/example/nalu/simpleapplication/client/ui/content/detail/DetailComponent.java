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

package com.github.nalukit.example.nalu.simpleapplication.client.ui.content.detail;

import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.Mail;
import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.SimpleBeanEditorDriver;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.core.client.dom.ScrollSupport;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.form.FieldLabel;
import com.sencha.gxt.widget.core.client.form.TextField;

public class DetailComponent
    extends AbstractComponent<IDetailComponent.Controller, Widget>
    implements IDetailComponent,
               Editor<Mail> {

  /* fields */
  @Path("sender")
  TextField sender;

  @Path("email")
  TextField emailSender;

  private HTML body;

  private Driver driver;

  public DetailComponent() {
  }

  @Override
  public void render() {
    ContentPanel container = new ContentPanel();
    container.setHeaderVisible(false);
    container.setBodyStyle("padding: 12px;");

    VerticalLayoutContainer vlc = new VerticalLayoutContainer();
    container.setWidget(vlc);

    FieldLabel fl01 = new FieldLabel();
    fl01.setText("Sender");
    sender = new TextField();
    sender.setReadOnly(true);
    fl01.setWidget(sender);
    vlc.add(fl01,
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));

    FieldLabel fl02 = new FieldLabel();
    fl02.setText("Email sender");
    emailSender = new TextField();
    emailSender.setReadOnly(true);
    fl02.setWidget(emailSender);
    vlc.add(fl02,
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           -1));

    FieldLabel fl03 = new FieldLabel();
    fl03.setText("Text");
    VerticalLayoutContainer vlc01 = new VerticalLayoutContainer();
    vlc01.setScrollMode(ScrollSupport.ScrollMode.AUTOY);
    vlc01.setBorders(true);
    this.body = new HTML();
    vlc01.add(body,
              new VerticalLayoutContainer.VerticalLayoutData(1,
                                                             1));
    fl03.setWidget(vlc01);
    vlc.add(fl03,
            new VerticalLayoutContainer.VerticalLayoutData(1,
                                                           1));

    initElement(container);
  }

  @Override
  public void bind() {
    // this is got place to create the editor driver ...
    driver = GWT.create(Driver.class);
    driver.initialize(this);
  }

  @Override
  public void edit(Mail mail) {
    driver.edit(mail);
    this.body.setHTML(mail.getBody());
  }

  interface Driver
      extends SimpleBeanEditorDriver<Mail, DetailComponent> {
  }
}
