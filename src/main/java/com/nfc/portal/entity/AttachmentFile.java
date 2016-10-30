package com.nfc.portal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="a_attachment_files",catalog="public",uniqueConstraints={@UniqueConstraint(columnNames= "attachment_file_id")})
public class AttachmentFile {
	

	@Id
	@Column(name = "attachment_file_id", unique = true, nullable = false)
	@SequenceGenerator(name = "a_attachment_file_id_seq", sequenceName = "a_attachment_file_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a_attachment_file_id_seq")
	private Long attachment_file_id;

	
	@Column(name="data")
	private byte[] data;

	
	@Column(name="thumbnail")
	private byte[] thumbnail;
	

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="attachment_id")
	private Attachment attachment;
	
	/*Audit*/
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_by")
	public User created_by;
	

	@Column(name = "created_on",columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
	public Date created_on;
	

	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "changed_by")
	public User changed_by;

	@Column(name = "changed_on",columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
	public Date changed_on;

	
	
	
	
	public Long getAttachment_file_id() {
		return attachment_file_id;
	}

	public void setAttachment_file_id(Long attachment_file_id) {
		this.attachment_file_id = attachment_file_id;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public User getCreated_by() {
		return created_by;
	}

	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}

	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	public User getChanged_by() {
		return changed_by;
	}

	public void setChanged_by(User changed_by) {
		this.changed_by = changed_by;
	}

	public Date getChanged_on() {
		return changed_on;
	}

	public void setChanged_on(Date changed_on) {
		this.changed_on = changed_on;
	}
	
	
	
	
	
	
	

}
