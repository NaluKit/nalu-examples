package com.github.nalukit.nalu.simple.app.shared.transport.request;

import org.dominokit.jackson.annotation.JSONMapper;
import org.dominokit.rest.shared.request.RequestBean;

@JSONMapper
public class PersonGetRequest
    extends AbstractRequest
    implements RequestBean {

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

