package com.github.nalukit.example.nalu.simpleapplication.client.ui.dashboard;

import java.util.List;

import com.github.nalukit.nalu.client.component.AbstractComponent;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Widget;

import com.github.nalukit.example.nalu.simpleapplication.client.cell.HoursMinutesCell;
import com.github.nalukit.example.nalu.simpleapplication.client.cell.IntegerCell;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.FlightHoursSummary;
import gwt.material.design.client.ui.animate.MaterialAnimation;
import gwt.material.design.client.ui.animate.Transition;
import gwt.material.design.client.ui.table.MaterialDataTable;
import gwt.material.design.client.ui.table.cell.Column;

public class DashboardComponent extends AbstractComponent<IDashboardComponent.Controller, Widget> implements
        IDashboardComponent {

    private static DashboardComponentUiBinder uiBinder = GWT.create(DashboardComponentUiBinder.class);

    interface DashboardComponentUiBinder extends UiBinder<Widget, DashboardComponent> {
    }

    @UiField
    MaterialDataTable<FlightHoursSummary> last28SummaryTable;
    
    private MaterialAnimation animation;

    @UiHandler("refresh")
    void onClick(ClickEvent e) {
    	this.getController().doRefresh();
    }

    @Override
    public void render() {
        Widget widget = uiBinder.createAndBindUi(this);
        
        animation = new MaterialAnimation();
        animation.setDelay(0);
        animation.setDuration(1000);
        animation.setInfinite(false);
        animation.setTransition(Transition.JELLO);
        
        initLast28SummaryTable();
        last28SummaryTable.setHeight((Window.getClientHeight())+ "px");

        initElement(widget);
    }

    private void initLast28SummaryTable() {
        last28SummaryTable.getTableTitle().setText("Flighthours summaries for last 28 days.");

        last28SummaryTable.addColumn(new Column<FlightHoursSummary, Integer>(new HoursMinutesCell()) {
            @Override
            public Integer getValue(FlightHoursSummary object) {
                return object.getTotalTime();
            }
        }, "T. Total");

        last28SummaryTable.addColumn(new Column<FlightHoursSummary, Integer>(new HoursMinutesCell()) {
            @Override
            public Integer getValue(FlightHoursSummary object) {
                return object.getRealTime();
            }
        }, "T. Effective");

        last28SummaryTable.addColumn(new Column<FlightHoursSummary, Integer>(new HoursMinutesCell()) {
            @Override
            public Integer getValue(FlightHoursSummary object) {
                return object.getDiurnalTime();
            }
        }, "T. Diurnal");

        last28SummaryTable.addColumn(new Column<FlightHoursSummary, Integer>(new HoursMinutesCell()) {
            @Override
            public Integer getValue(FlightHoursSummary object) {
                return object.getNocturnalTime();
            }
        }, "T. Nocturnal");

        last28SummaryTable.addColumn(new Column<FlightHoursSummary, Integer>(new HoursMinutesCell()) {
            @Override
            public Integer getValue(FlightHoursSummary object) {
                return object.getIfrTime();
            }
        }, "T. IFR");

        last28SummaryTable.addColumn(new Column<FlightHoursSummary, Integer>(new HoursMinutesCell()) {
            @Override
            public Integer getValue(FlightHoursSummary object) {
                return object.getNvisTime();
            }
        }, "T. NVIS");

        last28SummaryTable.addColumn(new Column<FlightHoursSummary, Integer>(new IntegerCell()) {
            @Override
            public Integer getValue(FlightHoursSummary object) {
                return object.getDiurnalLandings();
            }
        }, "Diurnal landings");

        last28SummaryTable.addColumn(new Column<FlightHoursSummary, Integer>(new IntegerCell()) {
            @Override
            public Integer getValue(FlightHoursSummary object) {
                return object.getNocturnalLandings();
            }
        }, "Nocturnal landings");
    }

	@Override
	public void updateFlightHourSummaryTable(List<FlightHoursSummary> data) {
        last28SummaryTable.setRowData(0, data);
        animation.animate(last28SummaryTable);
	}
}
