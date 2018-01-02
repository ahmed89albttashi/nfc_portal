package com.nfc.portal.entity;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="a_departments",catalog="public", uniqueConstraints = {
		@UniqueConstraint(columnNames = "department_id")})
public class Department {


	private int department_id;
	private String name_en;
	private String name_ar;
	private String description;
	private Staff head;
	private String code;
	private byte[] icon;
	
	private Department subOf;
	private Set<Department> subDepartment;
	private Set<Staff> staff;
	
	//Audit
	private User created_by;
	private Date created_on;
	private User changed_by;
	private Date changed_on;
	
	




	@Id
	@Column(name="department_id", unique = true, nullable = false)
	@SequenceGenerator(name="a_departments_department_id_seq", sequenceName="a_departments_department_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE ,generator="a_departments_department_id_seq")
	public int getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(int department_id) {
		this.department_id = department_id;
	}

	
	
	
	
	

	@Column(name="name_en")
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	 
	

	@Column(name="name_ar")
	public String getName_ar() {
		return name_ar;
	}
	public void setName_ar(String name_ar) {
		this.name_ar = name_ar;
	}
	
	
	
	@Column(name="description")
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	

	
	@Column(name="code")
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "head_id", nullable = true)
	
	public Staff getHead() {
		return head;
	}
	public void setHead(Staff head) {
		this.head = head;
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
	
	@Column(name="icon")
	@Lob
	public byte[] getIcon() {
		return icon;
	}
	public void setIcon(byte[] icon) {
		this.icon = icon;
	}
	
	

	@OneToMany(mappedBy="subOf")
	public Set<Department> getSubDepartment() {
		return subDepartment;
	}
	public void setSubDepartment(Set<Department> subDepartment) {
		this.subDepartment = subDepartment;
	}
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="sub_of")
	public Department getSubOf() {
		return subOf;
	}
	public void setSubOf(Department subOf) {
		this.subOf = subOf;
	}
	
	@OneToMany(mappedBy="department")
	public Set<Staff> getStaff() {
		return staff;
	}
	public void setStaff(Set<Staff> staff) {
		this.staff = staff;
	}
	
	
	
	
	
	
}
