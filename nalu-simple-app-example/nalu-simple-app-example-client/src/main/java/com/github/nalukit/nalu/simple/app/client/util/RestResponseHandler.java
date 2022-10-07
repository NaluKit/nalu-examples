package com.github.nalukit.nalu.simple.app.client.util;

import com.github.nalukit.nalu.simple.app.shared.model.common.Message;

import java.util.List;

public class RestResponseHandler {

  private final Command commandOk;

  protected RestResponseHandler(Builder builder) {
    assert builder.commandOk != null : "Das Command, das ausgefuehrt werden soll, wenn der Statuscode OK ist, ist nicht gefuellt";

    this.commandOk = builder.commandOk;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * <p>Verarbeite die Response!</p>
   */
  public void handle() {
    commandOk.execute();
  }

  public interface CommandBusinessError {

    void onBusinessError(List<Message> messages);

  }



  public static class Builder {

    private Command commandOk;

    /**
     * <p>Setzen des Commands, das ausgefuehrt werden soll, wenn der Call erfolgreich war (Statusode: OK)</p>
     *
     * @param commandOk der Command
     * @return RestResponseHandler.Builder
     */
    public Builder executeIfStatuscodeIsOk(Command commandOk) {
      this.commandOk = commandOk;
      return this;
    }

    public RestResponseHandler build() {
      return new RestResponseHandler(this);
    }

  }

}
