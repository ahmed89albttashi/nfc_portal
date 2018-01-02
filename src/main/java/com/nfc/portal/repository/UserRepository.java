package com.nfc.portal.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.User;
import java.lang.Boolean;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {

	@Query("from User u where u.email =:email")
	public User findByEmail(@Param("email")String email);

	
	
	List<User> findByEnabled(Boolean enabled);
	
	
}
