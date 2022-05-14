package com.emirates.flight.info.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emirates.flight.info.model.FlightNumberEntity;

@Repository
@Transactional
public interface FlightNumberRespository extends 
JpaRepository<FlightNumberEntity, Long>{

	@Query(value = "SELECT FLIGHT_NUMBER FROM FLIGHT_NUMBER_INVENTORY  WHERE AIRPORT_CODE=?1 AND ?2 BETWEEN avaialable_date_from AND avaialable_date_to",
			  nativeQuery = true)
	  public List<String> findFlightNumber(String airport_code, String date);
	
	   @Modifying
	   @Query(value = "insert into FLIGHT_NUMBER_INVENTORY (flight_number,airport_code,avaialable_date_from,avaialable_date_to) VALUES (?1, ?2,?3,?4)", nativeQuery = true)
	   void addFlightNumberInventory(String flightNumber,String airport_code, String avaialable_date_from, String avaialable_date_to);
	
	   @Modifying
	   @Query(value = "update FLIGHT_NUMBER_INVENTORY set FLIGHT_NUMBER=?1 WHERE AIRPORT_CODE=?2", nativeQuery = true)
	   void changeFlightNumber(String flightNumber,String airport_code);
	   
}
