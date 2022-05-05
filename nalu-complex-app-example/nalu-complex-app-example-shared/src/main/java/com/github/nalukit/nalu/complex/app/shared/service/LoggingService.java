package com.github.nalukit.nalu.complex.app.shared.service;

import com.github.nalukit.nalu.complex.app.shared.transport.request.LoggingRequest;
import com.github.nalukit.nalu.complex.app.shared.transport.response.LoggingResponse;
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
      @RequestBody
      LoggingRequest request);

}
