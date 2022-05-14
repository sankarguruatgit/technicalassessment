package com.emirates.flight.info.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.emirates.flight.info.dao.FlightNumberRespository;
import com.emirates.flight.info.model.FlightNumberEntity;

@Service
public class FlightNumberService {

	private static final Logger logger = LoggerFactory.getLogger(AirPortCodeService.class);
	  @Autowired
	  FlightNumberRespository flightNumberRepo;
	  
	  // Retrieve all the static airport code from database (Table name =TBL_AIRPORT_CODE)
	  @Cacheable(value="FlIGHT_NUMBER_INVENTORY")   
	  public List<FlightNumberEntity> getAllFlightNumber()
	    {
		  logger.info("getAllFlightNumber callled");
	        List<FlightNumberEntity> flightnumberList = flightNumberRepo.findAll();
	  
	        if(flightnumberList.size() > 0) {
	        	 logger.info("flightnumberList is not empty");
	            return flightnumberList;
	        } else {
	        	 logger.info("flightnumberList is empty");
	            return new ArrayList<FlightNumberEntity>();
	        }
	    }
	  


		  
	  
}
