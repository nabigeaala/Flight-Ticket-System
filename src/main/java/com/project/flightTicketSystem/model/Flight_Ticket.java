package com.project.flightTicketSystem.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Flight_Ticket {
    
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name= "flight_id", referencedColumnName= "id", nullable= false)
	private Flight flight;
	
	@ManyToOne
	@JoinColumn(name="ticket_id", referencedColumnName="id")
	private Ticket ticket;

	
	
	public Flight_Ticket() {
		super();
	}

	public Flight_Ticket(Flight flight, Ticket ticket) {
		super();
		this.flight = flight;
		this.ticket = ticket;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
    
	@JsonBackReference(value= "flight_ticket")
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}
    
	@JsonBackReference(value= "ticket")
	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}
	
	
}
