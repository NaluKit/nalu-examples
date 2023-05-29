package com.github.nalukit.nalu.complex.app.resource;

import com.github.nalukit.nalu.complex.app.service.PersonService;
import com.github.nalukit.nalu.complex.app.shared.transport.request.PersonChangeRequest;
import com.github.nalukit.nalu.complex.app.shared.transport.request.PersonChangeRequestMalioValidator;
import com.github.nalukit.nalu.complex.app.shared.transport.request.PersonGetRequest;
import com.github.nalukit.nalu.complex.app.shared.transport.request.PersonGetRequestMalioValidator;
import com.github.nalukit.nalu.complex.app.shared.transport.request.PersonSearchRequest;
import com.github.nalukit.nalu.complex.app.shared.transport.request.PersonSearchRequestMalioValidator;
import com.github.nalukit.nalu.complex.app.shared.transport.response.PersonChangeResponse;
import com.github.nalukit.nalu.complex.app.shared.transport.response.PersonGetResponse;
import com.github.nalukit.nalu.complex.app.shared.transport.response.PersonSearchResponse;
import com.github.nalukit.nalu.complex.app.store.Store;
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

    // validate!
    PersonGetRequestMalioValidator.INSTANCE.check(request);

    PersonGetResponse response = new PersonGetResponse();
    response.setPerson(PersonService.get()
                                    .get(request.getId()));
    return createResponseEntity().body(response);
  }

  @PostMapping("/service/example/person/getAll")
  public ResponseEntity<PersonSearchResponse> getAll(
      @RequestBody
      PersonSearchRequest request) {

    // validate!
    PersonSearchRequestMalioValidator.INSTANCE.check(request);

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

    // validate!
    PersonChangeRequestMalioValidator.INSTANCE.check(request);

    PersonChangeResponse response = new PersonChangeResponse();
    response.setPerson(PersonService.get()
                                    .insert(request.getPerson()));
    return createResponseEntity().body(response);
  }

  @PostMapping("/service/example/person/update")
  public ResponseEntity<PersonChangeResponse> update(
      @RequestBody
      PersonChangeRequest request) {

    // validate!
    PersonChangeRequestMalioValidator.INSTANCE.check(request);

    PersonChangeResponse response = new PersonChangeResponse();
    response.setPerson(PersonService.get()
                                    .update(request.getPerson()));
    return createResponseEntity().body(response);
  }

}