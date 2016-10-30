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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;



@Entity
@Table(name = "a_roles", catalog = "public", uniqueConstraints = { @UniqueConstraint(columnNames = "role_id") })
public class Role {

	public Long role_id;
	public String name;
	public String description;

	// Audit
	public User created_by;
	public Date created_on;
	public User changed_by;
	public Date changed_on;
	
	public Set<User> users = new HashSet<User>(0);
	public Set<Permission> permissions =new HashSet<Permission>(0);
	

	@Id
	@Column(name = "role_id", unique = true, nullable = false)
	@SequenceGenerator(name = "a_roles_role_id_seq", sequenceName = "a_roles_role_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "a_roles_role_id_seq")
	public Long getRole_id() {
		return role_id;
	}

	public void setRole_id(Long role_id) {
		this.role_id = role_id;
	}

	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "a_r_role_permissions", catalog = "public", joinColumns = { 
			@JoinColumn(name = "role_id", nullable = false, updatable = false) }, 
			inverseJoinColumns = { @JoinColumn(name = "permission_id", 
					nullable = false, updatable = false) })
	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}

	public Role(Long role_id, String name, String description, User created_by,
			Date created_on, User changed_by, Date changed_on) {
		super();
		this.role_id = role_id;
		this.name = name;
		this.description = description;
		this.created_by = created_by;
		this.created_on = created_on;
		this.changed_by = changed_by;
		this.changed_on = changed_on;
	}

	public Role(String name, String description, User created_by,
			Date created_on, User changed_by, Date changed_on) {
		super();
		this.name = name;
		this.description = description;
		this.created_by = created_by;
		this.created_on = created_on;
		this.changed_by = changed_by;
		this.changed_on = changed_on;
	}

	public Role(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}


	public Role(){
		
	}

}
