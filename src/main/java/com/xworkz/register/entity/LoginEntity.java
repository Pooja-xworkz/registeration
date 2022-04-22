package com.xworkz.register.entity;

import org.apache.log4j.Logger;

public class LoginEntity {
	private Logger logger = Logger.getLogger(LoginEntity.class);
	private String email;
	private String password;

	public LoginEntity() {
		logger.debug("{} Is Created..........." + this.getClass().getSimpleName());

	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
