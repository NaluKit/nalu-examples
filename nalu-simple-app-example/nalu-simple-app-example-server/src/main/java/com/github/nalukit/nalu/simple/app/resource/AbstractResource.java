package com.github.nalukit.nalu.simple.app.resource;

import com.github.nalukit.nalu.simple.app.exception.NotAuthorizedException;
import com.github.nalukit.nalu.simple.app.store.Store;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

abstract class AbstractResource {
  private static final Logger log = LoggerFactory.getLogger(AbstractResource.class.getName());

  protected void checkLoggedIn() {
    if (!Store.get()
              .isLoggedIn()) {
      throw new NotAuthorizedException();
    }
  }

  protected ResponseEntity.BodyBuilder createResponseEntity() {
    log.debug("createResponseEntity");
    return ResponseEntity.ok()
                         .cacheControl(CacheControl.noCache())
                         .header(HttpHeaders.PRAGMA,
                                 "no-cache")
                         .header(HttpHeaders.EXPIRES,
                                 "0");
  }
}