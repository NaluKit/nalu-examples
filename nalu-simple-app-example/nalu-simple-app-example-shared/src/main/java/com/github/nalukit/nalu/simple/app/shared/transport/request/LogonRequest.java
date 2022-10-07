package com.github.nalukit.nalu.simple.app.shared.transport.request;

import org.dominokit.jackson.annotation.JSONMapper;
import org.dominokit.rest.shared.request.RequestBean;

@JSONMapper
public class LogonRequest
    extends AbstractRequest
    implements RequestBean {

  private String userId;
  private String password;

  public LogonRequest() {
  }

  public LogonRequest(String userId,
                      String password) {
    this.userId   = userId;
    this.password = password;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
