package com.xworkz.register.service;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Base64.Encoder;
import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import com.xworkz.register.entity.RegisterationEntity;
import com.xworkz.register.repo.RegisterationDao;

@Component
public class RegisterationServiveImpl implements RegisterationService {
	private static final Logger logger = Logger.getLogger(RegisterationServiveImpl.class);

	@Autowired
    private JavaMailSender mailSender;
	
	@Autowired
	private RegisterationDao regDao;

	RegisterationServiveImpl() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	// Pattern ptr=Pattern.compile("(0/91)?[7-9][0-9]{9}");
	String regPhNo = "[6-9][0-9]{9}";
	String dateOfBirth = "^[0-3]?[0-9].[0-3]?[0-9].(?:[0-9]{2})?[0-9]{2}$";
	String regeEmail = "^(.+)@(.+)$";
	String address = "^[#.0-9a-zA-Z\\s,-]+$";
	String zip = "^[1-9][0-9]{5}$";

	@Override
	public String validateAndSave(RegisterationEntity regentity) {
		String flag = null;
		try {
			if (regentity != null) {
				if (regentity.getName().length() < 16) {
				} else {
					flag = "Invalid Name";
					logger.error("invalid name");

				}
				if (regentity.getSurName().length() < 16) {
				} else {
					flag = "Invalid SurName";
					logger.error("invalid surname");
				}
				if (regentity.getEmail().matches(regeEmail)) {
					String email = regentity.getEmail();
					System.out.println(email);
					
					List<RegisterationEntity> entities = regDao.findByEmail(email);
					// System.out.println(entities.size());
					if (entities.size() > 0) {
						 flag = "email already exist";
						System.out.println("Email already exist");
					} else {
						
						System.out.println("no email id exist");
						Encoder encoder = Base64.getEncoder();
						String pwd = generateRandomPassword(8);
						String encodeString = encoder.encodeToString(pwd.getBytes());
						System.out.println("Encripted value " + " " + encodeString);
						regentity.setPassword(encodeString);
						String password=regentity.getPassword();
						regDao.register(regentity);
						sendEmail(email, password);
						
					}

				} else {
					flag = "Invalid email id";
					logger.error("invalid email id");
				}

				if (regentity.getPhoneNo().matches(regPhNo)) {
				}

				else {
					flag = "Invalid PhoneNo";
					logger.error("invalid phoneno");
				}
				if (regentity.getDateOfBirth().matches(dateOfBirth)) {
				}

				else {
					flag = "Invalid Date Of Birth";
					logger.error("invalid date of birth");
				}
				if (regentity.getAddress().matches(address)) {

				} else {
					flag = "Invalid Address";
					logger.error("invalid address");
				}
				if (regentity.getZip().matches(zip)) {
				} else {
					flag = "Invalid ZipCode";
					//String message="invalid zip code";
					logger.error("invalid zip code");
				}
				
				if(flag==null) {
					//regDao.register(regentity);
						//System.out.println("hii");
					
					regDao.register(regentity);

					}

		
			}

			else {
				logger.info("entity is null or empty");
			}
			} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return flag;
		
		
	}

	

	@Override
	public String generateRandomPassword(int len) {
		final String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		SecureRandom random = new SecureRandom();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < len; i++) {
			int randomIndex = random.nextInt(chars.length());
			sb.append(chars.charAt(randomIndex));
		}
		return sb.toString();
	}



	@Override
	public String sendEmail(String email,String password) {
		
		
		SimpleMailMessage email1=new SimpleMailMessage();
		email1.setFrom("poojasp2394@gmail.com");
		email1.setTo(email);
		email1.setSubject("ghggki");
		email1.setText(password);
		mailSender.send(email1);
		return password;
				
		
	}

}
