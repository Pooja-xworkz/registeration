package com.xworkz.register.service;

import com.xworkz.register.dto.RegisterationDto;
import com.xworkz.register.entity.RegisterationEntity;

public interface RegisterationService {
	public boolean validateAndSave(RegisterationEntity regentity);

	
	

}
