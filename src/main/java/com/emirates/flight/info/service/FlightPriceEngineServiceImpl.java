package com.emirates.flight.info.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emirates.flight.info.dao.FlightTariffRespository;
import com.emirates.flight.info.model.FlightTariff;

@Service
public class FlightPriceEngineServiceImpl implements FlightPriceEngineService {
	
	@Autowired
	FlightTariffRespository tariffRepo;
	private static final Logger logger = LoggerFactory.getLogger(FlightInfoServiceImpl.class);
	@Override
	public FlightTariff getFlightPrice(String flightNumber,String date) {
		// TODO Auto-generated method stub
		logger.info(" ***** getFlightPrice called : ******");
		FlightTariff price=new FlightTariff();
		price.setDate(date);
		price.setFlightNumber(flightNumber);
		price.setPrice_currency(price.getPrice_currency());
		
		if(!tariffRepo.getFlightTariff(flightNumber, date).isEmpty())
		 	price.setPrice(tariffRepo.getFlightTariff(flightNumber, date).get(0));

		return price;
	}

}
