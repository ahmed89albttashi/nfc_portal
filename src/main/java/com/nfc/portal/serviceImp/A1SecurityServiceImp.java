package com.nfc.portal.serviceImp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.nfc.portal.service.A1SecurityService;
import com.nfc.portal.service.A1TicketService;

@Service("a1SecurityService")
public class A1SecurityServiceImp implements A1SecurityService {
	@Autowired
	A1TicketService a1TicketService;

	@Override
	public boolean canAccessTrack(Authentication authentication , Long ticket_id) {
		String email=a1TicketService.findByA1_ticket_ticket_id(ticket_id).getCreated_by().getEmail();
		if(authentication.getName().equals(email)){
			return true;
		}else{
			return false;
		}
		

	}

}
