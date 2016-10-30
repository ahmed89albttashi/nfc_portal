package com.nfc.portal.service;

import java.util.List;

import com.nfc.portal.entity.A1Ticket;
import com.nfc.portal.entity.User;


public interface A1TicketService {
	public void create(A1Ticket a_IT_Ticket);

	public void update(A1Ticket a_IT_Ticket);

	public List<A1Ticket> get(A1Ticket a_IT_Ticket);

	public void delete(A1Ticket a_IT_Ticket);
	
	public A1Ticket findByA1_ticket_ticket_id(Long a1_ticket_ticket_id);
	
	public List<A1Ticket> findByCreated_by(User created_by);

}
