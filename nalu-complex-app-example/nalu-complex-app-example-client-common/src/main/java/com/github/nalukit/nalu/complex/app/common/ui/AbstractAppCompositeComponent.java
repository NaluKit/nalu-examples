package com.github.nalukit.nalu.complex.app.common.ui;

import com.github.nalukit.nalu.client.component.AbstractCompositeComponent;
import elemental2.dom.HTMLElement;

public abstract class AbstractAppCompositeComponent<C extends IAppCompositeComponent.Controller>
    extends AbstractCompositeComponent<C, HTMLElement>
    implements IAppCompositeComponent<C> {

}
