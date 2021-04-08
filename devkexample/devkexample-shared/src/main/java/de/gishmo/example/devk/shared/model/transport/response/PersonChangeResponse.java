package de.gishmo.example.devk.shared.model.transport.response;

import de.gishmo.example.devk.shared.model.dto.Person;
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
