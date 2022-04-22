package com.xworkz.register.controller;





import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.xworkz.register.entity.RegisterationEntity;
import com.xworkz.register.service.RegisterationService;

@Component
@RequestMapping("/")
public class RegistrationController {
	//private static final Logger logger = Logger.getLogger(RegistrationController.class);

	private static final Logger logger=Logger.getLogger(RegistrationController.class);
	
	@Autowired
	private RegisterationService service;

	RegistrationController() {
		logger.info("created " + this.getClass().getSimpleName());
	}
	
	@PostMapping("/register")
	public ModelAndView onRegister(@ModelAttribute RegisterationEntity entity, Model model) {
	
		ModelAndView mav = new ModelAndView();
		if(!StringUtils.isEmpty(entity.getEmail())) {
			mav=new ModelAndView("success");
		String valid=service.validateAndSave(entity);
		if(valid==null) {
		model.addAttribute("success", "Registered Successfully " + entity.getName());
		return mav;
		}else {
			mav=new ModelAndView("register");
			model.addAttribute("error_message", valid);
		}
		}else {
			mav=new ModelAndView("register");
			model.addAttribute("message", "registeration failed");
			return mav;
			
		}
		return mav;
		
		
		
		
	}
}
