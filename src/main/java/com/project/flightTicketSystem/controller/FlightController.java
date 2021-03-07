package com.project.flightTicketSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.flightTicketSystem.model.Flight;
import com.project.flightTicketSystem.repository.FlightRepository;

@RestController
@RequestMapping("/flight")
public class FlightController {
     
	@Autowired
	FlightRepository flightRepo;
	
	@PostMapping("/")
	public void addFlight(@RequestBody Flight flight) {
		flightRepo.save(flight);
	}
	
	@GetMapping("/{flight_id}")
	public Optional<Flight> getFlight(@PathVariable("flight_id") Long id) {
		return flightRepo.findById(id);
	}
	
	
}
