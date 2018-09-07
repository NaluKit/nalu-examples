package de.gishmo.gwt.example.nalu.simpleapplication.client.ui.dashboard;

import java.util.List;

import com.github.mvp4g.nalu.client.component.AbstractComponentController;
import com.github.mvp4g.nalu.client.component.annotation.Controller;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.user.client.ui.Widget;

import de.gishmo.gwt.example.nalu.simpleapplication.client.NaluSimpleApplicationContext;
import de.gishmo.gwt.example.nalu.simpleapplication.client.data.model.dto.FlightHoursSummary;
import gwt.material.design.client.ui.MaterialLoader;

@Controller(route = "/dashboard", selector = "content", componentInterface = IDashboardComponent.class, component = DashboardComponent.class)
public class DashboardController extends
        AbstractComponentController<NaluSimpleApplicationContext, IDashboardComponent, Widget> implements
        IDashboardComponent.Controller {

    public DashboardController() {
    }

    @Override
    public void start() {
        doRefresh();
    }
    
    @Override
    public void doRefresh() {
    	MaterialLoader.progress(true);
    	Scheduler.get().scheduleFixedDelay(() -> {
        	List<FlightHoursSummary> data = this.context.getFakedService().getFlightHoursSummaries();
        	DashboardController.this.component.updateFlightHourSummaryTable(data);
        	MaterialLoader.progress(false);
        	return false;
    	}, 1500);
    }
}
