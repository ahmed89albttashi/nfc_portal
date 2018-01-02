package com.nfc.portal.service;

import java.util.List;
import com.nfc.portal.entity.A1Ticket;
import com.nfc.portal.entity.A1Track;
import com.nfc.portal.entity.A1Tracker;

public interface A1TrackService {

	public A1Track create(A1Track a_IT_Ticket_Track);
	
	public void update(A1Track a_IT_Ticket_Track);
	
	public void Assigned(A1Tracker a1Tracker);
	
	public void unAssigned(A1Ticket a1Ticket);
	
	public void delete(A1Track a_IT_Ticket_Track);

	public List<A1Track>  getByCritic(A1Track a_IT_Ticket_Track);

	public List<A1Track>  getByTicket(A1Ticket a1Ticket);
	
	public List<A1Track>  getAll();
	
	public List getStatistics();
	
	public List getLatestTenByTrack(String track);

	public List<A1Tracker> findTrackersByTicket(A1Ticket a1Ticket);

	public List<A1Track> findTicketsByTrack(String track);
	
	public List<A1Track> trackReport();
	
}
