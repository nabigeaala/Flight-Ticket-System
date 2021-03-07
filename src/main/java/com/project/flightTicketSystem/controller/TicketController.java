package com.project.flightTicketSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.flightTicketSystem.model.Root;
import com.project.flightTicketSystem.model.Ticket;
import com.project.flightTicketSystem.repository.TicketRepository;
import com.project.flightTicketSystem.service.BookingService;
import com.project.flightTicketSystem.service.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {
	
	@Autowired
	TicketService ticketService;
     
	@Autowired
	TicketRepository ticketRepo;
	
	@Autowired
	BookingService bookingService;
	
	@PostMapping("/{key}")
	public Ticket addTicket(@RequestBody Ticket ticket, @PathVariable("key") Integer key) {
		List<Long> aids= bookingService.ROOT.get(key);
		Root root= bookingService.createRootObjectFromListOfAirportId(aids);
		ticket.setFare(root.getTotalFare());
		ticket.setAirports(root.getAirports());
		Long id= ticketRepo.save(ticket).getId();
		System.out.print("saed          saved");
		ticketService.addDetailsInFlightTicketRepo(root.getFlights(), ticket);
		
		return ticketRepo.findById(id).get();
	}
}
