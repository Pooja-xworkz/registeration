package com.xworkz.register.service;

import java.util.List;

import com.xworkz.register.entity.RegisterationEntity;

public interface RegisterationService {
	public String validateAndSave(RegisterationEntity regentity);
//public String sendEmail(String email ,String otp);
	public String generateRandomPassword(int len);
	//public String generateOTP();

}
