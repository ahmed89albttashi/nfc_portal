package com.nfc.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nfc.portal.entity.A1Ticket;
import com.nfc.portal.entity.A1Tracker;

@Repository
public interface A1TrackerRepository extends CrudRepository<A1Tracker, Long>{
	
	@Modifying  
	@Transactional
    @Query("delete from A1Tracker t where t.ticket_id = :ticket_id")
	Integer deleteByTicket_id(@Param("ticket_id") A1Ticket a1Ticket);
	
	
	@Query("from A1Tracker t where  t.ticket_id = :ticket_id")
	List<A1Tracker> findByTicket_id(@Param("ticket_id") A1Ticket ticket_id);
	


}
