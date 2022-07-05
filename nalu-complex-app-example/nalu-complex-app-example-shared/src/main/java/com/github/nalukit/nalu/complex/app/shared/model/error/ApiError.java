package com.github.nalukit.nalu.complex.app.shared.model.error;

import org.dominokit.jackson.annotation.JSONMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@JSONMapper
public class ApiError {

  private String            uuid;
  private String            url;
  private String            errorTS;
  private int               statusCode;
  private String            statusMessage;
  private String            message;
  private List<ApiSubError> subErrors;

  public ApiError() {
    this.subErrors = new ArrayList<>();
  }

  public ApiError(String url,
                  String errorTS,
                  int statusCode,
                  String statusMessage,
                  String message) {
    this();
    this.url           = url;
    this.errorTS       = errorTS;
    this.statusCode    = statusCode;
    this.statusMessage = statusMessage;
    this.message       = message;
  }

  public ApiError(String uuid,
                  String url,
                  String errorTS,
                  int statusCode,
                  String statusMessage,
                  String message) {
    this();
    this.uuid          = uuid;
    this.url           = url;
    this.errorTS       = errorTS;
    this.statusCode    = statusCode;
    this.statusMessage = statusMessage;
    this.message       = message;
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getErrorTS() {
    return errorTS;
  }

  public void setErrorTS(String errorTS) {
    this.errorTS = errorTS;
  }

  public int getStatusCode() {
    return statusCode;
  }

  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }

  public String getStatusMessage() {
    return statusMessage;
  }

  public void setStatusMessage(String statusMessage) {
    this.statusMessage = statusMessage;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public List<ApiSubError> getSubErrors() {
    return subErrors;
  }

  public void setSubErrors(List<ApiSubError> subErrors) {
    this.subErrors = subErrors;
  }

  @Override
  public boolean equals(Object o) {
    if (this ==
        o) {
      return true;
    }
    if (o ==
        null ||
        getClass() !=
        o.getClass()) {
      return false;
    }
    ApiError apiError = (ApiError) o;
    return statusCode ==
           apiError.statusCode &&
           Objects.equals(uuid,
                          apiError.uuid) &&
           Objects.equals(url,
                          apiError.url) &&
           Objects.equals(errorTS,
                          apiError.errorTS) &&
           Objects.equals(statusMessage,
                          apiError.statusMessage) &&
           Objects.equals(message,
                          apiError.message) &&
           Objects.equals(subErrors,
                          apiError.subErrors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(uuid,
                        url,
                        errorTS,
                        statusCode,
                        statusMessage,
                        message,
                        subErrors);
  }

  @Override
  public String toString() {
    return "ApiError{" +
           "uuid='" +
           uuid +
           '\'' +
           ", url='" +
           url +
           '\'' +
           ", errorTS='" +
           errorTS +
           '\'' +
           ", statusCode=" +
           statusCode +
           ", statusMessage='" +
           statusMessage +
           '\'' +
           ", message='" +
           message +
           '\'' +
           ", subErrors=" +
           subErrors +
           '}';
  }
}