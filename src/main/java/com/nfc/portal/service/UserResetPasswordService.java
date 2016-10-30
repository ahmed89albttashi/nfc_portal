package com.nfc.portal.service;

import java.util.List;

import com.nfc.portal.entity.User;
import com.nfc.portal.entity.UserResetPassword;

public interface UserResetPasswordService {

	public void save(UserResetPassword userResetPassword);
	
	public List<UserResetPassword> findByUser(User user);
}
