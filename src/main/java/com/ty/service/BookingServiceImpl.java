package com.ty.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.ty.request.Passenger;
import com.ty.response.Ticket;


@Service
public class BookingServiceImpl implements BookingService{
Map<Integer, Ticket> ticketsMap=new HashMap<Integer, Ticket>();
	private Integer ticketNumber=1;
	
	
	@Override
	public Ticket bookTicket(Passenger passenger) {
		Ticket t=new Ticket();
		BeanUtils.copyProperties(passenger, t);
		t.setTicketCost(5000.00);
		t.setStatus("CONFIRMED");
		t.setTicketNum(ticketNumber);
		
		ticketsMap.put(ticketNumber, t);
		
		ticketNumber++;
		
		return t;
	}

	@Override
	public Ticket getTicket(Integer ticketNumber) {
		
		if(ticketsMap.containsKey(ticketNumber)) {
			return ticketsMap.get(ticketNumber);
		}
		
		
		return null;
	}

}
