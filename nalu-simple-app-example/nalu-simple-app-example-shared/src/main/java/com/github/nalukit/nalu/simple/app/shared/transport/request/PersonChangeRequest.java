package com.github.nalukit.nalu.simple.app.shared.transport.request;

import com.github.nalukit.nalu.simple.app.shared.model.Person;
import org.dominokit.jackson.annotation.JSONMapper;
import org.dominokit.rest.shared.request.RequestBean;

@JSONMapper
public class PersonChangeRequest
    extends AbstractRequest
    implements RequestBean {

  private Person person;

  public PersonChangeRequest() {
  }

  public PersonChangeRequest(Person person) {
    this.person = person;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }
}

