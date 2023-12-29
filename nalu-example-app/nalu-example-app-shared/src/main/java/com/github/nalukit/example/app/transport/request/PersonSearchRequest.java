package com.github.nalukit.example.app.transport.request;

import com.github.nalukit.malio.shared.annotation.MalioValidator;
import com.github.nalukit.nalu.complex.app.shared.model.PersistanceData;
import org.dominokit.jackson.annotation.JSONMapper;
import org.dominokit.rest.shared.request.RequestBean;

@JSONMapper
@MalioValidator(generateValidateMethod = false)
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

