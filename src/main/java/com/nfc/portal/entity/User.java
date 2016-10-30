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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.annotations.Type;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "a_users", catalog = "public", uniqueConstraints = {
		@UniqueConstraint(columnNames = "user_id"),
		@UniqueConstraint(columnNames = "email"),
		@UniqueConstraint(columnNames = "staff_id") })
public class User {

	private Long user_id;
	private String staff_id;
	private String password;
	private String email;
	private Boolean enabled;
	private String name;
	private String gender;
	private String nationality;
	private Department department;
	
	private Date dob;
	private String live_in;
	private Date join_on;
	private String position;

	private Set<Role> roles = new HashSet<Role>(0);
	private Set<Department> head_of = new HashSet<Department>(0);


	// Audit
	private User created_by;
	private Date created_on;
	private User changed_by;
	private Date changed_on;

	
	@Id
	@Column(name = "user_id", unique = true, nullable = false)
	@SequenceGenerator(name = "a_users_user_id_seq", sequenceName = "a_users_user_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a_users_user_id_seq")
	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	
	@Column(name = "staff_id", unique = true, nullable = false)
	public String getStaff_id() {
		return staff_id;
	}

	public void setStaff_id(String staff_id) {
		this.staff_id = staff_id;
	}

	@Column(name = "email",unique=true)
	@Email
	@NotNull
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "password", nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "enabled")
	public Boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

	@Column(name = "name")
	@NotNull
	@NotBlank
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	@Column(name="gender")
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name = "nationality")
	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	


	@OneToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name = "department_id")
	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Column(name = "dob")
	@Past
	@Temporal(TemporalType.DATE)
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	@Column(name = "live_in")
	public String getLive_in() {
		return live_in;
	}

	public void setLive_in(String live_in) {
		this.live_in = live_in;
	}

	@Column(name = "join_on")
	@Type(type = "date")
	@Temporal(TemporalType.DATE)
	public Date getJoin_on() {
		return join_on;
	}

	public void setJoin_on(Date join_on) {
		this.join_on = join_on;
	}

	@Column(name = "position")
	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "a_r_user_roles", catalog = "public", joinColumns = { @JoinColumn(name = "user_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "role_id", nullable = false, updatable = false) })
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "head")
	public Set<Department> getHead_of() {
		return head_of;
	}

	public void setHead_of(Set<Department> head_of) {
		this.head_of = head_of;
	}

	@Override
	public String toString() {
		return "User [user_id=" + user_id + ", staff_id=" + staff_id
				+ ", password=" + password + ", email=" + email + ", enabled="
				+ enabled + ", created_by=" + created_by + ", created_on="
				+ created_on + ", changed_by=" + changed_by + ", changed_on="
				+ changed_on + ", name=" + name + ", nationality="
				+ nationality + ", dob=" + dob + ", live_in=" + live_in
				+ ", join_on=" + join_on + ", position=" + position
				+ ", roles=" + roles + "]";
	}

}