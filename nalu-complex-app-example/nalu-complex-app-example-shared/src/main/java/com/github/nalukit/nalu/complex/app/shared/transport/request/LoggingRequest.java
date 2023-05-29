package com.github.nalukit.nalu.complex.app.shared.transport.request;

import com.github.nalukit.malio.shared.annotation.MalioValidator;
import com.github.nalukit.malio.shared.annotation.field.CollectionItemMaxLength;
import com.github.nalukit.malio.shared.annotation.field.CollectionItemNotNull;
import com.github.nalukit.malio.shared.annotation.field.Size;
import org.dominokit.jackson.annotation.JSONMapper;
import org.dominokit.rest.shared.request.RequestBean;

import java.util.List;

@JSONMapper
@MalioValidator(generateValidateMethod = false)
public class LoggingRequest
    extends AbstractRequest
    implements RequestBean {

  @Size(min = 1, max = 1024)
  @CollectionItemNotNull
  @CollectionItemMaxLength(1024)
  private List<String> messages;

  public LoggingRequest() {
  }

  public LoggingRequest(List<String> messages) {
    this.messages = messages;
  }

  public List<String> getMessages() {
    return messages;
  }

  public void setMessages(List<String> messages) {
    this.messages = messages;
  }

}
