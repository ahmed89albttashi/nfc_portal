package com.nfc.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nfc.portal.entity.User;
import com.nfc.portal.entity.UserResetPassword;

@Repository
public interface UserResetPasswordRepository extends CrudRepository<UserResetPassword, Long>{
	


    @Query(" from UserResetPassword urp where urp.user = ?1")
	List<UserResetPassword> findByUser(User user);
	

    @Modifying
    @Transactional
    @Query("delete from UserResetPassword urp where urp.user = ?1")
	void deleteUserOldRequest(User user);
	
	
}
