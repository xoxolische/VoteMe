package com.voteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.voteme.dao.VersusMarkDao;

@Controller
public class MainController {
	
	@Autowired
	private VersusMarkDao m;
	
	
	@RequestMapping(value = {"/", "home"})
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

}
