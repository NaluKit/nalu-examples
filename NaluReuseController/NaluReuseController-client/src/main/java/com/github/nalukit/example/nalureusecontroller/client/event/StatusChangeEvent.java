package com.github.nalukit.example.nalureusecontroller.client.event;

import org.gwtproject.event.shared.Event;

public class StatusChangeEvent
    extends Event<StatusChangeEvent.StatusChangeHandler> {
  
  public static Type<StatusChangeHandler> TYPE = new Type<StatusChangeHandler>();
  
  private String status;
  
  public StatusChangeEvent(String status) {
    super();
    
    this.status = status;
  }
  
  public String getStatus() {
    return status;
  }
  
  @Override
  public Type<StatusChangeHandler> getAssociatedType() {
    return TYPE;
  }
  
  @Override
  protected void dispatch(StatusChangeHandler handler) {
    handler.onStatusChange(this);
  }
  
  public interface StatusChangeHandler {
    
    void onStatusChange(StatusChangeEvent event);
    
  }
  
}
