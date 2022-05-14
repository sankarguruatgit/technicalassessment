package com.emirates.flight.info.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.flight.info.model.FlightInfoResponse;
import com.emirates.flight.info.model.FlightTariff;
import com.emirates.flight.info.service.FlightPriceEngineService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@RestController
@RequestMapping("/api/v1")
@JsonAutoDetect(getterVisibility=Visibility.NONE)
public class FlightPriceController {
	private static final Logger logger = LoggerFactory.getLogger(FlightPriceController.class);

	@Autowired
	FlightPriceEngineService priceEngineService;
	
	@GetMapping(value ="/price", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightTariff> getFligtPrice(@RequestParam(value = "date", defaultValue = "2022-05-12") String date,
                                           @RequestParam(value = "flightNumber", defaultValue = "EK101") String filghtNumber) 
                                           {
		logger.info("getFligtPrice method called");
		logger.info("Journey Date :"+ date);
		logger.info("Flight Number  :"+filghtNumber);
		
		long startTime = System.currentTimeMillis();
		FlightTariff flightTariff = priceEngineService.getFlightPrice(filghtNumber,date);
		long endTime = System.currentTimeMillis();
		long totalResponseTime = endTime - startTime;	
		
		logger.info(" Total SLA Response time in MilliSeconds :"+totalResponseTime);
	
		return new ResponseEntity<FlightTariff>(flightTariff, new HttpHeaders(), HttpStatus.OK);   	
   }
}
