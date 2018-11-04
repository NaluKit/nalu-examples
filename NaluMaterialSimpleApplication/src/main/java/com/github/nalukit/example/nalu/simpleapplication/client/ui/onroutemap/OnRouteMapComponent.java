package com.github.nalukit.example.nalu.simpleapplication.client.ui.onroutemap;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Widget;

public class OnRouteMapComponent
    extends AbstractComponent<IOnRouteMapComponent.Controller, Widget>
    implements IOnRouteMapComponent {

  private static OnRouteMapComponentUiBinder uiBinder = GWT.create(OnRouteMapComponentUiBinder.class);

  @Override
  public void render() {
    Widget widget = uiBinder.createAndBindUi(this);
    initElement(widget);
  }

  interface OnRouteMapComponentUiBinder
      extends UiBinder<Widget, OnRouteMapComponent> {
  }

}
