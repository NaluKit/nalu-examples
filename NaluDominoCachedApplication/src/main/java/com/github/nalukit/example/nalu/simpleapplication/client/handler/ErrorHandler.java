package com.github.nalukit.example.nalu.simpleapplication.client.handler;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.component.event.ShowPopUpEvent;
import com.github.nalukit.nalu.client.event.NaluErrorEvent;
import com.github.nalukit.nalu.client.handler.AbstractHandler;
import com.github.nalukit.nalu.client.handler.annotation.Handler;

@Handler
public class ErrorHandler
    extends AbstractHandler<NaluSimpleApplicationContext> {

  public ErrorHandler() {
  }

  @Override
  public void bind() {
    this.eventBus.addHandler(NaluErrorEvent.TYPE,
                             e -> {
                               eventBus.fireEvent(ShowPopUpEvent.show("ErrorPresenter")
                                                                .using("message",
                                                                       e.getMessage())
                                                                .using("route",
                                                                       e.getRoute()));
                             });
  }

}
