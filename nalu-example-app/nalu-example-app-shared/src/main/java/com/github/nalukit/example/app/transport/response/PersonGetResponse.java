package com.github.nalukit.example.app.transport.response;

import com.github.nalukit.example.app.model.Person;
import org.dominokit.jackson.annotation.JSONMapper;

@JSONMapper
public class PersonGetResponse
    extends AbstractResponse {

  private Person person;

  public PersonGetResponse() {
  }

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

}
