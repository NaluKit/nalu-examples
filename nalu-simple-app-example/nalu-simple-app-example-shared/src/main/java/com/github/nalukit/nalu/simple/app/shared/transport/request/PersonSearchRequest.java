package com.github.nalukit.nalu.simple.app.shared.transport.request;

import com.github.nalukit.nalu.simple.app.shared.model.PersistanceData;
import org.dominokit.jackson.annotation.JSONMapper;
import org.dominokit.rest.shared.request.RequestBean;

@JSONMapper
public class PersonSearchRequest
    extends AbstractRequest
    implements RequestBean {

  private PersistanceData persistanceData;

  public PersonSearchRequest() {
  }

  public PersonSearchRequest(PersistanceData persistanceData) {
    this.persistanceData = persistanceData;
  }

  public PersistanceData getPersistanceData() {
    return persistanceData;
  }

  public void setPersistanceData(PersistanceData persistanceData) {
    this.persistanceData = persistanceData;
  }
}

