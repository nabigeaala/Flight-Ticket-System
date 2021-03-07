package com.project.flightTicketSystem.model;

import java.io.Serializable;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Abstract_Flight implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5384066856485793855L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	private String name;
	
	private int fare;
	
	@Column(columnDefinition= "Time")
	private LocalTime departure_time;
	
	@Column(columnDefinition= "Time")
	private LocalTime destination_time;
	
	public Abstract_Flight(){
		
	}
    
	
	
	public Abstract_Flight(Long id) {
		super();
		this.id = id;
	}



	public Abstract_Flight(Long id, String name, int fare, LocalTime departure_time, LocalTime destination_time) {
		super();
		this.id = id;
		this.name = name;
		this.fare = fare;
		this.departure_time = departure_time;
		this.destination_time = destination_time;
	}

	public LocalTime getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(LocalTime departure_time) {
		this.departure_time = departure_time;
	}

	public LocalTime getDestination_time() {
		return destination_time;
	}

	public void setDestination_time(LocalTime destination_time) {
		this.destination_time = destination_time;
	}

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

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}
	
	
}   
