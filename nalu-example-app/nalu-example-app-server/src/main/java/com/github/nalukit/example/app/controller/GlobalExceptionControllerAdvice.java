package com.github.nalukit.example.app.controller;

import com.github.nalukit.example.app.exception.DataNotFoundException;
import com.github.nalukit.example.app.exception.NotAuthorizedException;
import com.github.nalukit.example.app.exception.ServiceException;
import com.github.nalukit.example.app.model.common.Message;
import com.github.nalukit.malio.shared.util.MalioValidationException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionControllerAdvice {

  public GlobalExceptionControllerAdvice() {
  }

  @ExceptionHandler(NotAuthorizedException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ResponseBody
  public Message handleNotAuthorizedException(NotAuthorizedException e,
                                              WebRequest request) {
    String uuid = UUID.randomUUID()
                      .toString();
    this.logAndSendError(uuid,
                         e);
    return new Message(uuid,
                       "message01",
                       ((ServletWebRequest) request).getRequest()
                                                    .getRequestURI(),
                       this.now(),
                       "User is not logged in");
  }

  @ExceptionHandler(ServiceException.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  @ResponseBody
  public Message handleServiceException(ServiceException e,
                                        WebRequest request) {
    String uuid = UUID.randomUUID()
                      .toString();
    this.logAndSendError(uuid,
                         e);
    return new Message(uuid,
                       "message01",
                       ((ServletWebRequest) request).getRequest()
                                                    .getRequestURI(),
                       this.now(),
                       e.getMessage());
  }

  @ExceptionHandler(DataNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ResponseBody
  public Message handleDataNotFoundException(DataNotFoundException e,
                                             WebRequest request) {
    String uuid = UUID.randomUUID()
                      .toString();
    this.logAndSendError(uuid,
                         e);
    return new Message(uuid,
                       "message01",
                       ((ServletWebRequest) request).getRequest()
                                                    .getRequestURI(),
                       this.now(),
                       e.getMessage());
  }

  @ExceptionHandler(MalioValidationException.class)
  @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
  @ResponseBody
  public Message handleMalioValidationException(MalioValidationException e,
                                                WebRequest request) {
    String uuid = UUID.randomUUID()
                      .toString();
    this.logMalioValidationError(uuid,
                                 e);
    return new Message(uuid,
                       "message01",
                       ((ServletWebRequest) request).getRequest()
                                                    .getRequestURI(),
                       this.now(),
                       "MalioValidationError");
  }

  private void logMalioValidationError(String uuid,
                                       MalioValidationException e) {
    List<String> messages = new ArrayList<>();
    messages.add("");
    messages.add("================================================================================================================================");
    messages.add("");
    messages.add("Makani Office Manager");
    messages.add("---------------------------");
    messages.add("");
    messages.add("Exception: MalioValidationException");
    messages.add("");
    if (uuid != null) {
      messages.add("");
      messages.add("Ident: " + uuid);
      messages.add("");
    }
    messages.add("Class: " + e.getClassName());
    messages.add("");
    messages.add("Field: " + e.getFieldName());
    messages.add("");
    messages.add("Message: " + e.getMessage());
    messages.add("");
    for (StackTraceElement element : e.getStackTrace()) {
      messages.add(element.toString());
    }
    messages.add("================================================================================================================================");
    messages.add("");
    messages.forEach(this::log);
  }

  private void logAndSendError(String uuid,
                               Exception e) {
    List<String> messages = new ArrayList<>();
    messages.add("");
    messages.add("================================================================================================================================");
    messages.add("");
    messages.add("Makani Office Manager");
    messages.add("---------------------------");
    messages.add("");
    if (uuid != null) {
      messages.add("");
      messages.add("Ident: " + uuid);
      messages.add("");
    }
    messages.add("Message: " + e.getMessage());
    messages.add("");
    for (StackTraceElement element : e.getStackTrace()) {
      messages.add(element.toString());
    }
    messages.add("================================================================================================================================");
    messages.add("");
    messages.forEach(this::log);
  }

  private void log(String message) {

  }

  private String getHostUrl() {
    HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
    String   url       = httpServletRequest.getRequestURL()
                                           .toString();
    String[] splitters = url.split("/");
    return splitters[0] + "//" + splitters[2];
  }

  private String now() {
    LocalDateTime timestamp = LocalDateTime.now();
    return timestamp.format(DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss"));
  }
}
