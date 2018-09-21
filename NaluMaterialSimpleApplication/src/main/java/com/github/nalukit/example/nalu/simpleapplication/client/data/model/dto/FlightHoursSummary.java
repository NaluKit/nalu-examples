package com.github.nalukit.example.nalu.simpleapplication.client.data.model.dto;

public interface FlightHoursSummary  {

	Integer getTotalTime();
	void setTotalTime(int value);
	Integer getRealTime();
	void setRealTime(int value);
	Integer getNocturnalTime();
	void setNocturnalTime(int value);
	Integer getDiurnalTime();
	void setDiurnalTime(int value);
	Integer getIfrTime();
	void setIfrTime(int value);		
	Integer getNvisTime();
	void setNvisTime(int value);
	Integer getDiurnalLandings();
	void setDiurnalLandings(int value);
	Integer getNocturnalLandings();
	void setNocturnalLandings(int value);
}