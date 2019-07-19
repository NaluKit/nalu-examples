package com.github.nalukit.example.nalu.simpleapplication.client.event;

import org.gwtproject.event.shared.Event;

public class StoreSearchCompositeEvent
    extends Event<StoreSearchCompositeEvent.StoreSearchCompositeHandler> {

  public static Type<StoreSearchCompositeEvent.StoreSearchCompositeHandler> TYPE = new Type<>();

  private boolean cached;

  public StoreSearchCompositeEvent(boolean cached) {
    super();

    this.cached = cached;
  }

  public boolean isCached() {
    return cached;
  }

  @Override
  public Type<StoreSearchCompositeEvent.StoreSearchCompositeHandler> getAssociatedType() {
    return TYPE;
  }

  @Override
  protected void dispatch(StoreSearchCompositeEvent.StoreSearchCompositeHandler handler) {
    handler.onStatusChange(this);
  }

  public interface StoreSearchCompositeHandler {

    void onStatusChange(StoreSearchCompositeEvent event);

  }

}
