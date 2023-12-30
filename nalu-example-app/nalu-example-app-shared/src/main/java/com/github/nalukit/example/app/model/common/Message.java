package com.github.nalukit.example.app.model.common;

import java.sql.Timestamp;

public class Message {

  /* a generated unique id */
  private String    id;
  private String    messageId;
  private String uri;
  private String when;
  /* text of the message */
  private String    text;

  public Message() {
  }

  public Message(String id,
                 String messageId,
                 String uri,
                 String when,
                 String text) {
    this.id        = id;
    this.messageId = messageId;
    this.uri       = uri;
    this.when      = when;
    this.text      = text;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getMessageId() {
    return messageId;
  }

  public void setMessageId(String messageId) {
    this.messageId = messageId;
  }

  public String getUri() {
    return uri;
  }

  public void setUri(String uri) {
    this.uri = uri;
  }

  public String getWhen() {
    return when;
  }

  public void setWhen(String when) {
    this.when = when;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }
}
