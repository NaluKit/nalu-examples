package com.github.nalukit.nalu.simple.app.resource;

import com.github.nalukit.nalu.simple.app.store.Store;
import com.github.nalukit.nalu.simple.app.shared.transport.response.LoadApplicationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadApplicationResource
    extends AbstractResource {

  private static final Logger log = LoggerFactory.getLogger(LoadApplicationResource.class.getName());

  @PostMapping("/service/example/application/load")
  public ResponseEntity<LoadApplicationResponse> load() {
    LoadApplicationResponse response = new LoadApplicationResponse();

    response.setPersistanceData(Store.get()
                                     .getPersistanceData());

    return createResponseEntity().body(response);
  }

}