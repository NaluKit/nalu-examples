package com.github.nalukit.example.nalu.simpleapplication.client.handler;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.nalu.client.event.NaluErrorEvent;
import com.github.nalukit.nalu.client.handler.AbstractHandler;
import com.github.nalukit.nalu.client.handler.annotation.Handler;
import com.google.gwt.core.client.GWT;

@Handler
public class ErrorHandler
    extends AbstractHandler<NaluSimpleApplicationContext> {

  public ErrorHandler() {
  }

  @Override
  public void bind() {
    this.eventBus.addHandler(NaluErrorEvent.TYPE,
                             e -> {
                               this.context.setErrorInfo(e.getErrorInfo());
                               this.router.route("/error/show");
                             });
  }

}
