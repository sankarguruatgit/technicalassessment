package com.emirates.flight.info.cron.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.emirates.flight.info.dao.FlightNumberRespository;
import com.emirates.flight.info.model.AirportCodeEntity;
import com.emirates.flight.info.service.AirPortCodeService;
import com.emirates.flight.info.service.MockDownStreamService;

@Component
@PropertySource("classpath:application.properties")
public class FlightNumberChangeScheduler {

	@Autowired
	AirPortCodeService codeService;
	@Autowired
	FlightNumberRespository flightRepo;
	
	private static final Logger logger = LoggerFactory.getLogger(FlightNumberChangeScheduler.class);
	// this corn job will be executed every 24 hours to create random flight number
	@Scheduled(cron = "${flight.cron.expression}")
    public void changeFlightNumber() {

      	logger.info("changeFlightNumber method called");

      	List<AirportCodeEntity> airportCodeList= codeService.getAllAirPortCode();
      	 for (final AirportCodeEntity codeList : airportCodeList) {
      		logger.info("Airport Code " + codeList.getAirport_code());
      		flightRepo.changeFlightNumber(generateFlightNumber(), codeList.getAirport_code());
      	 }
      	
   }
	private String generateFlightNumber(){
		
	 	Random random = new Random();
    	int randomNumber = random.nextInt(900) + 100;
    	logger.info("Random Emirates Flight Number " + "EK"+randomNumber);
    	return "EK"+randomNumber;
    	
	}
 
}
