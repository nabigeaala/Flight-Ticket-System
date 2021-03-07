package com.project.flightTicketSystem.model;

import java.util.List;

public class Root {
     private List<ABSTRACT_AIRPORT> airports;
     private List<Abstract_Flight> flights;
     private int totalFare;
     
     public Root(){
    	 
     }
	
	public Root(List<ABSTRACT_AIRPORT> airports, List<Abstract_Flight> flights, int totalFare) {
		super();
		this.airports = airports;
		this.flights = flights;
		this.totalFare = totalFare;
	}

	public List<ABSTRACT_AIRPORT> getAirports() {
		return airports;
	}
	
	public void setAirports(List<ABSTRACT_AIRPORT> airports) {
		this.airports = airports;
	}
	
	public int getTotalFare() {
		return totalFare;
	}
	
	public void setTotalFare(int totalFare) {
		this.totalFare = totalFare;
	}

	public List<Abstract_Flight> getFlights() {
		return flights;
	}

	public void setFlights(List<Abstract_Flight> flights) {
		this.flights = flights;
	}
	
}
