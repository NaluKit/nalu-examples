package com.github.nalukit.example.nalureusecontroller.client.event;

import org.gwtproject.event.shared.Event;

public class SelectEvent
    extends Event<SelectEvent.StatusChangeHandler> {
  
  public static Type<StatusChangeHandler> TYPE = new Type<StatusChangeHandler>();
  
  private Select select;
  
  public SelectEvent(Select select) {
    super();
    
    this.select = select;
  }
  
  public Select getSelect() {
    return select;
  }
  
  @Override
  public Type<StatusChangeHandler> getAssociatedType() {
    return TYPE;
  }
  
  @Override
  protected void dispatch(StatusChangeHandler handler) {
    handler.onStatusChange(this);
  }
  
  public enum Select {
    SEARCH,
    LIST,
    DETAIL
  }
  
  
  
  public interface StatusChangeHandler {
    
    void onStatusChange(SelectEvent event);
    
  }
  
}
