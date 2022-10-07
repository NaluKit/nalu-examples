package com.github.nalukit.nalu.simple.app.client.ui;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.simple.app.client.AppContext;
import com.github.nalukit.nalu.simple.app.client.util.Command;
import com.github.nalukit.nalu.simple.app.client.util.RestFailedResponseHandler;
import elemental2.dom.HTMLElement;
import org.dominokit.rest.shared.request.FailedResponseBean;

public abstract class AbstractAppComponentController<V extends IAppComponent<?>>
    extends AbstractComponentController<AppContext, V, HTMLElement>
    implements IAppComponent.Controller {

  protected void checkToken(ControllerLoader loader) {
      loader.continueLoading();
  }

  protected void handleOnFailed(Class<?> clazz,
                                FailedResponseBean response,
                                String method,
                                Command commandNotFound) {
    RestFailedResponseHandler.builder()
                             .router(this.router)
                             .callingClass(clazz)
                             .callingMethod(method)
                             .eventBus(this.eventBus)
                             .failedResponseBean(response)
                             .lastExecutedHash(this.router.getLastExecutedHash())
                             .executeIfNotFound(commandNotFound)
                             .build()
                             .handle();
  }

}
