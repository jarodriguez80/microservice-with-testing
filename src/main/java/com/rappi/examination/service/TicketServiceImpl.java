package com.rappi.examination.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rappi.examination.entity.Ticket;
import com.rappi.examination.repository.TicketRepository;

@Service
public class TicketServiceImpl implements TicketService {

	@Autowired
	private TicketRepository ticketRepository;

	@Override
	@Transactional
	public Ticket add(Ticket newTicket) {
		return ticketRepository.save(newTicket);
	}

	@Override
	@Transactional(readOnly = true)
	public Ticket get(Long id) {
		return ticketRepository.findById(id).orElse(null);
	}

}
