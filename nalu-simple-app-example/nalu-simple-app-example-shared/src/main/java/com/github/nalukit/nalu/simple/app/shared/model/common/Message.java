package com.github.nalukit.nalu.simple.app.shared.model.common;

public class Message {

  /* a generated unique id */
  private String id;
  private String messageId;
  /* text of the message */
  private String text;

  public Message() {
  }

  public Message(String id,
                 String messageId,
                 String text) {
    this.id        = id;
    this.messageId = messageId;
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

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

}
