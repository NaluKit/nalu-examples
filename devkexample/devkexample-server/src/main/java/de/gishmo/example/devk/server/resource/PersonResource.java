package de.gishmo.example.devk.server.resource;

import de.gishmo.example.devk.server.service.PersonService;
import de.gishmo.example.devk.shared.model.dto.Person;
import de.gishmo.example.devk.shared.model.dto.PersonSearch;
import de.gishmo.example.devk.shared.model.exception.PersonException;
import de.gishmo.example.devk.shared.model.exception.PersonNotFoundException;
import de.gishmo.example.devk.shared.model.transport.response.PersonChangeResponse;
import de.gishmo.example.devk.shared.model.transport.response.PersonGetResponse;
import de.gishmo.example.devk.shared.model.transport.response.PersonSearchResponse;
import de.gishmo.example.devk.shared.model.transport.response.Status;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

@Path("/person")
public class PersonResource {

  @GET
  @Path("/get/{id}")
  @Consumes("application/json")
  //@Produces("application/json")
  public PersonGetResponse get(@PathParam("id") String id) {
    PersonGetResponse response = new PersonGetResponse();
    Status status = new Status();
    response.setStatus(status);
    try {
      response.setPerson(PersonService.get()
                                      .get(Long.parseLong(id)));
      status.setReturnCode(Status.OK);
    } catch (PersonNotFoundException e) {
      status.setReturnCode(Status.NOT_FOUND);
    }
    return response;
  }

  @POST
  @Path("/getAll")
  @Consumes("application/json")
  //@Produces("application/json")
  public PersonSearchResponse getAll(PersonSearch search) {
    PersonSearchResponse response = new PersonSearchResponse();
    Status status = new Status();
    status.setReturnCode(Status.OK);
    response.setStatus(status);
    response.setPersonList(PersonService.get()
                                        .get(search));
    return response;
  }

  @POST
  @Path("/insert")
  @Consumes("application/json")
  //@Produces("application/json")
  public PersonChangeResponse insert(Person request) {
    PersonChangeResponse response = new PersonChangeResponse();
    Status status = new Status();
    response.setStatus(status);
    try {
      response.setPerson(PersonService.get()
                                      .insert(request));
      status.setReturnCode(Status.OK);
    } catch (PersonException e) {
      status.setReturnCode(Status.TECHNICAL_SERVER_ERROR);
    }
    return response;
  }

  @POST
  @Path("/update")
  @Consumes("application/json")
  //@Produces("application/json")
  public PersonChangeResponse update(Person request) {
    PersonChangeResponse response = new PersonChangeResponse();
    Status status = new Status();
    response.setStatus(status);
    try {
      response.setPerson(PersonService.get()
                                      .update(request));
      status.setReturnCode(Status.OK);
    } catch (PersonException e) {
      status.setReturnCode(Status.TECHNICAL_SERVER_ERROR);
    }
    return response;
  }

}