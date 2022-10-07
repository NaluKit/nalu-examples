package com.github.nalukit.nalu.simple.app.client.util;

import com.github.nalukit.nalu.client.IsRouter;
import com.github.nalukit.nalu.simple.app.client.event.HideAllEvent;
import com.github.nalukit.nalu.simple.app.client.ui.Routes;
import com.github.nalukit.nalu.simple.app.client.ui.common.MessageFactory;
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
  //  private final CommandBusinessError commandBusinessError;
  private final Command            commandNotFound;

  protected RestFailedResponseHandler(Builder builder) {
    assert builder.router != null : "router is missing";
    assert builder.callingClazz != null : "reference of calling class is missing";
    assert builder.callingMethod != null : "name of the calling method is missing";
    assert builder.response != null : "response is missing";
    assert builder.lastExecutedHash != null : "lasExecutedHash is missing";
    assert builder.eventBus != null : "event bus is missing";

    this.router           = builder.router;
    this.callingClazz     = builder.callingClazz;
    this.callingMethod    = builder.callingMethod;
    this.eventBus         = builder.eventBus;
    this.lastExecutedHash = builder.lastExecutedHash;
    this.response         = builder.response;
    //    this.commandBusinessError = builder.commandBusinessError;
    this.commandNotFound = builder.commandNotFound;
  }

  public static Builder builder() {
    return new Builder();
  }

  /**
   * <p>Verarbeite die Response!</p>
   */
  public void handle() {
    if (response.getStatusCode() == RestFailedResponseHandler.UNAUTHORIZED) {
      MessageFactory.INSTANCE
                    .hideProgressBar();
      this.eventBus.fireEvent(new HideAllEvent());
      this.router.route(Routes.ROUTE_HOME);
      return;
    }

    if (response.getStatusCode() == RestFailedResponseHandler.NOT_FOUND) {
      if (commandNotFound != null) {
        commandNotFound.execute();
      }
      MessageFactory.INSTANCE
                    .hideProgressBar();
      this.eventBus.fireEvent(new HideAllEvent());
      Notification.createDanger("Es wurden keine Daten gefunden!")
                  .setClosable(false)
                  .show();
      this.router.route(Routes.ROUTE_HOME);
      return;
    }

    if (response.getStatusCode() == RestFailedResponseHandler.INTERNAL_SERVER_ERROR) {
      if (commandNotFound != null) {
        commandNotFound.execute();
      }
      MessageFactory.INSTANCE
                    .hideProgressBar();
      this.eventBus.fireEvent(new HideAllEvent());
      this.router.route(Routes.ROUTE_HOME);
      return;
    }

    //    if (response.getStatusCode() == RestFailedResponseHandler.CONFLICT) {
    //      MessageFactory.INSTANCE
    //                    .hideProgressBar();
    //      this.eventBus.fireEvent(new HideAllEvent());
    //      this.eventBus.fireEvent(ShowPopUpEvent.show(AhiConstants.POPUP_CONFLICT));
    //      return;
    //    }
    //
    //    try {
    //      ApiError apiError = parseJson(response.getBody());
    //
    //      if (response.getStatusCode() == RestFailedResponseHandler.BAD_REQUEST) {
    //        if (this.commandBusinessError != null) {
    //          this.commandBusinessError.onBusinessError(apiError.getMessages());
    //        }
    //        MessageFactory.INSTANCE
    //                      .hideProgressBar();
    //        return;
    //      }
    //
    //      MessageFactory.INSTANCE
    //                    .hideProgressBar();
    //      this.eventBus.fireEvent(NaluErrorEvent.createApplicationError()
    //                                            .message(ApplicationConstantsFactory.get()
    //                                                                                .get("errorFailed"))
    //                                            .route(this.lastExecutedHash)
    //                                            .data(AhiConstants.ERROR_PARAMETER_IDENT,
    //                                                  apiError.getUuid())
    //                                            .data(AhiConstants.ERROR_PARAMETER_CLASS,
    //                                                  callingClazz.getSimpleName())
    //                                            .data(AhiConstants.ERROR_PARAMETER_METHOD,
    //                                                  callingMethod)
    //                                            .data(AhiConstants.ERROR_PARAMETER_STATUSCODE,
    //                                                  String.valueOf(response.getStatusCode()))
    //                                            .data(AhiConstants.ERROR_PARAMETER_STATUSTEXT,
    //                                                  apiError.getMessage()));
    //    } catch (Exception e) {
    //      MessageFactory.INSTANCE
    //                    .hideProgressBar();
    //      this.eventBus.fireEvent(NaluErrorEvent.createApplicationError()
    //                                            .message(ApplicationConstantsFactory.get()
    //                                                                                .get("errorFailed"))
    //                                            .route(this.lastExecutedHash)
    //                                            .data(AhiConstants.ERROR_PARAMETER_IDENT,
    //                                                  "n/a")
    //                                            .data(AhiConstants.ERROR_PARAMETER_CLASS,
    //                                                  callingClazz.getSimpleName())
    //                                            .data(AhiConstants.ERROR_PARAMETER_METHOD,
    //                                                  callingMethod)
    //                                            .data(AhiConstants.ERROR_PARAMETER_STATUSCODE,
    //                                                  String.valueOf(response.getStatusCode()))
    //                                            .data(AhiConstants.ERROR_PARAMETER_STATUSTEXT,
    //                                                  "n/a"));
    //    }
  }

  //  private ApiError parseJson(String json) {
  //    ObjectMapper<ApiError> apiErrorMapper = AhiJSONMapperJsonRegistry.getInstance()
  //                                                                     .getMapper(TypeToken.of(ApiError.class));
  //    return apiErrorMapper.read(json);
  //  }
  //
  //  public interface CommandBusinessError {
  //
  //    void onBusinessError(List<ClMessage> messages);
  //
  //  }



  public static class Builder {

    private IsRouter           router;
    private Class<?>           callingClazz;
    private String             callingMethod;
    private EventBus           eventBus;
    private String             lastExecutedHash;
    private FailedResponseBean response;
    //    private CommandBusinessError commandBusinessError;
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

    //    /**
    //     * <p>Setzen des Commands, das ausgefuehrt werden soll, wenn Response not authorized ist (Statusode: NOT_AUTHORIZED)</p>
    //     *
    //     * @param command das Command, das im Falle eines fachlichen Fehlers auszufuehren ist
    //     * @return RestResponseHandler.Builder
    //     */
    //    public Builder executeIfStatuscodeBusinessError(CommandBusinessError command) {
    //      this.commandBusinessError = command;
    //      return this;
    //    }

    public Builder executeIfNotFound(Command command) {
      this.commandNotFound = command;
      return this;
    }

    public RestFailedResponseHandler build() {
      return new RestFailedResponseHandler(this);
    }

  }

}
