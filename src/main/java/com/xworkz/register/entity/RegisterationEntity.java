package com.xworkz.register.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "findByEmail", query = "from RegisterationEntity e where e.email = :email"),
		@NamedQuery(name = "updateByEmail", query = "update RegisterationEntity  e set e.otp = :otp where e.email = :email"),
		@NamedQuery(name = "updateAllDataByEmail",query="update RegisterationEntity e set e.name=:name, e.surName=:surName,e.address=:address,e.phoneNo=:phoneNo,e.zip=:zip,e.dateOfBirth=:dateOfBirth where e.email = :email"),
		@NamedQuery(name = "findByName", query = "from RegisterationEntity e where e.name like :name")})


@Entity
@Table(name = "register_table")
public class RegisterationEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "sur_name")
	private String surName;
	@Column(name = "dob")
	private String dateOfBirth;
	@Column(name = "address")
	private String address;
	@Column(name = "phone_no")
	private String phoneNo;
	@Column(name = "email")
	private String email;
	@Column(name = "zip")
	private String zip;
	@Column(name = "reg_password")
	private String password;
	@Column(name = "otp")
	private String otp;

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}
}
