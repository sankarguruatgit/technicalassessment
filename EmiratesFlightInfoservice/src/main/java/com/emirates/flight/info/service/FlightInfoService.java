package com.emirates.flight.info.service;

import com.emirates.flight.info.model.FlightInfoResponse;


public interface FlightInfoService {
	
	public FlightInfoResponse getFlightNumber(String date, String departCode, String arrivalCode) throws InterruptedException ;

}
