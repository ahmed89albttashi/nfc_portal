package com.nfc.portal.service;

import java.util.List;


import com.nfc.portal.entity.Role;



public interface RoleService {
	public void create(Role role);
	public void update(Role role);
	public void delete(Role role);
	
	public Role getById(int role_id);
	public List<Role> getByCritic(Role role);
	public List<Role> getAll();
	
	

}
