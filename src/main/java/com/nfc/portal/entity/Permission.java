package com.nfc.portal.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;





@Entity
@Table(name="a_permissions", catalog="public", uniqueConstraints = {
		@UniqueConstraint(columnNames = "permission_id")})
public class Permission {

	public int permission_id;
	public String name;
	public String description;

	//Audit
	public User created_by;
	public Date created_on;
	public User changed_by;
	public Date changed_on;
	
	public Set<Role> roles = new HashSet<Role>(0);
	
	
	


	@Id
	@Column(name="permission_id", unique = true, nullable = false)
	@SequenceGenerator(name="a_permissions_permission_id_seq", sequenceName="a_permissions_permission_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="a_permissions_permission_id_seq")
	public int getPermission_id() {
		return permission_id;
	}
	public void setPermission_id(int permission_id) {
		this.permission_id = permission_id;
	}
	
	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="created_by")
	public User getCreated_by() {
		return created_by;
	}
	public void setCreated_by(User created_by) {
		this.created_by = created_by;
	}
	

	@Column(name="created_on",columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
	public Date getCreated_on() {
		return created_on;
	}
	public void setCreated_on(Date created_on) {
		this.created_on = created_on;
	}
	

	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="changed_by")
	public User getChanged_by() {
		return changed_by;
	}
	public void setChanged_by(User changed_by) {
		this.changed_by = changed_by;
	}
	

	@Column(name="changed_on",columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
	public Date getChanged_on() {
		return changed_on;
	}
	public void setChanged_on(Date changed_on) {
		this.changed_on = changed_on;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "permissions")
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	public Permission(String name, String description) {
		super();
		this.name = name;
		this.description = description;
	}
	
	public Permission(){
		
	}
	
}
