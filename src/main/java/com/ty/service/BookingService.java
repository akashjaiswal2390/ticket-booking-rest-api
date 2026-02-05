package com.ty.service;

import com.ty.request.Passenger;
import com.ty.response.Ticket;

public interface BookingService {
	public Ticket bookTicket(Passenger passenger);
	
	public Ticket getTicket(Integer ticketNumber);
}
