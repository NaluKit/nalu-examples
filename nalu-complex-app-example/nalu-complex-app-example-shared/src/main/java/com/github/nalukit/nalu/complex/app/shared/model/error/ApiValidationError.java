package com.github.nalukit.nalu.complex.app.shared.model.error;

import org.dominokit.jackson.annotation.JSONMapper;

import java.util.Objects;

@JSONMapper
public class ApiValidationError {

  private String object;
  private String field;
  private String message;

  public ApiValidationError() {
  }

  public ApiValidationError(String object,
                            String field,
                            String message) {
    this.object  = object;
    this.field   = field;
    this.message = message;
  }

  public ApiValidationError(ApiValidationError other) {
    this.object  = other.object;
    this.field   = other.field;
    this.message = other.message;
  }

  public String getObject() {
    return object;
  }

  public void setObject(String object) {
    this.object = object;
  }

  public String getField() {
    return field;
  }

  public void setField(String field) {
    this.field = field;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiValidationError that = (ApiValidationError) o;
    return Objects.equals(object,
                          that.object) && Objects.equals(field,
                                                         that.field) && Objects.equals(message,
                                                                                       that.message);
  }

  @Override
  public int hashCode() {
    return Objects.hash(object,
                        field,
                        message);
  }

  @Override
  public String toString() {
    return "ApiValidationError{" +
           "object='" +
           object +
           '\'' +
           ", field='" +
           field +
           '\'' +
           ", message='" +
           message +
           '\'' +
           '}';
  }

}
