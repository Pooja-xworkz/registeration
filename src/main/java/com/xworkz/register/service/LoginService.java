package com.xworkz.register.service;


import com.xworkz.register.entity.RegisterationEntity;

public interface LoginService {
	public String validateUser(String email);
	public RegisterationEntity validateOtp(String Otp);
	public RegisterationEntity userExist(String email);
}
