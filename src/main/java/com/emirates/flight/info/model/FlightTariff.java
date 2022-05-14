package com.emirates.flight.info.model;


public class FlightTariff {

	private String flightNumber;
	private double price;
	private String date;
	private String price_currency="AED";
	
	public String getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPrice_currency() {
		return price_currency;
	}
	public void setPrice_currency(String price_currency) {
		this.price_currency = price_currency;
	}
		
}
