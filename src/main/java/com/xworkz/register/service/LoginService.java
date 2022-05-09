package com.xworkz.register.service;


import java.util.List;

import com.xworkz.register.entity.RegisterationEntity;

public interface LoginService {
	public RegisterationEntity validateUser(String email);
	public RegisterationEntity validateOtp(String Otp);
	public RegisterationEntity userExist(String email);
	//public  String generateOTP(String email,RegisterationEntity entity) ;
	 public  String generateOTP(String email) ;
	 public void sendEmail(String email, String otp);
	 public int updateotp(String otp,String email);
	 public int update(RegisterationEntity entity);
	 public List<RegisterationEntity> findByName(String name);
}
