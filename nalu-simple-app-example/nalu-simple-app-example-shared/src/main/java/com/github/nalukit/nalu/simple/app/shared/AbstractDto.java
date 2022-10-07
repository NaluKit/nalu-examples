package com.github.nalukit.nalu.simple.app.shared;

import com.github.nalukit.nalu.simple.app.shared.util.GUID;

public abstract class AbstractDto {

  private String uuid;

  public AbstractDto() {
    super();
    this.uuid = GUID.get();
  }

  public String getUuid() {
    return uuid;
  }

  public void setUuid(String uuid) {
    this.uuid = uuid;
  }

}
