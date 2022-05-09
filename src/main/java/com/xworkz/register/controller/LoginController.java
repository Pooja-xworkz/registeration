package com.xworkz.register.controller;

import java.util.List;
import java.util.Optional;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import com.xworkz.register.entity.RegisterationEntity;
import com.xworkz.register.service.LoginService;

@Component

@RequestMapping("/")
public class LoginController {
	private static final Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private LoginService logservice;

	LoginController() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	@GetMapping("/login")

	public ModelAndView onLogin(@RequestParam("email") String email, Model model) {
		ModelAndView mav = new ModelAndView();
		RegisterationEntity entity = logservice.validateUser(email);

		if (entity != null && email.equals(entity.getEmail())) {
			System.out.println("hellooooooooooooooooo");
			String otppp = logservice.generateOTP(email);
			System.out.println(otppp);
			entity.setOtp(otppp);
			String otpe = entity.getOtp();

			logservice.sendEmail(email, otpe);
			System.out.println(entity.getOtp());
			logservice.updateotp(otpe, email);
			mav = new ModelAndView("OtpVerification");
			mav.addObject("entityEmail", entity.getEmail());
		} else {
			mav = new ModelAndView("logo");
			mav.addObject("message", "invalid email");
		}

		return mav;

	}

	@GetMapping("/otp")
	public ModelAndView onEnteringOtp(@RequestParam("otp") String otp, Model model) {
		ModelAndView mav = new ModelAndView();

		RegisterationEntity obj = logservice.validateOtp(otp);

		if (obj != null && otp.equals(obj.getOtp())) {
			System.out.println("hellooooooooooooooooo otp");
			System.out.println(obj.getOtp());
			mav = new ModelAndView("successss");
			mav.addObject("entityObject", obj);
			// System.out.println(obj);
		} else {
			mav = new ModelAndView("OtpVerification");
			mav.addObject("message", "invalid otp");
		}

		return mav;

	}

	@GetMapping("/success")
	public ModelAndView findById(@ModelAttribute("entity") RegisterationEntity entity ) {
		ModelAndView mav = new ModelAndView();
		String email=entity.getEmail();
		String name=entity.getName();
		System.out.println(email+" "+name);
		if(email!=null && !email.isEmpty()  ) {RegisterationEntity entity1 = logservice.userExist(email);
		if (entity1 != null && entity.getEmail().equals(entity1.getEmail())) {
			System.out.println("hellooooooooooooooooo success page");
			System.out.println(entity1.getName());
			mav = new ModelAndView("/successss");
			mav.addObject("success", entity1);
		}}else {
		 List<RegisterationEntity> name1=logservice.findByName(name);
		
       
		
			mav = new ModelAndView("successss");
			mav.addObject("success2", name1);
		}		
		return mav;

	}

	// @RequestMapping("/editemp/{email}" method = RequestMethod.GET)
	@RequestMapping(value = "/editemp/{email}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable(value = "email") String email, Model m) {
		System.out.println(email + " " + "ahksdbakjbsd");
		RegisterationEntity emp = logservice.userExist(email);
		System.out.println(emp.getName());
		System.out.println("ashyayhdsa");
		ModelAndView mav = new ModelAndView("/successss");
		mav.addObject("command", emp);

		return mav;
	}

	@PostMapping("/editemp/editsave/{email}")
	public ModelAndView editsave(@ModelAttribute("entity") RegisterationEntity entity) {
		int ent = logservice.update(entity);
		System.out.println(ent);
		RegisterationEntity entity1 = logservice.userExist(entity.getEmail());

		ModelAndView mav = new ModelAndView("//successss");
		mav.addObject("msg", entity1);
		return mav;

	}

}
