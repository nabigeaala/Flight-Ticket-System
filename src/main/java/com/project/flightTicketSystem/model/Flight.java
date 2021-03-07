package com.project.flightTicketSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Flight extends Abstract_Flight{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1079962996408178612L;

	public Flight() {
		super();
	}	
		
	public Flight(Long id) {
		super(id);
	}

	@ManyToOne
	@JoinColumn(name= "departure_airport_id",nullable= false, referencedColumnName= "id")
	private Airport departureAirport;
	
	@ManyToOne
	@JoinColumn(name= "destination_airport_id",nullable= false, referencedColumnName= "id")
	private Airport destinationAirport;
	
	@OneToMany(cascade= CascadeType.ALL, orphanRemoval= true, fetch= FetchType.LAZY, mappedBy= "flight")
	private List<Flight_Ticket> flighttickets;
	
	@JsonManagedReference(value= "flight_ticket")
	public List<Flight_Ticket> getFlighttickets() {
		return flighttickets;
	}
    
	public void setFlighttickets(List<Flight_Ticket> flighttickets) {
		this.flighttickets = flighttickets;
	}
    
    
	@JsonBackReference(value= "dep")
	public Airport getDeparture_airport() {
		return departureAirport;
	}

	public void setDeparture_airport(Airport departure_airport) {
		this.departureAirport = departure_airport;
	}
    
	@JsonBackReference(value= "dest")
	public Airport getDestination_airport() {
		return destinationAirport;
	}

	public void setDestination_airport(Airport destination_airport) {
		this.destinationAirport = destination_airport;
	}
	
	public void addFlightticket(Flight_Ticket flight_ticket) {
		flighttickets.add(flight_ticket);
		flight_ticket.setFlight(this);
	}
	
	public void removeFlightticket(Flight_Ticket flight_tickets) {
		flighttickets.remove(flight_tickets);
		flight_tickets.setFlight(null);
	}

	@Override
	public boolean equals(Object obj) {
		if(obj == this)
			return true;
		
		if(!(obj instanceof Flight))
			return false;
		
		return ((Flight)(obj)).getId().equals(this.getId());
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}
	
	
	
}
