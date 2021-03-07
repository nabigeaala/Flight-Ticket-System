package com.project.flightTicketSystem.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class ABSTRACT_AIRPORT implements Serializable{
     
	/**
	 * 
	 */
	private static final long serialVersionUID = 3980422909042746776L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	public ABSTRACT_AIRPORT() {
		
	}



	public ABSTRACT_AIRPORT(Long id, String name, String city, String airport_code, String country) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.airport_code = airport_code;
		this.country = country;
	}

	@Column(nullable= false)
	private String name;
	
	@Column(nullable= false)
	private String city;
	
	@Column(nullable= false)
	private String airport_code;
	
	@Column(nullable= false)
	private String country;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAirport_code() {
		return airport_code;
	}

	public void setAirport_code(String airport_code) {
		this.airport_code = airport_code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
