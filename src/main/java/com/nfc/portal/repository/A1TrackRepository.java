package com.nfc.portal.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.A1Ticket;
import com.nfc.portal.entity.A1Track;
import com.nfc.portal.entity.User;

@Repository
public interface A1TrackRepository extends CrudRepository<A1Track, Long> {
	
	
	
	@Query("select track.track as track ,count(track.track) as total  "
				+ " from"
				+ " A1Track track "
				+ " where"
				+ "		 track.changed_on = (select max(stra.changed_on) "
				+ "				from A1Track stra "
				+ "				where "
				+ "					track.a1Ticket = stra.a1Ticket  group by a1Ticket) "
				+ "group by  track.track ")
	public List getStatistics();

	
	//test
	//@Query("select max(created_by)from A_IT_Ticket_Track as track group by track.a_IT_Ticket ")
	
	
	@Query("select track.track as track ,track.a1Ticket , track.changed_on as changed_on"
			+ " from"
			+ " A1Track track "
			+ " where"
			+ "		 track.changed_on = (select max(stra.changed_on) "
			+ "				from A1Track stra "
			+ "				where "
			+ "					track.a1Ticket = stra.a1Ticket  group by ticket_id) "
			+ "and track.track=:track "
			+ " order by track.changed_on desc")
	
	public List getLatestTenByTrack(@Param("track") String track,Pageable pageable);

	
	@Query(" from A1Track track"
			+ " where track.a1Ticket= :a1Ticket "
			+ "order by created_on ")
	public List<A1Track> findByA1Ticket(@Param("a1Ticket") A1Ticket a1Ticket);

	
	@Query(" from A1Track track, A1Attachment attch"
			+ " where track.a1Ticket= :a1Ticket "
			+ " order by created_on")
	public List<A1Track> findWithAttachmentByA1Ticket(@Param("a1Ticket") A1Ticket a1Ticket);
	
	
	
	
	@Query(" from"
			+ " A1Track track "
			+ " where"
			+ "		 track.changed_on = (select max(stra.changed_on) "
			+ "				from A1Track stra "
			+ "				where "
			+ "					track.a1Ticket = stra.a1Ticket  group by ticket_id) "
			+ "and track.track=:track "
			+ " order by track.changed_on desc")
	public List<A1Track> findByTrack(@Param("track") String track);
	

	@Query(" from"
			+ " A1Track track "
			+ " where"
			+ "		 track.changed_on = (select max(stra.changed_on) "
			+ "				from A1Track stra "
			+ "				where "
			+ "					track.a1Ticket = stra.a1Ticket  group by ticket_id) "
			+ " and track.track=:track "
			+ " and track.a1Ticket.created_by =:created_by"
			+ " order by track.changed_on desc")
	public List<A1Track> findByCreatedByAndTrack(@Param("created_by") User created_by,@Param("track") String track);
	
	
	@Query(" from"
			+ " A1Track track "
			+ " where"
			+ "		 track.changed_on = (select max(stra.changed_on) "
			+ "				from A1Track stra "
			+ "				where "
			+ "					track.a1Ticket = stra.a1Ticket  group by ticket_id) "
			+ " and track.track!='closed' "
			+ " and track.a1Ticket.created_by =:created_by"
			+ " order by track.changed_on desc")
	public List<A1Track> findByCreatedByAndTrackNotClosed(@Param("created_by") User created_by);
	
	@Query(" from"
			+ " A1Track track "
			+ " where"
			+ "		 track.changed_on = (select max(stra.changed_on) "
			+ "				from A1Track stra "
			+ "				where "
			+ "					track.a1Ticket = stra.a1Ticket  group by ticket_id) "
			+ " order by created_by desc")
	
	public List<A1Track> trackReport();
	
}

