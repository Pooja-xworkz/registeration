package com.xworkz.register.repo;

import com.xworkz.register.entity.LoginEntity;
import com.xworkz.register.entity.RegisterationEntity;

public interface LoginDao {
	public String validateUser(String email);
	public RegisterationEntity validateOtp(String Otp);
	public RegisterationEntity userExist(String email);

}
