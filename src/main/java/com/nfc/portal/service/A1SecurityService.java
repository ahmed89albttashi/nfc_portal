package com.nfc.portal.service;

import org.springframework.security.core.Authentication;

public interface A1SecurityService {

	public boolean canAccessTrack(Authentication authentication, Long ticket_id);

}
