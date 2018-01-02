package com.nfc.portal.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nfc.portal.entity.A1Attachment;
import com.nfc.portal.entity.A1AttachmentFile;
@Repository
public interface AttachmentFileRepository extends CrudRepository<A1AttachmentFile, Long> {
	
	@Query("from A1AttachmentFile af "
			+ "where af.attachment = ?1 ")
	public A1AttachmentFile findByAttachment_id(A1Attachment attachment);

}
