package com.github.nalukit.nalu.complex.app.server.controller;

import com.github.nalukit.nalu.complex.app.server.exception.DataNotFoundException;
import com.github.nalukit.nalu.complex.app.server.exception.NotAuthorizedException;
import com.github.nalukit.nalu.complex.app.server.exception.ServiceException;
import com.github.nalukit.nalu.complex.app.shared.model.error.ApiError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionControllerAdvice {

  private static final Logger log = LoggerFactory.getLogger(GlobalExceptionControllerAdvice.class.getName());

  public GlobalExceptionControllerAdvice() {
  }

  @ExceptionHandler(NotAuthorizedException.class)
  public ResponseEntity<Object> handleNotAuthorizedException(NotAuthorizedException e,
                                                             WebRequest request) {
    String uuid = UUID.randomUUID()
                      .toString();
    return this.buildResponseEntity(HttpStatus.UNAUTHORIZED,
                                    new ApiError(uuid,
                                                 ((ServletWebRequest) request).getRequest()
                                                                              .getRequestURI(),
                                                 this.now(),
                                                 HttpStatus.UNAUTHORIZED.value(),
                                                 HttpStatus.UNAUTHORIZED.getReasonPhrase(),
                                                 "User is not logged in"));
  }

  @ExceptionHandler(ServiceException.class)
  public ResponseEntity<Object> handleServiceException(ServiceException e,
                                                       WebRequest request) {
    String uuid = UUID.randomUUID()
                      .toString();
    return this.buildResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR,
                                    new ApiError(uuid,
                                                 ((ServletWebRequest) request).getRequest()
                                                                              .getRequestURI(),
                                                 this.now(),
                                                 HttpStatus.INTERNAL_SERVER_ERROR.value(),
                                                 HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase(),
                                                 uuid));
  }

  @ExceptionHandler(DataNotFoundException.class)
  public ResponseEntity<Object> handleDataNotFoundException(DataNotFoundException e,
                                                            WebRequest request) {
    String uuid = UUID.randomUUID()
                      .toString();
    return this.buildResponseEntity(HttpStatus.NOT_FOUND,
                                    new ApiError(uuid,
                                                 ((ServletWebRequest) request).getRequest()
                                                                              .getRequestURI(),
                                                 this.now(),
                                                 HttpStatus.NOT_FOUND.value(),
                                                 HttpStatus.NOT_FOUND.getReasonPhrase(),
                                                 uuid));
  }

  private ResponseEntity<Object> buildResponseEntity(HttpStatus status,
                                                     ApiError apiError) {
    return ResponseEntity.status(status)
                         .cacheControl(CacheControl.noCache())
                         .header(HttpHeaders.PRAGMA,
                                 "no-cache")
                         .header(HttpHeaders.EXPIRES,
                                 "0")
                         .body(apiError);
  }

  private String now() {
    LocalDateTime timestamp = LocalDateTime.now();
    return timestamp.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
  }

}
