package com.voteme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	// @Autowired
	// private OpinionMarkService opMarkService;

	@RequestMapping(value = { "/", "home" })
	public String homePage(Model model) {
		return "home";
	}

	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	@RequestMapping(value = "/404")
	public String page404() {
		return "404";
	}

	@RequestMapping(value = "/403")
	public String page403() {
		return "403";
	}

	@RequestMapping(value = "/500")
	public String page500() {
		return "500";
	}

	@GetMapping(value = "/register")
	public String registerPage(Model model) {
		return "registerUser";
	}

}
