package com.emirates.flight.info.service;

import com.emirates.flight.info.model.FlightTariff;


public interface FlightPriceEngineService {

	public FlightTariff getFlightPrice(String flightNumber,String date);
}
