package com.rappi.examination.service;

import com.rappi.examination.entity.Ticket;

public interface TicketService {

	public Ticket add(Ticket newTicket);
	public Ticket get(Long id);
	
}
