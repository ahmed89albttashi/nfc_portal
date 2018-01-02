package com.nfc.portal.entity;

import java.util.Date;
import javax.persistence.CascadeType;
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
@Table(name = "a1_tracker", catalog = "public", uniqueConstraints = { @UniqueConstraint(columnNames = "a1_tracker_tracker_id") })
public class A1Tracker {
	public Long a1_tracker_tracker_id;
	public A1Ticket ticket_id;
	public Staff tracker_id;

	public User created_by;
	public Date created_on;
	public User changed_by;
	public Date changed_on;

	@Id
	@Column(name = "a1_tracker_tracker_id", unique = true, nullable = false)
	@SequenceGenerator(name = "a1_tracker_tracker_id_seq", sequenceName = "a1_tracker_tracker_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a1_tracker_tracker_id_seq")
	public Long getA1_tracker_tracker_id() {
		return a1_tracker_tracker_id;
	}

	public void setA1_tracker_tracker_id(
			Long a1_tracker_tracker_id) {
		this.a1_tracker_tracker_id = a1_tracker_tracker_id;
	}

	@ManyToOne(fetch = FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinColumn(name = "ticket_id")
	public A1Ticket getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(A1Ticket ticket_id) {
		this.ticket_id = ticket_id;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tracker_id")
	public Staff getTracker_id() {
		return tracker_id;
	}

	public void setTracker_id(Staff tracker_id) {
		this.tracker_id = tracker_id;
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

	

}
