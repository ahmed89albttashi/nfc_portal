package com.nfc.portal.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.NotEmpty;


@Entity 
@Table(name = "a1_ticket", catalog = "public", 
		uniqueConstraints = { @UniqueConstraint(columnNames = "a1_ticket_ticket_id") })
@DynamicInsert(value=true)
@DynamicUpdate (value=true)

public class A1Ticket {
	public Long a1_ticket_ticket_id;
	public String type;
	public String sub_type;
	public String title;
	public String detail;
	public String ip;
	public Set<Staff> recipients =new HashSet<Staff>(0);
	public Set<A1Tracker> trackers =new HashSet<A1Tracker>(0);


	
	public User created_by;
	public Date created_on;
	public User changed_by;
	public Date changed_on;

	@Id
	@Column(name = "a1_ticket_ticket_id", unique = true, nullable = false)
	@SequenceGenerator(name = "a1_ticket_ticket_id_seq", sequenceName = "a1_ticket_ticket_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a1_ticket_ticket_id_seq")
	public Long getA1_ticket_ticket_id() {
		return a1_ticket_ticket_id;
	}

	public void setA1_ticket_ticket_id(Long a1_ticket_ticket_id) {
		this.a1_ticket_ticket_id = a1_ticket_ticket_id;
	}

	
	@Column(name = "type",nullable=false)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name = "sub_type",nullable=false)
	public String getSub_type() {
		return sub_type;
	}

	public void setSub_type(String sub_type) {
		this.sub_type = sub_type;
	}

	@Column(name = "title", nullable = false,length=5000)
	@NotEmpty
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	@Column(name = "detail")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Column(name = "ip", nullable = false)
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}
	
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "a1_r_ticket_recipients", catalog = "public", joinColumns = { 
			@JoinColumn(name = "a1_ticket_ticket_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "staff_id", 
					nullable = false, updatable = false) })
	public Set<Staff> getRecipients() {
		return recipients;
	}

	public void setRecipients(Set<Staff> recipients) {
		this.recipients = recipients;
	}

	
	

	@OneToMany(mappedBy="ticket_id")
	public Set<A1Tracker> getTrackers() {
		return trackers;
	}

	public void setTrackers(Set<A1Tracker> trackers) {
		this.trackers = trackers;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by")
	public User getCreated_by() {
		return created_by;
	}

	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}

	
	@Column(name = "created_on",columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
	public Date getCreated_on() {
		return created_on;
	}

	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "changed_by")
	public User getChanged_by() {
		return changed_by;
	}

	public void setChanged_by(User changed_by) {
		this.changed_by = changed_by;
	}

	@Column(name = "changed_on",columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
	public Date getChanged_on() {
		return changed_on;
	}

	public void setChanged_on(Date changed_on) {
		this.changed_on = changed_on;
	}

	@Override
	public String toString() {
		return "A1Ticket [a1_ticket_ticket_id=" + a1_ticket_ticket_id + ", type=" + type + ", sub_type=" + sub_type
				+ ", title=" + title + ", detail=" + detail + ", ip=" + ip + ", created_by="
				+ created_by + ", created_on=" + created_on + ", changed_by=" + changed_by + ", changed_on="
				+ changed_on + "]";
	}

	


}
