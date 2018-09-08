package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.dashboard;

import java.util.List;

import com.github.mvp4g.nalu.client.component.IsComponent;
import com.google.gwt.user.client.ui.Widget;

import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.FlightHoursSummary;

public interface IDashboardComponent extends IsComponent<IDashboardComponent.Controller, Widget> {

	void updateFlightHourSummaryTable(List<FlightHoursSummary> data);

	interface Controller extends IsComponent.Controller {
		void doRefresh();
	}

}
