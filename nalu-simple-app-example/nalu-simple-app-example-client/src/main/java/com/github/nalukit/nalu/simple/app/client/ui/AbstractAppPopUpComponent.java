package com.github.nalukit.nalu.simple.app.client.ui;

import com.github.nalukit.nalu.client.component.AbstractPopUpComponent;

public abstract class AbstractAppPopUpComponent<C extends IAppPopUpComponent.Controller>
    extends AbstractPopUpComponent<C>
    implements IAppPopUpComponent<C> {

  @Override
  public void unlock() {
    // if the popup is using a loader, override the method!
  }

}
