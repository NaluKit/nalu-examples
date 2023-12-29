package com.github.nalukit.example.app.service;

import com.github.nalukit.example.app.transport.request.LoggingRequest;
import com.github.nalukit.example.app.transport.response.LoggingResponse;
import org.dominokit.rest.shared.request.service.annotations.RequestBody;
import org.dominokit.rest.shared.request.service.annotations.RequestFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RequestFactory(serviceRoot = "service/example")
@Path("/logging")
public interface LoggingService {

  @POST
  @Path("/log")
  LoggingResponse log(
      @RequestBody LoggingRequest request);

}
