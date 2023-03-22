package com.github.nalukit.nalu.simple.app.resource;

import com.github.nalukit.nalu.simple.app.store.Store;
import com.github.nalukit.nalu.simple.app.shared.model.PersonSearch;
import com.github.nalukit.nalu.simple.app.shared.transport.request.LogonRequest;
import com.github.nalukit.nalu.simple.app.shared.transport.response.LogonResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class LogonResource
    extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(LogonResource.class.getName());

  @PostMapping("/service/example/logon/login")
  public ResponseEntity<LogonResponse> login(
      @RequestBody
      LogonRequest request) {

    LogonResponse response = new LogonResponse();

    Store.get()
         .getPersistanceData()
         .setLoggedIn(true);
    Store.get()
         .getPersistanceData()
         .setUserID(request.getUserId());
    Store.get()
         .getPersistanceData()
         .setPersonSearch(new PersonSearch());

    response.setUserId(request.getUserId());
    response.setPersistanceData(Store.get()
                                     .getPersistanceData());

    log.info("User >>" + request.getUserId() + "<< tries to log in at >>" + DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                                                                             .format(LocalDateTime.now()) + "<<");

    Store.get()
         .setLoggedIn(true);

    return createResponseEntity().body(response);
  }

}