package com.github.nalukit.nalu.simple.app.shared.transport.response;

import com.github.nalukit.nalu.simple.app.shared.model.PersistanceData;
import org.dominokit.jackson.annotation.JSONMapper;

@JSONMapper
public class LogonResponse
    extends AbstractResponse {

  private String          userId;
  private PersistanceData persistanceData;

  public LogonResponse() {
    this(null);
  }

  public LogonResponse(String userId) {
    this.userId = userId;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public PersistanceData getPersistanceData() {
    return persistanceData;
  }

  public void setPersistanceData(PersistanceData persistanceData) {
    this.persistanceData = persistanceData;
  }
}
