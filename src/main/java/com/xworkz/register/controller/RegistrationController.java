package com.xworkz.register.controller;



import org.apache.log4j.Logger;
import org.hibernate.bytecode.enhance.internal.javassist.EntityEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.xworkz.register.entity.RegisterationEntity;
import com.xworkz.register.service.RegisterationService;

@Component
@RequestMapping("/")
public class RegistrationController {
	private static final Logger logger = Logger.getLogger(RegistrationController.class);

	@Autowired
	private RegisterationService service;

	RegistrationController() {
		logger.info("created " + this.getClass().getSimpleName());
	}

	/*
	 * @GetMapping("/register") public ModelAndView passParametersWithModelAndView()
	 * { ModelAndView modelAndView = new ModelAndView("Registeration");
	 * modelAndView.addObject("register", new RegisterationEntity());
	 * modelAndView.addObject("message", "failed to register"); return modelAndView;
	 * }
	 */
	
	@PostMapping("/registerprocess")
	public ModelAndView onRegister(@ModelAttribute RegisterationEntity entity, Model model) {
	
		ModelAndView mav = new ModelAndView();
		if(entity!=null) {
		service.validateAndSave(entity);
		model.addAttribute("success", "Registered Successfully" + entity.getName());
		return mav;
		}else {
			model.addAttribute("register");
			model.addAttribute("message", "failed to register");
		}
		return mav;
	
		
	}
}
