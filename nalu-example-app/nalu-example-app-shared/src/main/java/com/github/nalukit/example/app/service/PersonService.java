package com.github.nalukit.example.app.service;

import com.github.nalukit.example.app.transport.request.PersonChangeRequest;
import com.github.nalukit.example.app.transport.request.PersonGetRequest;
import com.github.nalukit.example.app.transport.request.PersonSearchRequest;
import com.github.nalukit.example.app.transport.response.PersonChangeResponse;
import com.github.nalukit.example.app.transport.response.PersonGetResponse;
import com.github.nalukit.example.app.transport.response.PersonSearchResponse;
import org.dominokit.rest.shared.request.service.annotations.RequestBody;
import org.dominokit.rest.shared.request.service.annotations.RequestFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RequestFactory(serviceRoot = "service/example")
@Path("/person")
public interface PersonService {

  @POST
  @Path("/get")
  PersonGetResponse get(
      @RequestBody PersonGetRequest request);

  @POST
  @Path("/getAll")
  PersonSearchResponse getAll(
      @RequestBody PersonSearchRequest request);

  @POST
  @Path("/insert")
  PersonChangeResponse insert(
      @RequestBody PersonChangeRequest request);

  @POST
  @Path("/update")
  PersonChangeResponse update(
      @RequestBody
      PersonChangeRequest request);

}
