/*
 * Copyright (c) 2018 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 *
 */

package com.github.nalukit.example.nalu.simpleapplication.client.data.service;

import java.util.ArrayList;
import java.util.List;

import com.github.nalukit.example.nalu.simpleapplication.client.data.BeanFactory;
import com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto.FlightHoursSummary;

public class FakedService {

	private ArrayList<FlightHoursSummary> summaries = new ArrayList<>();

	public FakedService() {
		this.init();
	}

	private void init() {
		this.summaries = new ArrayList<>();
		for (int i = 0; i < 20; ++i) {
			summaries.add(createFlightHoursSummary(i));
		}
	}

	private FlightHoursSummary createFlightHoursSummary(int i) {

		FlightHoursSummary summary = BeanFactory.INSTANCE.flightHoursSummary().as();
		summary.setTotalTime((int) ((double) i * 11.25));
		summary.setRealTime((int) ((double) i * 7.64));
		summary.setNvisTime((int) ((double) i * 8.21));
		summary.setIfrTime((int) ((double) i * 2.33));
		summary.setDiurnalLandings(2);
		summary.setNocturnalTime((int) ((double) i * 3.2));
		summary.setNocturnalLandings(1);
		return summary;
	}

	public List<FlightHoursSummary> getFlightHoursSummaries() {
		return summaries;
	}

}
