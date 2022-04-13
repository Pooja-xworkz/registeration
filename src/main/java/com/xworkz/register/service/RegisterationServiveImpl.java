package com.xworkz.register.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.xworkz.register.entity.RegisterationEntity;
import com.xworkz.register.repo.RegisterationDao;

@Component
public class RegisterationServiveImpl implements RegisterationService {
	private static final Logger logger = Logger.getLogger(RegisterationServiveImpl.class);

	@Autowired
	private RegisterationDao regDao;

	RegisterationServiveImpl() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	// Pattern ptr=Pattern.compile("(0/91)?[7-9][0-9]{9}");
	String regPhNo = "[6-9][0-9]{9}";
	String regeEmail = "^(.+)@(.+)$";
	String address = "^[#.0-9a-zA-Z\\s,-]+$";
	String zip = "^[1-9][0-9]{5}$";

	@Override
	public boolean validateAndSave(RegisterationEntity regentity) {
		boolean flag = true;
		try {
			if (regentity != null) {
				if (regentity.getName().length() < 16) {
				} else {
					flag = false;
					logger.info("invalid name");

				}
				if (regentity.getSurName().length() < 16) {
				} else {
					flag = false;
					logger.info("invalid surname");
				}
				if (regentity.getEmail().matches(regeEmail)) {

				}

				else {
					flag = false;
					logger.info("invalid email id");
				}
				if (regentity.getPhoneNo().matches(regPhNo)) {
				}

				else {
					flag = false;
					logger.info("invalid phoneno");
				}
				if (regentity.getDateOfBirth() != null) {
				}

				else {
					flag = false;
					logger.info("invalid date of birth");
				}
				if (regentity.getAddress().matches(address)) {

				} else {
					flag = false;
					logger.info("invalid address");
				}
				if (regentity.getZip().matches(zip)) {
				} else {
					flag = false;
					logger.info("invalid zip code");
				}

			} else {
				logger.info("entity is null or empty");
			}

			if (flag) {
				regDao.register(regentity);
			}
			return flag;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		}
		return flag;

	}
	/*
	 * public RegisterationDto convertEntityToDto(RegisterationEntity entity) {
	 * RegisterationDto regDto=mapper.map(entity, RegisterationDto.class);
	 * 
	 * 
	 * regDto.setId(entity.getId()); regDto.setName(entity.getName());
	 * regDto.setSurName(entity.getSurName());
	 * regDto.setDateOfBirth(entity.getDateOfBirth());
	 * regDto.setAddress(entity.getAddress()); regDto.setEmail(entity.getEmail());
	 * regDto.setPhoneNo(entity.getPhoneNo()); regDto.setZip(entity.getZip());
	 * 
	 * return regDto;
	 * 
	 * }
	 */

}
