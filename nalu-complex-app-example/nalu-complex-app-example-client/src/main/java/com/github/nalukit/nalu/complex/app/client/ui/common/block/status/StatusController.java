package com.github.nalukit.nalu.complex.app.client.ui.common.block.status;

import com.github.nalukit.nalu.client.component.AbstractBlockComponentController;
import com.github.nalukit.nalu.client.component.annotation.BlockController;
import com.github.nalukit.nalu.client.event.annotation.EventHandler;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import com.github.nalukit.nalu.complex.app.common.event.StatusChangeEvent;

@BlockController(name = "blockStatus",
                 condition = StatusCondition.class,
                 component = StatusComponent.class,
                 componentInterface = IStatusComponent.class)
public class StatusController
    extends AbstractBlockComponentController<AppContext, IStatusComponent>
    implements IStatusComponent.Controller {

  public StatusController() {
  }

  @EventHandler
  public void onStatusChangeEvent(StatusChangeEvent event) {
    this.component.setMessage(event.getStatus());
  }
}
