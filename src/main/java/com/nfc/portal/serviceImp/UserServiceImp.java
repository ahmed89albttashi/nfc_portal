package com.nfc.portal.serviceImp;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc.portal.entity.Department;
import com.nfc.portal.entity.User;
import com.nfc.portal.repository.UserRepository;
import com.nfc.portal.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImp implements UserService{
	@Autowired
	UserRepository userRepository;

	@Override
	public void create(User user) {
		userRepository.save(user);
		
	}

	@Override
	public void update(User user) {
		if(userRepository.findOne((long) user.getUser_id()) != null){
			user.setChanged_on(new Date());
			userRepository.save(user);
		}
		
	}

	@Override
	public void delete(Long user_id) {
		userRepository.delete(user_id);
		
	}

	@Override
	public User getUserById(Long user_id) {
		return userRepository.findOne(user_id);
	}

	@Override
	public User getUserByEmail(String email) {
		
		return userRepository.findByEmail(email);
	}

	@Override
	public List<User> getUserList(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getList(User user, Integer start, Integer limit, String order_on, String order_way) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers() {
		
		return (List<User>) userRepository.findAll();
	}

	@Override
	public List<User> getUserByDepartment(Department department) {
		// TODO Auto-generated method stub
		return userRepository.findByDepartment(department);
	}
	
	

}
