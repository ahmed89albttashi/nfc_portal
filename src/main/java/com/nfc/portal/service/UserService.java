package com.nfc.portal.service;

import java.util.List;

import com.nfc.portal.entity.Department;
import com.nfc.portal.entity.User;

public interface UserService {

	public void create(User user);
	
	
	public void update(User user);
	
	public void delete(Long user_id);

	public User getUserById(Long user_id);

	public User getUserByEmail(String email);

	public List<User> getUserByDepartment(Department department);

	public List<User> getUserList(User user);

	public List<User> getList(User user,Integer start, Integer limit, String order_on, String order_way); 
	
	public List<User> getAllUsers();
}
