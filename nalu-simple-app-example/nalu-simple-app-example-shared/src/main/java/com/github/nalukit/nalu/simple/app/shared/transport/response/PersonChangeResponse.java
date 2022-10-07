package com.github.nalukit.nalu.simple.app.shared.transport.response;

import com.github.nalukit.nalu.simple.app.shared.model.Person;
import org.dominokit.jackson.annotation.JSONMapper;

@JSONMapper
public class PersonChangeResponse
    extends AbstractResponse {

  private Person person;

  public PersonChangeResponse() {
  }

  public PersonChangeResponse(Person person) {
    this.person = person;
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

}
