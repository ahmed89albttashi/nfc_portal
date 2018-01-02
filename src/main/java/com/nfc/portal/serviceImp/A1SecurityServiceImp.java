package com.nfc.portal.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.nfc.portal.entity.A1Ticket;
import com.nfc.portal.entity.Staff;
import com.nfc.portal.entity.User;
import com.nfc.portal.repository.UserRepository;
import com.nfc.portal.service.A1SecurityService;
import com.nfc.portal.service.A1TicketService;

@Service("a1SecurityService")
public class A1SecurityServiceImp implements A1SecurityService {
	@Autowired
	A1TicketService a1TicketService;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public boolean canAccessTrack(Authentication authentication , Long ticket_id) {
		String email=a1TicketService.findByA1_ticket_ticket_id(ticket_id).getCreated_by().getEmail();
		A1Ticket ticket = a1TicketService.findByA1_ticket_ticket_id(ticket_id);
	     String loggedun_email = authentication.getName();
	     User loged_user = userRepository.findByEmail(loggedun_email);
	     
	     Staff Logged_staff = loged_user.getStaff();
		if(authentication.getName().equals(ticket.getCreated_by().getEmail())||a1TicketService.findByA1_ticket_ticket_id(ticket_id).getRecipients().contains(Logged_staff) || Logged_staff.getDepartment().getCode().toLowerCase().equals("it")){
			return true;
		}else{
			return false;
		}
	}
	

	@Override
	public boolean canAccessAdmin(Authentication authentication){
	     String loggedun_email = authentication.getName();
	     User loged_user = userRepository.findByEmail(loggedun_email);
	     Staff Logged_staff = loged_user.getStaff();

	    if(Logged_staff.getDepartment() != null){
	     if(Logged_staff.getDepartment().getCode().toLowerCase().equals("it")){
				return true;
			}else{
				return false;
			}
	    }else{
	    	return false;
	    }
	    
		
	}

}
