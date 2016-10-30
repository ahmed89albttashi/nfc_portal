package com.nfc.portal.service;

import java.util.List;


import com.nfc.portal.entity.Permission;



public interface PermissionService {
	public void create(Permission role);
	public void update(Permission role);
	public void delete(Permission role);
	
	public Permission getById(int permission_id);
	public List<Permission> getByCritic(Permission role);
	public List<Permission> getAll();
	
	

}
