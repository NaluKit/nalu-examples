package com.github.nalukit.nalu.complex.app.client.ui.common.block.version;

import com.github.nalukit.nalu.client.component.IsBlockComponent;

public interface IVersionComponent
    extends IsBlockComponent<IVersionComponent.Controller> {

  interface Controller
      extends IsBlockComponent.Controller {

    String doGetVersion();

  }

}
