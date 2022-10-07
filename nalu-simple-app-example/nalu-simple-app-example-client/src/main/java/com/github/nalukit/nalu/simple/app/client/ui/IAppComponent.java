package com.github.nalukit.nalu.simple.app.client.ui;

import com.github.nalukit.nalu.client.component.IsComponent;
import elemental2.dom.HTMLElement;

public interface IAppComponent<C extends IAppComponent.Controller>
    extends IsComponent<C, HTMLElement> {

  interface Controller
      extends IsComponent.Controller {

  }

}

