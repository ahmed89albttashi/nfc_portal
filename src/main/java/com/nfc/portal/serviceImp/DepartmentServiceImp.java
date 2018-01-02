package com.nfc.portal.serviceImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc.portal.entity.Department;
import com.nfc.portal.repository.DepratmentRepository;
import com.nfc.portal.service.DepartmentService;

@Service("departmentService")
public class DepartmentServiceImp implements DepartmentService {
	@Autowired
	DepratmentRepository deprtmentRepository;

	@Override
	public Department findByCode(String code) {
		// TODO Auto-generated method stub
		return deprtmentRepository.findByCode(code);
	}

	@Override
	public List<Department> finAll() {
		// TODO Auto-generated method stub
		return deprtmentRepository.findAll();
	}

}
