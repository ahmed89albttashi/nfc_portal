package com.nfc.portal.service;

import com.nfc.portal.entity.Attachment;
import com.nfc.portal.entity.AttachmentFile;

public interface AttachmentService {
	
	public Long upload(Attachment attachment,AttachmentFile attachmentFile);
	public void assign(String[] attachment_ids,String relation,Long relation_id);
	public AttachmentFile findAttachmentFileByAttachmentId(Attachment attachment);
	public Attachment findByAttachmentID(Long AttachmentID);
}
