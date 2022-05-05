package com.github.nalukit.nalu.complex.app.client.ui.common.block.status;

import com.github.nalukit.nalu.client.component.IsBlockComponent;

public interface IStatusComponent
    extends IsBlockComponent<IStatusComponent.Controller> {

  void setMessage(String message);

  interface Controller
      extends IsBlockComponent.Controller {

  }

}
