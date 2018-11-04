package com.github.nalukit.example.nalu.simpleapplication.client.ui.dashboard;

import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.FlightHoursSummary;
import com.github.nalukit.nalu.client.component.IsComponent;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;

public interface IDashboardComponent
    extends IsComponent<IDashboardComponent.Controller, Widget> {

  void updateFlightHourSummaryTable(List<FlightHoursSummary> data);

  interface Controller
      extends IsComponent.Controller {
    void doRefresh();
  }

}
