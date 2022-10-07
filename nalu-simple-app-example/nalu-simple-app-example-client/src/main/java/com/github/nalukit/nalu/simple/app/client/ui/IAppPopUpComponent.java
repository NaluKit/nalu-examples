package com.github.nalukit.nalu.complex.app.common.ui;

import com.github.nalukit.nalu.client.component.IsPopUpComponent;

public interface

IAppPopUpComponent<C extends IAppPopUpComponent.Controller>
    extends IsPopUpComponent<C> {

  boolean isOpen();

  void unlock();

  interface Controller
      extends IsPopUpComponent.Controller {

  }

}
