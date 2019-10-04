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
                               // this also works to get the error information to the error handler.
                               // This implementation has the advantage that no changes on the context are needed.
                               eventBus.fireEvent(ShowPopUpEvent.show("ErrorPresenter")
                                                                .using("message",
                                                                       e.getMessage())
                                                                .using("route",
                                                                       e.getRoute()));
                             });
  }

}
