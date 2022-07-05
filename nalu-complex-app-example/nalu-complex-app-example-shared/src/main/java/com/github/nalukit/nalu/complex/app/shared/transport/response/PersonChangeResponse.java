package com.github.nalukit.nalu.complex.app.shared.transport.response;

import com.github.nalukit.nalu.complex.app.shared.model.person.Person;
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
