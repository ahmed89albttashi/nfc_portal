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
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
@Table(name = "a_staffs", catalog = "public", uniqueConstraints = {
		@UniqueConstraint(columnNames = "staff_id") })
public class Staff {
	

	
	@Id
	@Column(name = "staff_id", unique = true, nullable = false)
	private Long staff_id;
	
	@Column(name="id_number")
	private String id_number;
	
	@OneToOne(mappedBy="staff")
	private User user;
	
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


	@Column(name="status")
	private String status;
	
	@Column(name="mobile")
	private String mobile;
	
	@Column(name="cpn")
	private String cpn;
	
	@Column(name="telephone")
	private String telephone;
	
	
	@Column(name="gender")
	private String gender;

	@Column(name="nationality")
	private String nationality;
	

	@Column(name="dob",columnDefinition = "timestamp without time zone",nullable=true)
	@DateTimeFormat(pattern="dd/MM/yyyy")
	private Date dob;
	
	@Column(name="live_in")
	private String live_in;
	

	@Column(name="join_on")
	private Date join_on;
	
	
	
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

	

	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
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


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getNationality() {
		return nationality;
	}


	public void setNationality(String nationality) {
		this.nationality = nationality;
	}


	public Date getDob() {
		return dob;
	}


	public void setDob(Date dob) {
		this.dob = dob;
	}


	public String getLive_in() {
		return live_in;
	}


	public void setLive_in(String live_in) {
		this.live_in = live_in;
	}


	public Date getJoin_on() {
		return join_on;
	}


	public void setJoin_on(Date join_on) {
		this.join_on = join_on;
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

	

	public String getMobile() {
		return mobile;
	}


	public void setMobile(String mobile) {
		this.mobile = mobile;
	}


	public String getCpn() {
		return cpn;
	}


	public void setCpn(String cpn) {
		this.cpn = cpn;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	


	public String getId_number() {
		return id_number;
	}


	public void setId_number(String id_number) {
		this.id_number = id_number;
	}

	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Staff [staff_id=" + staff_id + ", id_number=" + id_number + ", fName_ar=" + fName_ar + ", sName_ar="
				+ sName_ar + ", tName_ar=" + tName_ar + ", familyName_ar=" + familyName_ar + ", fullName_ar="
				+ fullName_ar + ", fName_en=" + fName_en + ", sName_en=" + sName_en + ", tName_en=" + tName_en
				+ ", familyName_en=" + familyName_en + ", fullName_en=" + fullName_en + ", mobile=" + mobile + ", cpn="
				+ cpn + ", telephone=" + telephone + ", gender=" + gender + ", nationality=" + nationality + ", dob="
				+ dob + ", live_in=" + live_in + ", join_on=" + join_on + ", grade=" + grade + ", position=" + position
				+ ", positionType=" + positionType + ", subOrdinate=" + subOrdinate + ", department=" + department
				+ ", created_on=" + created_on + ", changed_on=" + changed_on + "]";
	}




	

	
	
	
	
	
	
	
	
	
	
	
}
