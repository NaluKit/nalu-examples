package de.gishmo.example.devk.shared.model.transport.response;

import de.gishmo.example.devk.shared.model.dto.Person;
import org.dominokit.jacksonapt.annotation.JSONMapper;

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
