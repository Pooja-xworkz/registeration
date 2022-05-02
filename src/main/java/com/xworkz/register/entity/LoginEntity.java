package com.xworkz.register.entity;

import javax.persistence.Entity;

@Entity
public class LoginEntity {
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

}
