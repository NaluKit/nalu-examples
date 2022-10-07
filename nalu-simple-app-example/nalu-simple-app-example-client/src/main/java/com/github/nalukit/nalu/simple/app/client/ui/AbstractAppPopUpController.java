package com.github.nalukit.nalu.simple.app.client.ui;

import com.github.nalukit.nalu.client.component.AbstractPopUpComponentController;
import com.github.nalukit.nalu.client.event.annotation.EventHandler;
import com.github.nalukit.nalu.simple.app.client.AppContext;
import com.github.nalukit.nalu.simple.app.client.event.HideAllEvent;
import com.github.nalukit.nalu.simple.app.client.util.Command;
import com.github.nalukit.nalu.simple.app.client.util.RestFailedResponseHandler;
import org.dominokit.rest.shared.request.FailedResponseBean;

public abstract class AbstractAppPopUpController<V extends IAppPopUpComponent<?>>
    extends AbstractPopUpComponentController<AppContext, V>
    implements IAppPopUpComponent.Controller {

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

  @EventHandler
  public void onHideAll(HideAllEvent event) {
    if (this.component.isOpen()) {
      this.component.unlock();
      this.component.hide();
    }
  }

}
