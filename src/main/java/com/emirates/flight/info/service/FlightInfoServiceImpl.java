package com.emirates.flight.info.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emirates.flight.info.model.FlightInfoResponse;

@Service
public class FlightInfoServiceImpl implements FlightInfoService {

	private static final Logger logger = LoggerFactory.getLogger(FlightInfoServiceImpl.class);
	@Autowired
	MockDownStreamService mockDownStreamService;
	@Override
	public FlightInfoResponse getFlightNumber(String date, String departCode,String arrivalCode) throws InterruptedException {
	
		logger.info(FlightInfoServiceImpl.class + " getFlightNumber method called");
			
		return mockDownStreamService.getFlightNumber(date, departCode, arrivalCode);
	}

}
