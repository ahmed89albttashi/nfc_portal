package com.nfc.portal.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "a_user_resetpassword", catalog = "public", uniqueConstraints = {
		@UniqueConstraint(columnNames = "rp_id")})
public class UserResetPassword {
	private Integer rp_id;
	private User user;
	private Long hash_code;
	
	// Audit
	private User created_by;
	private Date created_on;
	private User changed_by;
	private Date changed_on;
	
	
	@Id
	@Column(name = "rp_id", unique = true, nullable = false)
	@SequenceGenerator(name = "a_user_resetpassword_rp_id_seq", sequenceName = "a_user_resetpassword_rp_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a_user_resetpassword_rp_id_seq")
	public Integer getRp_id() {
		return rp_id;
	}
	public void setRp_id(Integer rp_id) {
		this.rp_id = rp_id;
	}
	
	@OneToOne
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Column(name="hash_code")
	public Long getHash_code() {
		return hash_code;
	}
	public void setHash_code(Long hash_code) {
		this.hash_code = hash_code;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "created_by")
	@JsonManagedReference
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

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "changed_by")
	@JsonManagedReference
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
		return "UserResetPassword [rp_id=" + rp_id + ", user=" + user + ", hash_code=" + hash_code + ", created_by="
				+ created_by + ", created_on=" + created_on + ", changed_by=" + changed_by + ", changed_on="
				+ changed_on + "]";
	}

	
	
	
}
