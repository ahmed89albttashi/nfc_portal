package com.nfc.portal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.Role;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long>{
	

}
