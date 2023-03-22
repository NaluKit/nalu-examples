package com.github.nalukit.nalu.simple.app.resource;

import com.github.nalukit.nalu.simple.app.service.PersonService;
import com.github.nalukit.nalu.simple.app.store.Store;
import com.github.nalukit.nalu.simple.app.shared.transport.request.PersonChangeRequest;
import com.github.nalukit.nalu.simple.app.shared.transport.request.PersonGetRequest;
import com.github.nalukit.nalu.simple.app.shared.transport.request.PersonSearchRequest;
import com.github.nalukit.nalu.simple.app.shared.transport.response.PersonChangeResponse;
import com.github.nalukit.nalu.simple.app.shared.transport.response.PersonGetResponse;
import com.github.nalukit.nalu.simple.app.shared.transport.response.PersonSearchResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonResource
    extends AbstractResource {

  @PostMapping("/service/example/person/get")
  public ResponseEntity<PersonGetResponse> get(
      @RequestBody
      PersonGetRequest request) {
    PersonGetResponse response = new PersonGetResponse();
    response.setPerson(PersonService.get()
                                    .get(request.getId()));
    return createResponseEntity().body(response);
  }

  @PostMapping("/service/example/person/getAll")
  public ResponseEntity<PersonSearchResponse> getAll(
      @RequestBody
      PersonSearchRequest request) {
    PersonSearchResponse response = new PersonSearchResponse();
    response.setPersonList(PersonService.get()
                                        .get(request.getPersistanceData()
                                                    .getPersonSearch()));
    // Save persisitance data!
    Store.get()
         .setPersistanceData(request.getPersistanceData());
    return createResponseEntity().body(response);
  }

  @PostMapping("/service/example/person/insert")
  public ResponseEntity<PersonChangeResponse> insert(
      @RequestBody
      PersonChangeRequest request) {
    PersonChangeResponse response = new PersonChangeResponse();
    response.setPerson(PersonService.get()
                                    .insert(request.getPerson()));
    return createResponseEntity().body(response);
  }

  @PostMapping("/service/example/person/update")
  public ResponseEntity<PersonChangeResponse> update(
      @RequestBody
      PersonChangeRequest request) {
    PersonChangeResponse response = new PersonChangeResponse();
    response.setPerson(PersonService.get()
                                    .update(request.getPerson()));
    return createResponseEntity().body(response);
  }

}