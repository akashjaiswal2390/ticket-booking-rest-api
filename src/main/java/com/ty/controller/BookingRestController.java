package com.ty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ty.request.Passenger;
import com.ty.response.Ticket;
import com.ty.service.BookingServiceImpl;

@RestController
public class BookingRestController {

	@Autowired
	private BookingServiceImpl service;

	@PostMapping("/ticket")
	public ResponseEntity<?> ticketBooking(@RequestBody Passenger passenger) {
		Ticket bookTicket = service.bookTicket(passenger);

		return new ResponseEntity<>(bookTicket, HttpStatus.CREATED);

	}
	
	@GetMapping("/ticket/{ticketNum}")
	public ResponseEntity<Ticket> getTicket(@PathVariable ("ticketNum")Integer ticketNum){
		
		Ticket ticket = service.getTicket(ticketNum);
		
		 
		
		return new ResponseEntity<>(ticket, HttpStatus.FOUND);
		
	}

}
