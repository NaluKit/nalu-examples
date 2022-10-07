package com.github.nalukit.nalu.simple.app.client.ui;

import com.github.nalukit.nalu.client.component.IsCompositeComponent;
import elemental2.dom.HTMLElement;

public interface IAppCompositeComponent<C extends IAppCompositeComponent.Controller>
    extends IsCompositeComponent<C, HTMLElement> {

  interface Controller
      extends IsCompositeComponent.Controller {

  }

}
