package com.github.nalukit.nalu.complex.app.client.tracker;

import com.github.nalukit.nalu.client.tracker.AbstractTracker;
import com.github.nalukit.nalu.complex.app.common.AppContext;
import com.github.nalukit.nalu.complex.app.common.event.UpdateClockEvent;

public class UpdateClockTracker
    extends AbstractTracker<AppContext> {

  @Override
  public void track(String route,
                    String... params) {
    this.eventBus.fireEvent(new UpdateClockEvent());
  }

}
