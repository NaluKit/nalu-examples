package com.github.nalukit.example.nalu.simpleapplication.client.ui.onroutemap;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.component.annotation.Controller;
import com.google.gwt.user.client.ui.Widget;

@Controller(route = "/application/onroutemap",
            selector = "content",
            componentInterface = IOnRouteMapComponent.class,
            component = OnRouteMapComponent.class)
public class OnRouteMapController
    extends AbstractComponentController<NaluSimpleApplicationContext, IOnRouteMapComponent, Widget>
    implements IOnRouteMapComponent.Controller {

  public OnRouteMapController() {
  }

  @Override
  public void start() {
  }
}
