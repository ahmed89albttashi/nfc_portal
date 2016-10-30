package com.nfc.portal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.Attachment;
import com.nfc.portal.entity.AttachmentFile;

@Repository
public interface AttachmentFileRepository extends CrudRepository<AttachmentFile, Long> {
	
	@Query("from AttachmentFile af "
			+ "where af.attachment = ?1 ")
	public AttachmentFile findByAttachment_id(Attachment attachment);

}
