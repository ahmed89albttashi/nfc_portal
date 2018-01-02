package com.nfc.portal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.Department;
import java.lang.String;
import java.util.List;

@Repository("deprtmentRepository")
public interface DepratmentRepository extends CrudRepository<Department, Long>{

	 Department findByCode(String code);
	 
	 List<Department> findAll();

}
