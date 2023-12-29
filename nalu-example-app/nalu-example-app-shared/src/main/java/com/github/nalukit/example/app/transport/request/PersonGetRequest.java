package com.github.nalukit.example.app.transport.request;

import com.github.nalukit.malio.shared.annotation.MalioValidator;
import com.github.nalukit.malio.shared.annotation.field.NotZero;
import org.dominokit.jackson.annotation.JSONMapper;
import org.dominokit.rest.shared.request.RequestBean;

@JSONMapper
@MalioValidator(generateValidateMethod = false)
public class PersonGetRequest
    extends AbstractRequest
    implements RequestBean {

  @NotZero
  private long id;

  public PersonGetRequest() {
  }

  public PersonGetRequest(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }
}

