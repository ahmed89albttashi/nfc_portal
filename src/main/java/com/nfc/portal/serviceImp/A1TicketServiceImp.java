package com.nfc.portal.serviceImp;


import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc.portal.entity.A1Ticket;
import com.nfc.portal.entity.User;
import com.nfc.portal.repository.A1TicketRepository;
import com.nfc.portal.service.A1TicketService;

@Service("a_IT_TicketService")
@Transactional
public class A1TicketServiceImp implements A1TicketService {
	/*@Autowired
	A_IT_TicketDao a_IT_TicketDao;
	*/
	@Autowired
	A1TicketRepository a1TicketRepository;
	
	public void create(A1Ticket a_IT_Ticket) {
		
		a_IT_Ticket.setCreated_on(new Date());
		a1TicketRepository.save(a_IT_Ticket);

	}

	public void update(A1Ticket a_IT_Ticket) {
		a_IT_Ticket.setChanged_on(new Date());
		a1TicketRepository.save(a_IT_Ticket);

	}

	public List<A1Ticket> get(A1Ticket a_IT_Ticket) {
		
		
		
		return null;
		
		
	}

	public void delete(A1Ticket a_IT_Ticket) {
		
	}

	@Override
	public A1Ticket findByA1_ticket_ticket_id(Long a1_ticket_ticket_id) {
		// TODO Auto-generated method stub
		return a1TicketRepository.findByApp_it_ticket_ticket_id(a1_ticket_ticket_id);
	}
	
	public List<A1Ticket> findByCreated_by(User created_by){
		
		return a1TicketRepository.findByCreated_by(created_by);
		
	}

}
