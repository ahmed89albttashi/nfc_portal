package com.nfc.portal.service;

import java.util.List;

import com.nfc.portal.entity.Department;

public interface DepartmentService {
	
	public Department findByCode(String code);
	public List<Department> finAll();
	

}
