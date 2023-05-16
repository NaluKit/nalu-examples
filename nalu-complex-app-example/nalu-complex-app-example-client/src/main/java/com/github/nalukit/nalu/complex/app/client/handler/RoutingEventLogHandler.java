package com.github.nalukit.nalu.complex.app.client.handler;

import com.github.nalukit.nalu.client.application.event.LogEvent;
import com.github.nalukit.nalu.client.event.RouterStateEvent;
import com.github.nalukit.nalu.client.event.annotation.EventHandler;
import com.github.nalukit.nalu.client.handler.AbstractHandler;
import com.github.nalukit.nalu.client.handler.annotation.Handler;
import com.github.nalukit.nalu.complex.app.common.AppContext;

@Handler
public class RoutingEventLogHandler
    extends AbstractHandler<AppContext> {

  public RoutingEventLogHandler() {
  }

  @EventHandler
  public void onRouteStateEvent(RouterStateEvent event) {
    this.eventBus.fireEvent(LogEvent.create()
                                    .addMessage("RouteStateEvent: --> " +
                                                event.getState() +
                                                " for route: " +
                                                event.getRoute()));
  }
}
