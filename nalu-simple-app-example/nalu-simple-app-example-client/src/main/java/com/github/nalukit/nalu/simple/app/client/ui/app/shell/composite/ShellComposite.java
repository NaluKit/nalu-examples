package com.github.nalukit.nalu.simple.app.client.ui.app.shell.composite;

import com.github.nalukit.nalu.client.component.annotation.CompositeController;
import com.github.nalukit.nalu.simple.app.client.ui.AbstractAppCompositeController;

@CompositeController(componentInterface = IShellCompositeComponent.class, component = ShellCompositeComponent.class)
public class ShellComposite
    extends AbstractAppCompositeController<IShellCompositeComponent>
    implements IShellCompositeComponent.Controller {

  public ShellComposite() {
  }

  @Override
  public void start() {
  }

  @Override
  public void stop() {
  }
}
