package com.emirates.flight.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="FlIGHT_NUMBER_INVENTORY")
public class FlightNumberEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="flight_number ")
    private String flightNumber ;

    @Column(name="avaialable_date_from")
    private String avialable_date_from;
    
    @Column(name="avaialable_date_to")
    private String avialable_date_to;


    @Column(name="airport_code", nullable=false)
    private String airport_code;
    
    
    
    public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFlightNumber() {
		return flightNumber;
	}



	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}



	public String getAvialable_date_from() {
		return avialable_date_from;
	}



	public void setAvialable_date_from(String avialable_date_from) {
		this.avialable_date_from = avialable_date_from;
	}



	public String getAvialable_date_to() {
		return avialable_date_to;
	}



	public void setAvialable_date_to(String avialable_date_to) {
		this.avialable_date_to = avialable_date_to;
	}



	public String getAirport_code() {
		return airport_code;
	}



	public void setAirport_code(String airport_code) {
		this.airport_code = airport_code;
	}



	public FlightNumberEntity(String flightNumber, String avialable_date_from,
			String avialable_date_to, String airport_code) {
		super();
		this.flightNumber = flightNumber;
		this.avialable_date_from = avialable_date_from;
		this.avialable_date_to = avialable_date_to;
		this.airport_code = airport_code;
	}
}
