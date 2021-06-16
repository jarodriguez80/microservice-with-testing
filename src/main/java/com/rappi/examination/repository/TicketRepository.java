package com.rappi.examination.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rappi.examination.entity.Ticket;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Long> {

}
