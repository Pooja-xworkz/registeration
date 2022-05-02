package com.xworkz.register.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.xworkz.register.entity.LoginEntity;
import com.xworkz.register.entity.RegisterationEntity;
import com.xworkz.register.service.LoginService;

@Component
@RequestMapping("/")
public class LoginController {
	private static final Logger logger=Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService logservice;
	
	LoginController(){
		logger.info("created " + this.getClass().getSimpleName());
	}
	@GetMapping("/login")
	public ModelAndView onLogin(@RequestParam("email") String email, Model model) {
		ModelAndView mav = new ModelAndView();
		Object entity = logservice.validateUser(email);

	    if (email.equals(entity)) {
	    	System.out.println("hellooooooooooooooooo");
	    mav = new ModelAndView("OtpVerification");
	    mav.addObject("entityEmail", entity );
	    } else {
	    mav = new ModelAndView("logo");
	    mav.addObject("message", "invalid email");
	    }

	    return mav;
		
	}
	@GetMapping("/otp")
	public ModelAndView onEnteringOtp(@RequestParam("otp") String otp,Model model) {
		ModelAndView mav = new ModelAndView();
		
		RegisterationEntity obj = logservice.validateOtp(otp);

	    if (obj!=null && otp.equals(obj.getOtp())) {
	    	System.out.println("hellooooooooooooooooo otp");
	    	System.out.println(obj.getOtp());
	    mav = new ModelAndView("successss");
	    mav.addObject("entityObject", obj);
	    System.out.println(obj);
	    } else {
	    mav = new ModelAndView("OtpVerification");
	    mav.addObject("message", "invalid otp");
	    }

	    return mav;
		
	}
	
	
	@GetMapping("/success")
	public ModelAndView onSubmit(@RequestParam("email") String email, Model model) {
		ModelAndView mav = new ModelAndView();
		RegisterationEntity entity = logservice.userExist(email);

	    if (entity!=null && email.equals(entity.getEmail())) {
	    	System.out.println("hellooooooooooooooooo success page");
	    mav = new ModelAndView("successss");
	    mav.addObject("success", entity );
	    } else {
	    	
	    mav = new ModelAndView("successss");
	    mav.addObject("message", "invalid email");
	    }

	    return mav;
		
	}
	
	
	
}
