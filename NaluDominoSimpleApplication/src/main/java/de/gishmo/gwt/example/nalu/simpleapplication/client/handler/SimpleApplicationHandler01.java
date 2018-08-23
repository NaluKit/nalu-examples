package de.gishmo.gwt.example.nalu.simpleapplication.client.handler;

import com.github.mvp4g.nalu.client.handler.AbstractHandler;
import com.github.mvp4g.nalu.client.handler.annotation.Handler;
import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.event.StatusChangeEvent;
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
