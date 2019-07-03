package de.gishmo.example.devk.shared.model.transport.response;

import de.gishmo.example.devk.shared.model.AbstractDto;

public class AbstractResponse
    extends AbstractDto {

  private Status status;

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

}
