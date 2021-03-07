package com.project.flightTicketSystem.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@Entity
public class Ticket {
    
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	//@Column(nullable= false)
	private String passenger_name;
	
	//@Column(nullable= false)
	private int age;
	
	//@Column(nullable= false)
	private Long contactNumber;
	
	private String email;
	
	private Date timeOfBooking;
	
	@PrePersist
	public void onCreate() {
		timeOfBooking= new Date();
	}
	
	@Transient
	@JsonSerialize
	@JsonDeserialize
	private int fare;
	
	@Transient
	@JsonSerialize
	@JsonDeserialize
	private List<ABSTRACT_AIRPORT> airports;

	public List<ABSTRACT_AIRPORT> getAirports() {
		return airports;
	}

	public void setAirports(List<ABSTRACT_AIRPORT> airports) {
		this.airports = airports;
	}

	public Long getId() {
		return id;
	}
    
	public Ticket() {
		super();
	}

	public Ticket(Long id) {
		super();
		this.id = id;
	}

	@OneToMany(cascade= CascadeType.ALL, fetch= FetchType.LAZY, orphanRemoval= true, mappedBy= "ticket")
	private List<Flight_Ticket> flighttickets;
	
	@JsonManagedReference(value= "ticket")
	public List<Flight_Ticket> getFlighttickets() {
		return flighttickets;
	}

	public void setFlighttickets(List<Flight_Ticket> flightTickets) {
		this.flighttickets = flightTickets;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassenger_name() {
		return passenger_name;
	}

	public void setPassenger_name(String passenger_name) {
		this.passenger_name = passenger_name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getContact_number() {
		return contactNumber;
	}

	public void setContact_number(Long contact_number) {
		this.contactNumber = contact_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getTime_of_booking() {
		return timeOfBooking;
	}

	public void setTime_of_booking(Date time_of_booking) {
		this.timeOfBooking = time_of_booking;
	}

	public int getFare() {
		return fare;
	}

	public void setFare(int fare) {
		this.fare = fare;
	}

	
	public Ticket addFlightticket(Flight_Ticket flight_ticket) {
		flighttickets.add(flight_ticket);
		flight_ticket.setTicket(this);
		return this;
	}
	
	public Ticket removeFlightticket(Flight_Ticket flight_ticket) {
		flighttickets.remove(flight_ticket);
		flight_ticket.setTicket(null);
		return this;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Ticket)
			return true;
		
		return ((Ticket)(obj)).getId().equals(this.getId());
	}

	
}
