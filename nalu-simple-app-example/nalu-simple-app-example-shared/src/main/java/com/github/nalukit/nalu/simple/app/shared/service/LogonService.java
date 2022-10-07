package com.github.nalukit.nalu.simple.app.shared.service;

import com.github.nalukit.nalu.simple.app.shared.transport.request.LogonRequest;
import com.github.nalukit.nalu.simple.app.shared.transport.response.LogonResponse;
import org.dominokit.rest.shared.request.service.annotations.RequestBody;
import org.dominokit.rest.shared.request.service.annotations.RequestFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RequestFactory(serviceRoot = "service/example")
@Path("/logon")
public interface LogonService {

  @POST
  @Path("/login")
  LogonResponse login(
      @RequestBody LogonRequest request);

}
