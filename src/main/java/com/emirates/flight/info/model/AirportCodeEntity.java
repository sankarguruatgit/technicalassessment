package com.emirates.flight.info.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="AIRPORT_CODE")
public class AirportCodeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="city ")
    @Getter
    @Setter 
    private String city ;

    @Column(name="country")
    @Getter 
    @Setter 
    private String country;

    @Getter 
    @Setter 
    @Column(name="airport_code", nullable=false)
    private String airport_code;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getAirport_code() {
		return airport_code;
	}

	public void setAirport_code(String airport_code) {
		this.airport_code = airport_code;
	}
    
    
}
