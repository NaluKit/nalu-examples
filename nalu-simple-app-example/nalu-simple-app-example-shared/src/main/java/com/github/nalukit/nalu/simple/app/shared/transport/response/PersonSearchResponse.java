package com.github.nalukit.nalu.simple.app.shared.transport.response;

import com.github.nalukit.nalu.simple.app.shared.model.Person;
import org.dominokit.jackson.annotation.JSONMapper;

import java.util.ArrayList;
import java.util.List;

@JSONMapper
public class PersonSearchResponse
    extends AbstractResponse {

  private List<Person> personList;

  public PersonSearchResponse() {
    this.personList = new ArrayList<>();
  }

  public List<Person> getPersonList() {
    return personList;
  }

  public void setPersonList(List<Person> personList) {
    this.personList = personList;
  }

}
