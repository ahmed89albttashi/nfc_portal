package com.nfc.portal.service;

import java.util.List;


import com.nfc.portal.entity.Department;
import com.nfc.portal.entity.Staff;


public interface StaffService {

	public List<Staff> getStaffByDepartment(Department department);

	public Staff getStaffById(Long staff_id);
	
	public List<Staff> findAll();
	
}
