package com.nfc.portal.service;

import com.nfc.portal.entity.A1Attachment;
import com.nfc.portal.entity.A1AttachmentFile;

public interface AttachmentService {
	
	public Long upload(A1Attachment attachment,A1AttachmentFile attachmentFile);
	public void assign(String[] attachment_ids,String relation,Long relation_id);
	public A1AttachmentFile findAttachmentFileByAttachmentId(A1Attachment attachment);
	public A1Attachment findByAttachmentID(Long AttachmentID);
}
