package com.emirates.flight.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Entity
@Table(name="FLIGHT_TARIFF")
public class FlightTariffEntity {
	
		@Id
	 	@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name="flight_number ")
	    private String flightNumber ;
	    
	    @Column(name="flight_tariff ")
	    private double flight_tariff ;
	    
	    @Column(name="effective_date_from")
	    private String effective_date_from;
	    
	    @Column(name="effective_date_to")
	    private String effective_date_to;

		public String getFlightNumber() {
			return flightNumber;
		}

		public void setFlightNumber(String flightNumber) {
			this.flightNumber = flightNumber;
		}

		public double getFlight_tariff() {
			return flight_tariff;
		}

		public void setFlight_tariff(double flight_tariff) {
			this.flight_tariff = flight_tariff;
		}

		public String getEffective_date_from() {
			return effective_date_from;
		}

		public void setEffective_date_from(String effective_date_from) {
			this.effective_date_from = effective_date_from;
		}

		public String getEffective_date_to() {
			return effective_date_to;
		}

		public void setEffective_date_to(String effective_date_to) {
			this.effective_date_to = effective_date_to;
		}

		public FlightTariffEntity(String flightNumber, double flight_tariff,
				String effective_date_from, String effective_date_to) {
			super();
			this.flightNumber = flightNumber;
			this.flight_tariff = flight_tariff;
			this.effective_date_from = effective_date_from;
			this.effective_date_to = effective_date_to;
		}
	    
	    
}		
