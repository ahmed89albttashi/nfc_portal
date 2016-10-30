package com.nfc.portal.entity;

import java.util.Date;
import java.util.Set;

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

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "a_staffs", catalog = "public", uniqueConstraints = {
		@UniqueConstraint(columnNames = "staff_id") })
public class Staff {
	

	
	@Id
	@Column(name = "staff_id", unique = true, nullable = false)
	@SequenceGenerator(name = "staff_id_seq", sequenceName = "staff_id_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "staff_id_seq")
	private Long staff_id;
	
	@Column(name="fname_ar")
	private String fName_ar;

	@Column(name="sname_ar")
	private String sName_ar;
	
	@Column(name="tname_ar")
	private String tName_ar;

	@Column(name="family_name_ar")
	private String familyName_ar;

	@Column(name="full_name_ar")
	private String fullName_ar;
	

	@Column(name="fname_en")
	private String fName_en;

	@Column(name="sname_en")
	private String sName_en;

	@Column(name="tname_en")
	private String tName_en;

	@Column(name="family_name_en")
	private String familyName_en;

	@Column(name="full_name_en")
	private String fullName_en;

	
	@Column(name="grade")
	private String grade;

	@Column(name="position")
	private String position;

	@Column(name="position_type")
	private String positionType;

	@ManyToOne
	@JoinColumn(name="manager_id")
	private Staff manager;

	@OneToMany(mappedBy="manager")
	private Set<Staff> subOrdinate;
	

	@ManyToOne
	@JoinColumn(name="department_id")
	private Department department;


	
	/*Audit*/
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "created_by")
	public User created_by;
	

	@Column(name = "created_on",columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
	public Date created_on;
	

	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "changed_by")
	public User changed_by;

	@Column(name = "changed_on",columnDefinition = "timestamp without time zone")
    @Temporal(TemporalType.TIMESTAMP)
	public Date changed_on;


	
	
	/*Getters Setters*/
	
	
	public Long getStaff_id() {
		return staff_id;
	}


	public void setStaff_id(Long staff_id) {
		this.staff_id = staff_id;
	}


	public String getfName_ar() {
		return fName_ar;
	}


	public void setfName_ar(String fName_ar) {
		this.fName_ar = fName_ar;
	}


	public String getsName_ar() {
		return sName_ar;
	}


	public void setsName_ar(String sName_ar) {
		this.sName_ar = sName_ar;
	}


	public String gettName_ar() {
		return tName_ar;
	}


	public void settName_ar(String tName_ar) {
		this.tName_ar = tName_ar;
	}


	public String getFamilyName_ar() {
		return familyName_ar;
	}


	public void setFamilyName_ar(String familyName_ar) {
		this.familyName_ar = familyName_ar;
	}


	public String getFullName_ar() {
		return fullName_ar;
	}


	public void setFullName_ar(String fullName_ar) {
		this.fullName_ar = fullName_ar;
	}


	public String getfName_en() {
		return fName_en;
	}


	public void setfName_en(String fName_en) {
		this.fName_en = fName_en;
	}


	public String getsName_en() {
		return sName_en;
	}


	public void setsName_en(String sName_en) {
		this.sName_en = sName_en;
	}


	public String gettName_en() {
		return tName_en;
	}


	public void settName_en(String tName_en) {
		this.tName_en = tName_en;
	}


	public String getFamilyName_en() {
		return familyName_en;
	}


	public void setFamilyName_en(String familyName_en) {
		this.familyName_en = familyName_en;
	}


	public String getFullName_en() {
		return fullName_en;
	}


	public void setFullName_en(String fullName_en) {
		this.fullName_en = fullName_en;
	}


	public String getGrade() {
		return grade;
	}


	public void setGrade(String grade) {
		this.grade = grade;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getPositionType() {
		return positionType;
	}


	public void setPositionType(String positionType) {
		this.positionType = positionType;
	}


	public Staff getManager() {
		return manager;
	}


	public void setManager(Staff manager) {
		this.manager = manager;
	}


	public Set<Staff> getSubOrdinate() {
		return subOrdinate;
	}


	public void setSubOrdinate(Set<Staff> subOrdinate) {
		this.subOrdinate = subOrdinate;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
	
	
	
	
	
	
}
