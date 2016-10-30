package com.nfc.portal.module;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PortalMessage {
	
	public String subject;
	public String template;
	public String replayTo;
	public String getReplayTo() {
		return replayTo;
	}
	public void setReplayTo(String replayTo) {
		this.replayTo = replayTo;
	}
	public List<String> to;
	public List<String> cc;
	public List<String> bcc;
	public Map<String, Object> messageDetail= new HashMap<String, Object>();
	
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public List<String> getTo() {
		return to;
	}
	public void setTo(List<String> to) {
		this.to = to;
	}
	public List<String> getCc() {
		return cc;
	}
	public void setCc(List<String> cc) {
		this.cc = cc;
	}
	public List<String> getBcc() {
		return bcc;
	}
	public void setBcc(List<String> bcc) {
		this.bcc = bcc;
	}
	

	public Map<String, Object> getMessageDetail() {
		return messageDetail;
	}
	public void setMessageDetail(Map<String, Object> messageDetail) {
		this.messageDetail = messageDetail;
	}
	
	
	
	
	

}
