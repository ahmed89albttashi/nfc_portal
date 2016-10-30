package com.nfc.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.A1Ticket;
import com.nfc.portal.entity.User;

@Repository
public interface A1TicketRepository extends CrudRepository<A1Ticket, Long> {
	
	@Query("from A1Ticket where a1_ticket_ticket_id = :A1_ticket_ticket_id")
	public A1Ticket findByApp_it_ticket_ticket_id(@Param("A1_ticket_ticket_id") Long A1_ticket_ticket_id);
	

	@Query("from A1Ticket where created_by = :created_by order by created_on desc ")
	public List<A1Ticket> findByCreated_by(@Param("created_by") User created_by );
	
	
	/*@Query("Select ti from A_IT_Ticket as ti, A_IT_Ticket_Track as tr where tr.a_IT_Ticket = ti and tr.")
	public List<A_IT_Ticket> findLatestTenByTrack(@Param("track") String track);
	*/
	

	
}

