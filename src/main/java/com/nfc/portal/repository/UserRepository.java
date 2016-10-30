package com.nfc.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.Department;
import com.nfc.portal.entity.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {

	@Query("select u from User u where email =:email")
	public User findByEmail(@Param("email")String email);
	
	public List<User> findByDepartment(Department department);
	
}
