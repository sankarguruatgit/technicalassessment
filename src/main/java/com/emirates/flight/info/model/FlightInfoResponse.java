package com.emirates.flight.info.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class FlightInfoResponse {
    @Getter @Setter private String flightNumberDept;
    @Getter @Setter private String flightNumberArrival;
    
    public String getFlightNumberDept() {
		return flightNumberDept;
	}
	public void setFlightNumberDept(String flightNumberDept) {
		this.flightNumberDept = flightNumberDept;
	}
	
	public String getFlightNumberArrival() {
		return flightNumberArrival;
	}
	
	public void setFlightNumberArrival(String flightNumberArrival) {
		this.flightNumberArrival = flightNumberArrival;
	}
	
}
