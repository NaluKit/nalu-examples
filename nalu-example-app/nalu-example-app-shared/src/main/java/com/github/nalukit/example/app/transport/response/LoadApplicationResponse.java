package com.github.nalukit.example.app.transport.response;

import com.github.nalukit.example.app.model.PersistanceData;
import org.dominokit.jackson.annotation.JSONMapper;

@JSONMapper
public class LoadApplicationResponse
    extends AbstractResponse {

  private PersistanceData persistanceData;

  public LoadApplicationResponse() {
    this(null);
  }

  public LoadApplicationResponse(PersistanceData persistanceData) {
    this.persistanceData = persistanceData;
  }

  public PersistanceData getPersistanceData() {
    return persistanceData;
  }

  public void setPersistanceData(PersistanceData persistanceData) {
    this.persistanceData = persistanceData;
  }
}
