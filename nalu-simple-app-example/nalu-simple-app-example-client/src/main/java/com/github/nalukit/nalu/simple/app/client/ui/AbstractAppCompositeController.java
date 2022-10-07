package com.github.nalukit.nalu.complex.app.common.ui;

import com.github.nalukit.nalu.client.component.AbstractCompositeController;
import com.github.nalukit.nalu.client.component.IsCompositeComponent;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import com.github.nalukit.nalu.complex.app.common.util.Command;
import com.github.nalukit.nalu.complex.app.common.util.RestFailedResponseHandler;
import elemental2.dom.HTMLElement;
import org.dominokit.rest.shared.request.FailedResponseBean;

public abstract class AbstractAppCompositeController<V extends IsCompositeComponent<?, HTMLElement>>
    extends AbstractCompositeController<AppContext, V, HTMLElement>
    implements IAppCompositeComponent.Controller {

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
