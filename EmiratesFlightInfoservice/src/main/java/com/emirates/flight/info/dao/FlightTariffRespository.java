package com.emirates.flight.info.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.emirates.flight.info.model.FlightTariffEntity;

@Repository
@Transactional
public interface FlightTariffRespository extends
JpaRepository<FlightTariffEntity, Long>{


	@Query(value = "SELECT flight_tariff FROM FLIGHT_TARIFF  WHERE flight_number=?1 AND ?2 BETWEEN effective_date_from AND effective_date_to",
			  nativeQuery = true)
	  public List<Double> getFlightTariff(String flightNumber, String date);
}
