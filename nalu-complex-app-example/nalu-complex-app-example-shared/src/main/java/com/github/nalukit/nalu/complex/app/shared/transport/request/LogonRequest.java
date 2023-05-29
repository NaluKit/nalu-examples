package com.github.nalukit.nalu.complex.app.shared.transport.request;

import com.github.nalukit.malio.shared.annotation.MalioValidator;
import com.github.nalukit.malio.shared.annotation.field.MaxLength;
import com.github.nalukit.malio.shared.annotation.field.NotBlank;
import com.github.nalukit.malio.shared.annotation.field.NotNull;
import org.dominokit.jackson.annotation.JSONMapper;
import org.dominokit.rest.shared.request.RequestBean;

@JSONMapper
@MalioValidator(generateValidateMethod = false)
public class LogonRequest
    extends AbstractRequest
    implements RequestBean {

  @NotNull
  @NotBlank
  @MaxLength(32)
  private String userId;
  @NotNull
  @NotBlank
  @MaxLength(32)
  private String password;

  public LogonRequest() {
  }

  public LogonRequest(String userId,
                      String password) {
    this.userId   = userId;
    this.password = password;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

}
