package com.xworkz.register.service;

import java.util.List;

import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import com.xworkz.register.entity.LoginEntity;
import com.xworkz.register.entity.RegisterationEntity;
import com.xworkz.register.repo.LoginDao;
import com.xworkz.register.repo.RegisterationDaoImpl;
@Component
public class LoginServiceImpl implements LoginService {
	private static final Logger logger = Logger.getLogger(LoginServiceImpl.class);
	@Autowired
    private JavaMailSender mailSender;
	
	LoginServiceImpl(){
		logger.info("created " + this.getClass().getSimpleName());
	}
	
	@Autowired
	LoginDao logindao;
	 public RegisterationEntity validateUser(String email ) {
		return logindao.validateUser(email);
		
	}
	 @Override
	 public  String generateOTP(String email) 
    { 
        int randomPin   =(int) (Math.random()*9000)+1000;
        String otp  = String.valueOf(randomPin);
		/*
		 * entity.setOtp(otp); String otp2= entity.getOtp();
		 */
        return otp; 
    }
	@Override
	public RegisterationEntity validateOtp(String Otp) {
		return logindao.validateOtp(Otp);
	}
	@Override
	public RegisterationEntity userExist(String email) {
		return logindao.userExist(email);
	}
	@Override
	public void sendEmail(String email, String otp) {
		SimpleMailMessage email1=new SimpleMailMessage();
		email1.setFrom("poojasp2394@gmail.com");
		email1.setTo(email);
		email1.setSubject("ghggki");
		email1.setText(otp);
		mailSender.send(email1);
		
		
	}	
	public int updateotp(String otp,String email) {
		return logindao.updateotp(otp,email);
	}
	
	public int update(RegisterationEntity entity){    
	       
	    return logindao.update(entity);    
	}
	@Override
	public List<RegisterationEntity> findByName(String name) {
		return logindao.findByName(name);
	}
	
		
	}
	

