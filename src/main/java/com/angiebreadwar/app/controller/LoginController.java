package com.angiebreadwar.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.angiebreadwar.app.exception.DAOException;
import com.angiebreadwar.app.exception.LoginException;
import com.angiebreadwar.app.model.User;
import com.angiebreadwar.app.services.SecurityService;

public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private SecurityService securityService;

/*	
	@GetMapping("/")
	public String menu() {

		return "/login";
	}
*/
	
	//@GetMapping("/login")
	@GetMapping(value={"/", "login"})
	public ModelAndView preLogin() {
		User user = new User();
		return new ModelAndView("login", "command", user);
	}

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@PostMapping("/login")
	public ModelAndView login(@ModelAttribute("SpringWeb") User user, ModelMap model) {

		
		logger.info("login()");
		logger.info(user.toString());

		ModelAndView modelAndView = null;

		try {
			User emp = securityService.validate(user.getCodigo(), user.getPassword());
			logger.info(emp.toString());
			modelAndView = new ModelAndView("redirect:/admin/menu", "command", emp);
		} catch (LoginException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", "Usuario y/o clave incorrectos");
			modelAndView = new ModelAndView("login", "command", new User());
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("login", "command", new User());
		}

		return modelAndView;
	}
	
	

}