package com.xworkz.register.repo;

import java.util.List;

import com.xworkz.register.entity.RegisterationEntity;

public interface RegisterationDao {
	public void register(RegisterationEntity regEntity);
	public List<RegisterationEntity> findByEmail(String email);

}
