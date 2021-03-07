package com.project.flightTicketSystem.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.flightTicketSystem.model.Airport;
import com.project.flightTicketSystem.repository.AirportRepository;

@RestController
@RequestMapping("/airport")
public class AirportController {
     
	@Autowired
	AirportRepository airportRepo;
	
	@PostMapping("/")
	public void addAirport(@RequestBody Airport airport) {
		airportRepo.save(airport);
	}
	
	@GetMapping("/{airport_id}")
	public Optional<Airport> getAirport(@PathVariable("airport_id") Long id){
		return airportRepo.findById(id);
	}
	
	@DeleteMapping("/{airport_id}")
	public ResponseEntity<Object> deleteAirport(@PathVariable("airport_id") Long id){
		airportRepo.deleteById(id);
		return new ResponseEntity<Object>("deleted successfully", HttpStatus.OK);
	}
}
