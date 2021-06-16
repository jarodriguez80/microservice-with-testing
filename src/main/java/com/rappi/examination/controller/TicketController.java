package com.rappi.examination.controller;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rappi.examination.entity.Ticket;
import com.rappi.examination.service.TicketService;

@RestController
@RequestMapping("tickets")
public class TicketController implements Crudable {

	private static final Logger log = LoggerFactory.getLogger(TicketController.class);

	private final Map<String, String> creationFailed = Stream
			.of(new String[][] { { "message", "Could not create the ticket" } })
			.collect(Collectors.toMap(data -> data[0], data -> data[1]));
	private final Map<String, String> notFound = Stream.of(new String[][] { { "message", "Ticket was not found." } })
			.collect(Collectors.toMap(data -> data[0], data -> data[1]));

	@Autowired
	private TicketService ticketService;

	@Override
	@PostMapping("/create")
	public ResponseEntity<Object> create(@Valid @RequestBody Ticket ticket) {
		Ticket createdTicket = ticketService.add(ticket);
		if (createdTicket != null && createdTicket.getItineraryID() != null) {
			log.info("Ticket was created succesfully");
			return ResponseEntity.ok().body(createdTicket);
		} else {
			log.info("Ticket could not be created.");
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(creationFailed);
		}
	}

	@Override
	@GetMapping("/get/{itineraryID}")
	public ResponseEntity<Object> get(@PathVariable Long itineraryID) {

		Ticket foundTicket = ticketService.get(itineraryID);

		if (foundTicket != null) {
			return ResponseEntity.ok().body(foundTicket);
		} else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
		}

	}

}
