package com.xworkz.register.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;



public class RegisterationDto {
	private int id;
	@NotBlank(message = "* user name cannot be blank")
	@Size(min = 3, max = 15)
	private String name;
	@NotBlank(message = "* sur_name cannot be blank")
	@Size(min = 3, max = 15)
	private String surName;
	@NotBlank(message = "* date_of_birth cannot be blank")
	private String dateOfBirth;
	@NotEmpty(message = "address cannot be empty")
	private String address;
	@NotBlank(message = "Phone number cannot be blank")
	@Size(min = 1, max = 10)
	private String phoneNo;
	
	private String email;
	@NotEmpty(message = "zip cannot be empty")
	@Size(min = 4, max = 9)
	private String zip;
}
