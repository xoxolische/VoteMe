package com.voteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.voteme.service.RoleService;
import com.voteme.service.UserService;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;

	@GetMapping(value = "/")
	public String allUsersPage(Model model) {
		model.addAttribute("userList", userService.getAll());
		return "usersPage";
	}
	
	@GetMapping(value = "/create")
	public String createPage(Model model) {
		model.addAttribute("roles", roleService.getAll());
		return "registration";
	}

	@GetMapping(value = "/{id}")
	public String userInfoPage(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.get(id));
		return "userInfoPage";
	}

	@GetMapping(value = "/update/{id}")
	public String userUpdateInfoPage(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.get(id));
		return "userInfoPage";
	}

}
