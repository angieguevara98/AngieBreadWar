package com.angiebreadwar.app.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.angiebreadwar.app.model.User;
import com.angiebreadwar.app.services.UserService;


@Controller
public class UserController 
{
 
	private static final Logger logger =  LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/admin/menu")
	public String menu() {

		return "/admin/menu";
	}
	
	
	@GetMapping("/admin/emp/list")
	public String list(@ModelAttribute("SpringWeb") User user, ModelMap model) {

		try {
			model.addAttribute("usuarios", userService.findAll());
		} catch (Exception e) {
			logger.info(e.getMessage());
			model.addAttribute("message", e.getMessage());
		}

		return "admin/emp/list";
	}
	
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@GetMapping("/{id}")
	public ModelAndView home(@PathVariable int id, ModelMap model) {

		ModelAndView modelAndView = null;
		User user = new User();
		try {
			user = userService.find(id);
			logger.info(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		modelAndView = new ModelAndView("home", "command", user);

		return modelAndView;
	}
	
	@GetMapping("/admin/emp/{action}/{id}")
	public ModelAndView form(@PathVariable String action, @PathVariable int id, ModelMap model) {

		// action = {"editform","deleteform"}
		logger.info("action = " + action);
		ModelAndView modelAndView = null;

		try {
			User user = userService.find(id);
			logger.info(user.toString());
			modelAndView = new ModelAndView("admin/emp/" + action, "command", user);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("admin/emp/" + action, "command", new User());
		}

		return modelAndView;
	}
	
	@PostMapping("/admin/emp/editsave")
	public ModelAndView editsave(@ModelAttribute("SpringWeb") User user, ModelMap model) {

		
		logger.info("user = " + user);
		
		ModelAndView modelAndView = null;

		try {
			userService.update(user.getCodigo(), user.getPassword(), user.getName(), user.getEmail(),
					user.getTipo());

			modelAndView = new ModelAndView("redirect:/admin/emp/list");
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
			modelAndView = new ModelAndView("redirect:/admin/emp/list");
		}

		return modelAndView;
	}
}
