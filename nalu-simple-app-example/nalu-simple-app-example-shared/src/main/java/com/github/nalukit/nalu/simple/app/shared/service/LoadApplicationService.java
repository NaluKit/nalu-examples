package com.github.nalukit.nalu.simple.app.shared.service;

import com.github.nalukit.nalu.simple.app.shared.transport.response.LoadApplicationResponse;
import org.dominokit.rest.shared.request.service.annotations.RequestFactory;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

@RequestFactory(serviceRoot = "service/example")
@Path("/application")
public interface LoadApplicationService {

  @POST
  @Path("/load")
  LoadApplicationResponse load();

}
