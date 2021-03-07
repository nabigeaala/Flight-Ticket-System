package com.project.flightTicketSystem.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Airport extends ABSTRACT_AIRPORT{


	/**
	 * 
	 */
	private static final long serialVersionUID = -7066423144276947955L;

	public Airport() {
		super();
	}
	
	@OneToMany(cascade= CascadeType.ALL, orphanRemoval= true, mappedBy= "departureAirport", fetch= FetchType.LAZY)
	private List<Flight> departures;
	
	@OneToMany(cascade= CascadeType.ALL, orphanRemoval= true, mappedBy= "destinationAirport", fetch= FetchType.LAZY)
	private List<Flight> destinations;

    
	@JsonManagedReference(value="dep")
	public List<Flight> getDepartures() {
		return departures;
	}

	public void setDepartures(List<Flight> departures) {
		this.departures = departures;
	}
    
	@JsonManagedReference(value= "dest")
	public List<Flight> getDestinations() {
		return destinations;
	}

	public void setDestinations(List<Flight> destinations) {
		this.destinations = destinations;
	}
	
	public void addDeparture(Flight flight) {
		departures.add(flight);
		flight.setDeparture_airport(this);
	}
	
	public void removeDeparture(Flight flight) {
		departures.remove(flight);
		flight.setDeparture_airport(null);
	}
	
	public void addDestination(Flight flight) {
		destinations.add(flight);
		flight.setDestination_airport(this);
	}
	
	public void removeDestination(Flight flight) {
		destinations.add(flight);
		flight.setDestination_airport(null);
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj == this) 
			return true;
		if(!(obj instanceof Airport))
			return false;
		
		return ((Airport)(obj)).getId().equals(this.getId());
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	
	
}
