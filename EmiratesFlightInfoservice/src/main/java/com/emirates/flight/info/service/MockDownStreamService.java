package com.emirates.flight.info.service;

import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.emirates.flight.info.dao.FlightNumberRespository;
import com.emirates.flight.info.exception.RecordNotFoundException;
import com.emirates.flight.info.model.FlightInfoResponse;

@Service
public class MockDownStreamService {
	
	private static final Logger logger = LoggerFactory.getLogger(MockDownStreamService.class);
	@Value("${flight.no.record.response}")
	private String noRecordRespContent;
	@Autowired
	FlightNumberRespository flightRepo;
	
	public static HashMap<String,String> flightNumberMap = new HashMap<>();
		
	public FlightInfoResponse getFlightNumber(String date, String departCode,String arrivalCode) throws InterruptedException {
		
		return mockDownStreamService1(date,departCode,arrivalCode);
			
	}
	
	private FlightInfoResponse mockDownStreamService1(String date, String departCode,String arrivalCode) throws InterruptedException{
		Thread.sleep(200);	
		return mockDownStreamService2(date,departCode,arrivalCode);
	}
	private FlightInfoResponse mockDownStreamService2(String date, String departCode,String arrivalCode) throws InterruptedException{
		Thread.sleep(200);	
		return mockDownStreamService3(date,departCode,arrivalCode);
	
	}
	private FlightInfoResponse mockDownStreamService3(String date, String departCode,String arrivalCode) throws InterruptedException{
		Thread.sleep(200);	
		return mockDownStreamService4(date,departCode,arrivalCode);
	}
	private FlightInfoResponse mockDownStreamService4(String date, String departCode,String arrivalCode) throws InterruptedException{
			Thread.sleep(150);	
		return mockDownStreamService5(date,departCode,arrivalCode);
	}
	private FlightInfoResponse mockDownStreamService5(String date, String departCode,String arrivalCode) throws InterruptedException{
	
		FlightInfoResponse flightInforResponse = new FlightInfoResponse();
	try{
		List<String> flightNumberDept = flightRepo.findFlightNumber(departCode, date);
		List<String> flightNumberArrival = flightRepo.findFlightNumber(arrivalCode, date);
		if( ! flightNumberDept.isEmpty()) {
			flightInforResponse.setFlightNumberDept(flightNumberDept.get(0).toString());
			}
		else {
			flightInforResponse.setFlightNumberDept(noRecordRespContent);
			}
		if( !flightNumberArrival.isEmpty()){
			flightInforResponse.setFlightNumberArrival(flightNumberArrival.get(0).toString());
		} else {
			flightInforResponse.setFlightNumberArrival(noRecordRespContent);
		}
		} catch (Exception ex){
			ex.printStackTrace();
		}
		
		logger.info("Departure Flight Number :"+flightInforResponse.getFlightNumberDept());
		logger.info("Arrival Flight Number :"+flightInforResponse.getFlightNumberArrival());
		
		return flightInforResponse;	
	
	}
}
