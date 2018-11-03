package com.github.nalukit.example.nalu.loginapplication.client.handler;

import com.github.nalukit.example.nalu.loginapplication.client.NaluLoginApplicationContext;
import com.github.nalukit.example.nalu.loginapplication.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.client.handler.AbstractHandler;
import com.github.nalukit.nalu.client.handler.annotation.Handler;
import elemental2.dom.DomGlobal;

@Handler
public class ApplicationHandler01
    extends AbstractHandler<NaluLoginApplicationContext> {

  public ApplicationHandler01() {
  }

  @Override
  public void bind() {
    this.eventBus.addHandler(StatusChangeEvent.TYPE,
                             e -> {
                               // Stupid idea! It should only show, that the event was catched by the handler!
                               DomGlobal.window.alert("new Status:" + e.getStatus());
                             });
  }
}
