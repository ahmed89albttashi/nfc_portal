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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "a1_track", catalog = "public", uniqueConstraints = { @UniqueConstraint(columnNames = "a1Track_id") })
public class A1Track {
	
	public Long a1Track_id;
	public A1Ticket a1Ticket;
	public String track;
	public String detail;
	public Staff tracker;

	public Set<A1Attachment> attachment = new  HashSet<A1Attachment>(0);

	public User created_by;
	public Date created_on;
	public User changed_by;
	public Date changed_on;

	
	@Id
	@Column(name = "a1Track_id", unique = true, nullable = false )
	@SequenceGenerator(name = "a1Track_id_seq", sequenceName = "a1Track_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a1Track_id_seq")
	public Long getA1Track_id() {
		return a1Track_id;
	}

	public void setA1Track_id(Long a1Track_id) {
		this.a1Track_id = a1Track_id;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "ticket_id")
	public A1Ticket getA1Ticket() {
		return a1Ticket;
	}

	public void setA1Ticket(A1Ticket a1Ticket) {
		this.a1Ticket = a1Ticket;
	}

	@Column(name = "track")
	public String getTrack() {
		return track;
	}

	public void setTrack(String track) {
		this.track = track;
	}

	@Column(name = "detail",columnDefinition= "text")
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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

	

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tracker_id")
	public Staff getTracker() {
		return tracker;
	}

	public void setTracker(Staff tracker) {
		this.tracker = tracker;
	}

	@Override
	public String toString() {
		return "A1Track [a1Track_id=" + a1Track_id + ", a1Ticket=" + a1Ticket + ", track=" + track + ", detail="
				+ detail + ", tracker=" + tracker + ", created_by=" + created_by + ", created_on=" + created_on
				+ ", changed_by=" + changed_by + ", changed_on=" + changed_on + "]";
	}
	

	

	@OneToMany(mappedBy="related")
	public Set<A1Attachment> getAttachment() {
		return attachment;
	}

	public void setAttachment(Set<A1Attachment> attachment) {
		this.attachment = attachment;
	}
	
	


	
	
	
	

}
