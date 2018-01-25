package com.voteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.voteme.service.VersusService;

@Controller
public class MainController {
	
	@Autowired
	private VersusService versusService;
	
	
	@RequestMapping(value = {"/", "home"})
	public String homePage(Model model) {
		//model.addAttribute("versuses", versusService.getAll());
		return "home";
	}
	
	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

}
