package com.nfc.portal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="a_attachments",catalog="public",uniqueConstraints={@UniqueConstraint(columnNames= "attachment_id")})
public class Attachment {
	

	@Id
	@Column(name = "attachment_id", unique = true, nullable = false)
	@SequenceGenerator(name = "a_attachment_id_seq", sequenceName = "a_attachment_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a_attachment_id_seq")
	private Long attachment_id;
	
	@Column(name="sf_name")
	private String sf_name;
	
	@Column(name="f_name")
	private String f_name;
	
	@Column(name="description")
	private String description;
	

	@Column(name="relation")
	private String relation;

	
	@Column(name="relation_id")
	private Long relation_id;
	
	@Column(name="file_extension")
	private String file_extension;

	@Column(name="file_category")
	private String file_category;
	
	@Column(name="hash_sha1")
	private String hash_sha1;
	
	@Column(name="size")
	private Long size;
	
	
	@ManyToOne
	@JoinColumn(name="relation_id" , insertable= false ,updatable=false)
	private A1Track related;


	
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
	
	
	
	

	public Long getAttachment_id() {
		return attachment_id;
	}

	public void setAttachment_id(Long attachment_id) {
		this.attachment_id = attachment_id;
	}

	public String getSf_name() {
		return sf_name;
	}

	public void setSf_name(String sf_name) {
		this.sf_name = sf_name;
	}

	public String getF_name() {
		return f_name;
	}

	public void setF_name(String f_name) {
		this.f_name = f_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	public String getRelation() {
		return relation;
	}

	public void setRelation(String relation) {
		this.relation = relation;
	}

	public Long getRelation_id() {
		return relation_id;
	}

	public void setRelation_id(Long relation_id) {
		this.relation_id = relation_id;
	}

	public String getFile_extension() {
		return file_extension;
	}

	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}

	public String getFile_category() {
		return file_category;
	}

	public void setFile_category(String file_category) {
		this.file_category = file_category;
	}

	public String getHash_sha1() {
		return hash_sha1;
	}

	public void setHash_sha1(String hash_sha1) {
		this.hash_sha1 = hash_sha1;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public A1Track getRelated() {
		return related;
	}

	public void setRelated(A1Track related) {
		this.related = related;
	}
	
	
	
	
	
	

}
