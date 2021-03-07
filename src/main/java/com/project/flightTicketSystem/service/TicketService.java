package com.project.flightTicketSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.flightTicketSystem.model.Abstract_Flight;
import com.project.flightTicketSystem.model.Flight;
import com.project.flightTicketSystem.model.Flight_Ticket;
import com.project.flightTicketSystem.model.Ticket;
import com.project.flightTicketSystem.repository.FlightRepository;
import com.project.flightTicketSystem.repository.FlightTicketRepository;

@Service
public class TicketService {
	
	@Autowired
	FlightRepository flightRepo;
	
	@Autowired
	FlightTicketRepository ftRepo;

	public void addDetailsInFlightTicketRepo(List<Abstract_Flight> flights, Ticket ticket) {
		flights.forEach(flight->{
			Flight_Ticket flight_ticket= new Flight_Ticket(new Flight(flight.getId()), ticket);
			ftRepo.save(flight_ticket);
		});
		
	}
      
	
	
}
