package com.msayem.controller;

import java.util.Map;
import java.security.Principal;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.msayem.entity.User;
import com.msayem.service.UserService;
import com.msayem.service.RoleService;

/**
 * Handles all requests for the applicatio.
 * 
 * @author MSAYEM
 * 
 */
@Controller
public class IndexController {

	private final Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@RequestMapping("/")
	public String home() {

		logger.info("spring-security-with-hibernate-mysql: home.jsp page has been executed.");
		return "home";
	}

	@RequestMapping(value="/register")      
	public String register(Map<String, Object> map) {

		map.put("user", new User());

		logger.info("spring-security-with-hibernate-mysql: register.jsp page has been executed.");
		return "register";
	}

	@RequestMapping(value = "/add-edit", method = RequestMethod.POST)
	public String addContact(@ModelAttribute("user") 
		User user, BindingResult result) {

		if(user.getId() == null) {

			userService.addUser(user);

			logger.info("spring-security-with-hibernate-mysql: Registration Successful!");
			return "redirect:/register?success=true";
		}
		else {

			userService.updateUser(user);

			logger.info("spring-security-with-hibernate-mysql: Update Successful!");
			return "redirect:/register?update=true";
		}

	}
    
	@RequestMapping("/edit/{id}")
	public String editUser(@PathVariable("id") Integer id, Map<String, Object> map) {

		map.put("user", userService.getUserById(id));
		map.put("userList", userService.listUser());

		logger.info("spring-security-with-hibernate-mysql: register.jsp page has been executed.");
		return "register";
	}

	@RequestMapping(value="/listUsers")      
	public String showUsers(Map<String, Object> map) {

		map.put("user", new User());
		map.put("userList", userService.listUser());

		logger.info("spring-security-with-hibernate-mysql: userList.jsp page has been executed.");
		return "listUsers";
	}

	@RequestMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId") Integer userId) {

		userService.deleteUser(userId);

		logger.info("spring-security-with-hibernate-mysql: User Deleted Successfuly!");
		return "redirect:/listUsers";
	}

	@RequestMapping("/login")
	public String login() {

		logger.info("spring-security-with-hibernate-mysql: login.jsp page has been executed.");
		return "login";
	}


	@RequestMapping("/listUsers/{id}")
	public String detail(Model model, @PathVariable int id) {

		model.addAttribute("user", userService.getUserById(id));

		logger.info("spring-security-with-hibernate-mysql: userDetail.jsp page has been executed.");
		return "user-detail";
	}

	@RequestMapping("/account")
	public String account(Model model, Principal principal) {

		String name = principal.getName();
		model.addAttribute("user", userService.getUserByName(name));

		logger.info("spring-security-with-hibernate-mysql: userDetail.jsp page has been executed.");
		return "user-detail";
	}
}