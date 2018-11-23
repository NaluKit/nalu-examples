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
package com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto;

import com.google.gwt.user.client.rpc.IsSerializable;

import java.util.Objects;

/**
 * A simple structure containing the basic components of an email.
 */
public final class Mail
    implements IsSerializable {

  /* uniques id */
  private String id;

  /* The sender's name */
  private String sender;

  /* The sender's email */
  private String email;

  /* The email subject line */
  private String subject;

  /* The email's HTML body */
  private String body;

  /* Read flag */
  private boolean read;

  public Mail() {
  }

  public Mail(String id,
              String sender,
              String email,
              String subject,
              String body) {
    this.id = id;
    this.sender = sender;
    this.email = email;
    this.subject = subject;
    this.body = body;
    this.read = false;
  }

  public boolean isRead() {
    return read;
  }

  public void setRead(boolean read) {
    this.read = read;
  }

  @Override
  public int hashCode() {

    return Objects.hash(getId(),
                        getSender(),
                        getEmail(),
                        getSubject(),
                        getBody());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof Mail)) {
      return false;
    }
    Mail mail = (Mail) o;
    return Objects.equals(getId(),
                          mail.getId()) &&
           Objects.equals(getSender(),
                          mail.getSender()) &&
           Objects.equals(getEmail(),
                          mail.getEmail()) &&
           Objects.equals(getSubject(),
                          mail.getSubject()) &&
           Objects.equals(getBody(),
                          mail.getBody());
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getSender() {
    return sender;
  }

  public void setSender(String sender) {
    this.sender = sender;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String body) {
    this.body = body;
  }
}
