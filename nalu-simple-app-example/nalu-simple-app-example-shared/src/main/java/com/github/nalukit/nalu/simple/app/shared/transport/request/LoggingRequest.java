package com.github.nalukit.nalu.simple.app.shared.transport.request;

import org.dominokit.jackson.annotation.JSONMapper;
import org.dominokit.rest.shared.request.RequestBean;

import java.util.List;

@JSONMapper
public class LoggingRequest
    extends AbstractRequest
    implements RequestBean {

  private List<String> messages;

  public LoggingRequest() {
  }

  public LoggingRequest(List<String> messages) {
    this.messages = messages;
  }

  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

}
