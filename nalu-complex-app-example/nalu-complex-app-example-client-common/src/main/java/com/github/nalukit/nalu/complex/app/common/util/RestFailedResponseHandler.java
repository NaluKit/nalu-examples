package com.github.nalukit.nalu.complex.app.common.util;

import com.github.nalukit.nalu.client.IsRouter;
import com.github.nalukit.nalu.complex.app.common.event.HideAllEvent;
import com.github.nalukit.nalu.complex.app.common.ui.Routes;
import com.github.nalukit.nalu.complex.app.common.ui.common.MessageFactory;
import org.dominokit.domino.ui.notifications.Notification;
import org.dominokit.rest.shared.request.FailedResponseBean;
import org.gwtproject.event.shared.EventBus;

public class RestFailedResponseHandler {

  private final static int BAD_REQUEST  = 400;
  private final static int UNAUTHORIZED = 401;
  private final static int NOT_FOUND    = 404;
  private final static int CONFLICT     = 409;

  private final static int INTERNAL_SERVER_ERROR = 500;

  private final IsRouter           router;
  private final Class<?>           callingClazz;
  private final String             callingMethod;
  private final EventBus           eventBus;
  private final String             lastExecutedHash;
  private final FailedResponseBean response;
  private final Command            commandNotFound;

  protected RestFailedResponseHandler(Builder builder) {
    assert builder.router !=
           null : "router is missing";
    assert builder.callingClazz !=
           null : "reference of calling class is missing";
    assert builder.callingMethod !=
           null : "name of the calling method is missing";
    assert builder.response !=
           null : "response is missing";
    assert builder.lastExecutedHash !=
           null : "lasExecutedHash is missing";
    assert builder.eventBus !=
           null : "event bus is missing";

    this.router           = builder.router;
    this.callingClazz     = builder.callingClazz;
    this.callingMethod    = builder.callingMethod;
    this.eventBus         = builder.eventBus;
    this.lastExecutedHash = builder.lastExecutedHash;
    this.response         = builder.response;
    this.commandNotFound  = builder.commandNotFound;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * <p>Verarbeite die Response!</p>
   */
  public void handle() {
    if (response.getStatusCode() ==
        RestFailedResponseHandler.UNAUTHORIZED) {
      MessageFactory.get()
                    .hideProgressBar();
      this.eventBus.fireEvent(new HideAllEvent());
      this.router.route(Routes.ROUTE_LOGON);
      return;
    }

    if (response.getStatusCode() ==
        RestFailedResponseHandler.NOT_FOUND) {
      if (commandNotFound !=
          null) {
        commandNotFound.execute();
      }
      MessageFactory.get()
                    .hideProgressBar();
      this.eventBus.fireEvent(new HideAllEvent());
      Notification.createDanger("Es wurden keine Daten gefunden!")
                  .setClosable(false)
                  .show();
      this.router.route(Routes.ROUTE_HOME);
      return;
    }

    if (response.getStatusCode() ==
        RestFailedResponseHandler.INTERNAL_SERVER_ERROR) {
      if (commandNotFound !=
          null) {
        commandNotFound.execute();
      }
      MessageFactory.get()
                    .hideProgressBar();
      this.eventBus.fireEvent(new HideAllEvent());
      this.router.route(Routes.ROUTE_HOME);
      return;
    }

  }

  public static class Builder {

    private IsRouter           router;
    private Class<?>           callingClazz;
    private String             callingMethod;
    private EventBus           eventBus;
    private String             lastExecutedHash;
    private FailedResponseBean response;
    private Command            commandNotFound;

    public Builder router(IsRouter router) {
      this.router = router;
      return this;
    }

    public Builder callingClass(Class<?> callingClazz) {
      this.callingClazz = callingClazz;
      return this;
    }

    public Builder callingMethod(String callingMethod) {
      this.callingMethod = callingMethod;
      return this;
    }

    public Builder failedResponseBean(FailedResponseBean failedResponseBean) {
      this.response = failedResponseBean;
      return this;
    }

    public Builder eventBus(EventBus eventBus) {
      this.eventBus = eventBus;
      return this;
    }

    public Builder lastExecutedHash(String lastExecutedHash) {
      this.lastExecutedHash = lastExecutedHash;
      return this;
    }

    public Builder executeIfNotFound(Command command) {
      this.commandNotFound = command;
      return this;
    }

    public RestFailedResponseHandler build() {
      return new RestFailedResponseHandler(this);
    }

  }

}
