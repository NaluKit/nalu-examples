package com.github.nalukit.example.nalu.simpleapplication.client.handler;

import com.github.nalukit.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import com.github.nalukit.example.nalu.simpleapplication.client.event.StatusChangeEvent;
import com.github.nalukit.nalu.client.handler.AbstractHandler;
import com.github.nalukit.nalu.client.handler.annotation.Handler;
import elemental2.dom.DomGlobal;

@Handler
public class SimpleApplicationHandler01
    extends AbstractHandler<NaluSimpleApplicationContext> {

  public SimpleApplicationHandler01() {
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
