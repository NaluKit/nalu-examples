package com.github.nalukit.nalu.simple.app.client.ui;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import elemental2.dom.HTMLElement;

public abstract class AbstractAppComponent<C extends IAppComponent.Controller>
    extends AbstractComponent<C, HTMLElement>
    implements IAppComponent<C> {

}
