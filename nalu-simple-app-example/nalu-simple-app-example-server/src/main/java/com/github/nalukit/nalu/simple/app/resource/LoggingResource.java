package com.github.nalukit.nalu.simple.app.resource;

import com.github.nalukit.nalu.simple.app.shared.transport.request.LoggingRequest;
import com.github.nalukit.nalu.simple.app.shared.transport.response.LoggingResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingResource
    extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(LoggingResource.class.getName());

  @PostMapping("/service/example/logging/log")
  public ResponseEntity<LoggingResponse> log(
      @RequestBody
      LoggingRequest request) {
    LoggingResponse response = new LoggingResponse();
    request.getMessages()
           .forEach(m -> log.info("Client-Message: " + m));
    return createResponseEntity().body(response);
  }

}