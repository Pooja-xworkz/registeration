package com.xworkz.register.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xworkz.register.entity.LoginEntity;
import com.xworkz.register.entity.RegisterationEntity;
import com.xworkz.register.repo.LoginDao;
import com.xworkz.register.repo.RegisterationDaoImpl;
@Component
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
	
	LoginServiceImpl(){
		logger.info("created " + this.getClass().getSimpleName());
	}
	
	@Autowired
	LoginDao logindao;
	 public String validateUser(String email ) {
		return logindao.validateUser(email);
		
	}
	@Override
	public RegisterationEntity validateOtp(String Otp) {
		return logindao.validateOtp(Otp);
	}
	@Override
	public RegisterationEntity userExist(String email) {
		return logindao.userExist(email);
	}
}
