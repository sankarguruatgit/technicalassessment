package com.emirates.flight.info.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emirates.flight.info.model.FlightInfoResponse;
import com.emirates.flight.info.service.FlightInfoService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@RestController
@RequestMapping("/api/v1")
@JsonAutoDetect(getterVisibility=Visibility.NONE)
@PropertySource("classpath:application.properties")
public class FlightInfoController {

	private static final Logger logger = LoggerFactory.getLogger(FlightInfoController.class);

	@Autowired
	FlightInfoService flightInfoService;
	
	@Value("${flight.no.record.response}")
	private String noRecordRespContent;
	
	@GetMapping(value ="/flight", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FlightInfoResponse> getFligtInfo(@RequestParam(value = "date", defaultValue = "2022-05-12") String date,
                                           @RequestParam(value = "airPortCodeDept", defaultValue = "DXB") String departCode,
                                           @RequestParam(value = "airPortCodeArrival", defaultValue = "DUB") String arrivalCode) throws InterruptedException {
		logger.info("getFligtInfo method called");
		logger.info("Journey Date :"+ date);
		logger.info("Departure Airport Code :"+departCode);
		logger.info("Arrival Airport Code :"+arrivalCode);
		FlightInfoResponse flightInfoResponse=null;
		long startTime = System.currentTimeMillis();
		try{
			flightInfoResponse = flightInfoService.getFlightNumber(date, departCode, arrivalCode);
		long endTime = System.currentTimeMillis();
		long totalResponseTime = endTime - startTime;	
		logger.info(" Total SLA Response time in MilliSeconds :"+totalResponseTime);
			if(!flightInfoResponse.getFlightNumberArrival().equals(noRecordRespContent)) {
				return new ResponseEntity<FlightInfoResponse>(flightInfoResponse, new HttpHeaders(), HttpStatus.OK);
			} else {
				logger.info("Not Found");
				return new ResponseEntity<FlightInfoResponse>(flightInfoResponse, new HttpHeaders(), HttpStatus.NOT_FOUND);
			}
		
		} catch(Exception ex){
			 return new ResponseEntity<>(flightInfoResponse, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	 }
}
