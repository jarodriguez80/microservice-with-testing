package com.rappi.examination.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import com.rappi.examination.entity.Ticket;

public interface Crudable {

	public ResponseEntity<Object> create(Ticket ticket);
	public ResponseEntity<Object> get(@PathVariable Long itineraryID);
	
}
