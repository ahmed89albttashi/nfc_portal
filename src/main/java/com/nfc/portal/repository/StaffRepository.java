package com.nfc.portal.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.Department;
import com.nfc.portal.entity.Staff;

@Repository
public interface StaffRepository extends CrudRepository<Staff, Long>{
	
	public List<Staff> findByDepartment(Department department);
	
	public List<Staff> findAll();


}
