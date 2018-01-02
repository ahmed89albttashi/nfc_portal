package com.nfc.portal.serviceImp;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc.portal.entity.Department;
import com.nfc.portal.entity.Staff;
import com.nfc.portal.entity.User;
import com.nfc.portal.repository.DepratmentRepository;
import com.nfc.portal.repository.StaffRepository;
import com.nfc.portal.repository.UserRepository;
import com.nfc.portal.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImp implements UserService{
	@Autowired
	UserRepository userRepository;

	@Autowired
	StaffRepository staffRepository;

	@Autowired
	DepratmentRepository depratmentRepository;

	@Override
	public void create(User user) {

		Department depCDE = depratmentRepository.findByCode("ADN");

		user.getStaff().setChanged_on(new Date());
		user.getStaff().setCreated_on(new Date());
		user.getStaff().setDepartment(depCDE);
		user.setChanged_on(new Date());
		user.setCreated_on(new Date());

		System.out.println(user);
		user.setPassword("$2a$10$P.W4657S3JWv9Z7ilRDp6ecoqq1uPjwYncRH5k2C6l1URFFfJAeOa");
		userRepository.save(user);
		
	}

	@Override
	public void update(User user) {
		User exUser=userRepository.findOne((long) user.getUser_id());
		if(exUser != null){
			Staff exStaff = staffRepository.findOne(exUser.getStaff().getStaff_id());
			
			exStaff.setFullName_en(user.getStaff().getFullName_en());
			exStaff.setFullName_ar(user.getStaff().getFullName_ar());
			exStaff.setGender(user.getStaff().getGender());
			exStaff.setStatus(user.getStaff().getStatus());
			exStaff.setNationality(user.getStaff().getNationality());
			exStaff.setStaff_id(user.getStaff().getStaff_id());
			
			staffRepository.save(exStaff);
			exUser.setStaff(exStaff);
			
			exUser.getStaff().setChanged_on(new Date());
			
			exUser.setChanged_on(new Date());
			exUser.setEnabled(user.getEnabled());
			userRepository.save(exUser);
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
	public List<User> getByEnabled(boolean enabled) {
		
		return (List<User>) userRepository.findByEnabled(enabled);
	}

	
	

}
