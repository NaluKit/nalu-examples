package com.github.nalukit.nalu.complex.app.common.ui;

import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import com.github.nalukit.nalu.complex.app.common.util.Command;
import com.github.nalukit.nalu.complex.app.common.util.RestFailedResponseHandler;
import elemental2.dom.HTMLElement;
import org.dominokit.rest.shared.request.FailedResponseBean;

public abstract class AbstractAppComponentController<V extends IAppComponent<?>>
    extends AbstractComponentController<AppContext, V, HTMLElement>
    implements IAppComponent.Controller {

  protected void checkToken(ControllerLoader loader) {
    if (!this.context.isLoggedIn()) {
      this.router.route(Routes.ROUTE_LOGON);
    } else {
      loader.continueLoading();
    }
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
