package com.xworkz.register.repo;

import java.util.List;

import com.xworkz.register.entity.LoginEntity;
import com.xworkz.register.entity.RegisterationEntity;

public interface LoginDao {
	public RegisterationEntity validateUser(String email);
	public RegisterationEntity validateOtp(String Otp);
	public RegisterationEntity userExist(String email);
	public int updateotp(String otp,String email);
	public int update(RegisterationEntity entity);
public List<RegisterationEntity> findByName(String name);
}
