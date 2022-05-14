package com.emirates.flight.info.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.emirates.flight.info.cron.service.FlightNumberChangeScheduler;
import com.emirates.flight.info.dao.AirPortCodeRespository;
import com.emirates.flight.info.model.AirportCodeEntity;


@Service
public class AirPortCodeService {
	
	private static final Logger logger = LoggerFactory.getLogger(AirPortCodeService.class);
	  @Autowired
	  AirPortCodeRespository airPortCodeRespository;
	  
	  // Retrieve all the static airport code from database (Table name =TBL_AIRPORT_CODE)
	  @Cacheable(value="AIRPORT_CODE")   
	  public List<AirportCodeEntity> getAllAirPortCode()
	    {
		  logger.info("getAllAirPortCode callled");
	        List<AirportCodeEntity> codeList = airPortCodeRespository.findAll();
	  
	        if(codeList.size() > 0) {
	        	 logger.info("codeList is not empty");
	            return codeList;
	        } else {
	        	 logger.info("codeList is empty");
	            return new ArrayList<AirportCodeEntity>();
	        }
	    }
}
