package com.nfc.portal.serviceImp;

import java.io.FileInputStream;
import java.text.DecimalFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nfc.portal.entity.Attachment;
import com.nfc.portal.entity.AttachmentFile;
import com.nfc.portal.helper.CheckSum;
import com.nfc.portal.repository.AttachmentFileRepository;
import com.nfc.portal.repository.AttachmentRepository;
import com.nfc.portal.service.AttachmentService;

import scala.collection.generic.BitOperations.Int;

@Service("attachmentService")
public class AttachmentServiceImp implements AttachmentService {
	@Autowired
	AttachmentRepository attachmentRepository;
	
	@Autowired
	AttachmentFileRepository attachmentFileRepository;

	
	
	@Override
	public Long upload(Attachment attachment, AttachmentFile attachmentFile) {

		CheckSum cs = new CheckSum();

		//get file extension
		String fileExtension = attachment.getSf_name().substring(attachment.getSf_name().lastIndexOf(".")+1);
		String fileCategory="";
		System.out.println("FE :"+fileExtension);

		switch (fileExtension.toLowerCase()) {
		//images
		case "jpg":
			fileCategory="image";
			break;
		case "gif":
			fileCategory="image";
			break;
		case "bmp":
			fileCategory="image";
			break;
		case "png":
			fileCategory="image";
			break;
		case "svg":
			fileCategory="image";
			break;
		case "tif":
			fileCategory="image";
			break;
		case "pdf":
			fileCategory="pdf";
			break;
		case "doc":
			fileCategory="word";
			break;
		case "docx":
			fileCategory="word";
			break;

		default:
			break;
		}

		attachment.setFile_category(fileCategory);
		attachment.setFile_extension(fileExtension);
		attachment.setChanged_on(new Date());
		attachment.setCreated_on(new Date());
		
		
		//calculate size
		Integer x=attachmentFile.getData().length;
		attachment.setSize(Long.parseLong(x.toString()));
		
		//calculate SHA1 todo later
		//attachment.setHash_sha1(cs.calculateSHA1(new FileInputStream(attachmentFile.getData()));
		
		
		attachmentFile.setAttachment(attachment);
		
		attachmentRepository.save(attachment);
		
		attachmentFileRepository.save(attachmentFile);
		
		//System.out.println("Attachment ID " + attachment.getAttachment_id());
		
		
		return attachment.getAttachment_id();
	}

	@Override
	public void assign(String[] attachment_ids,String relation,Long relation_id) {
		for(int x =0 ; x< attachment_ids.length;x++){
			Attachment attch = new Attachment();
			attch = attachmentRepository.findOne(Long.parseLong(attachment_ids[x]));
			attch.setRelation(relation);
			attch.setRelation_id(relation_id);
			
			attachmentRepository.save(attch);
			
		}
		
	}
	
	public static String readableFileSize(long size) {
	    if(size <= 0) return "0";
	    final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
	    int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
	    return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}

	
	public AttachmentFile findAttachmentFileByAttachmentId(Attachment attachment) {
		return attachmentFileRepository.findByAttachment_id(attachment);
	}

	public Attachment findByAttachmentID(Long AttachmentID){
		
		return attachmentRepository.findOne(AttachmentID);
	}
	

}
