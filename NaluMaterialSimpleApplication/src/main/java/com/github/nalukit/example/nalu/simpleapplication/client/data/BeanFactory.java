package com.github.nalukit.example.nalu.simpleapplication.client.data;

import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.FlightHoursSummary;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.autobean.shared.AutoBean;
import com.google.web.bindery.autobean.shared.AutoBeanFactory;

public interface BeanFactory
    extends AutoBeanFactory {
  BeanFactory INSTANCE = GWT.create(BeanFactory.class);

  AutoBean<FlightHoursSummary> flightHoursSummary();

}
