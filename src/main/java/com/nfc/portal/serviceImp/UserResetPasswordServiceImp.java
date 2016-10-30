package com.nfc.portal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc.portal.entity.User;
import com.nfc.portal.entity.UserResetPassword;
import com.nfc.portal.repository.UserRepository;
import com.nfc.portal.repository.UserResetPasswordRepository;
import com.nfc.portal.service.UserResetPasswordService;

@Service
public class UserResetPasswordServiceImp implements UserResetPasswordService{

	@Autowired
	UserResetPasswordRepository userResetPasswordRepository;
	
	@Autowired
	UserRepository userRepoistory;
	
	@Override
	public void save(UserResetPassword urp) {
		
		userResetPasswordRepository.deleteUserOldRequest(urp.getUser());
		userResetPasswordRepository.save(urp);
		
	}


	@Override
	public List<UserResetPassword> findByUser(User user) {
		//UserResetPasswordRepository.
		
		return userResetPasswordRepository.findByUser(user);
	}

}
