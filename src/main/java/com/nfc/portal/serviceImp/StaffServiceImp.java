package com.nfc.portal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc.portal.entity.Department;
import com.nfc.portal.entity.Staff;
import com.nfc.portal.entity.User;
import com.nfc.portal.repository.StaffRepository;
import com.nfc.portal.service.StaffService;

@Service
public class StaffServiceImp implements StaffService {
	
	@Autowired
	StaffRepository staffRepository;
	
	@Override
	public List<Staff> getStaffByDepartment(Department department) {
		// TODO Auto-generated method stub
		return staffRepository.findByDepartment(department);
	}

	@Override
	public Staff getStaffById(Long staff_id) {
		// TODO Auto-generated method stub
		return staffRepository.findOne(staff_id);
	}

	@Override
	public List<Staff> findAll() {
		// TODO Auto-generated method stub
		return staffRepository.findAll();
	}
	

}
