package com.nfc.portal.serviceImp;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.nfc.portal.entity.A1Ticket;
import com.nfc.portal.entity.A1Track;
import com.nfc.portal.entity.A1Tracker;
import com.nfc.portal.repository.A1TrackRepository;
import com.nfc.portal.repository.A1TrackerRepository;
import com.nfc.portal.service.A1TrackService;

@Service("a1TrackService")
public class A1TrackServiceImp implements A1TrackService {

	@Autowired
	A1TrackRepository a1TrackRepository;
	
	@Autowired
	A1TrackerRepository a1TrackerRepository;
	
	public A1Track create(A1Track a_IT_Ticket_Track) {
		a_IT_Ticket_Track.setCreated_on(new Date());
		a_IT_Ticket_Track.setChanged_on(new Date());
		return a1TrackRepository.save(a_IT_Ticket_Track);

	}

	public void update(A1Track a_IT_Ticket_Track) {
		// TODO Auto-generated method stub

	}

	public void delete(A1Track a_IT_Ticket_Track) {
		// TODO Auto-generated method stub

	}

	public List<A1Track> getByCritic(A1Track a_IT_Ticket_Track) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<A1Track> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List getStatistics() {
		
		return a1TrackRepository.getStatistics();
	}

	@Override
	public List getLatestTenByTrack(String track) {
		// TODO Auto-generated method stub
		return a1TrackRepository.getLatestTenByTrack(track,new PageRequest(0,6));
	}

	@Override
	public List<A1Track> getByTicket(A1Ticket a1Ticket) {
		// TODO Auto-generated method stub
		return a1TrackRepository.findByA1Ticket(a1Ticket);
	}

	@Override
	public void Assigned( A1Tracker a1Tracker) {

		//to unassigned
		//a1TrackerRepository.deleteByTicket_id(a1Tracker.getTicket_id());
		

		a1Tracker.setCreated_on(new Date());
		a1Tracker.setChanged_on(new Date());
		
		a1TrackerRepository.save(a1Tracker);
		
	}

	@Override
	public void unAssigned(A1Ticket a1Ticket) {

		a1TrackerRepository.deleteByTicket_id(a1Ticket);
		
	}

	@Override
	public List<A1Tracker> findTrackersByTicket(A1Ticket a1Ticket) {
		// TODO Auto-generated method stub
		return a1TrackerRepository.findByTicket_id(a1Ticket);
	}

	@Override
	public List<A1Track> findTicketsByTrack(String track) {
		// TODO Auto-generated method stub
		return a1TrackRepository.findByTrack(track);
	}


}
