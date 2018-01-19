package com.voteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.voteme.dao.MarkDao;

@Controller
public class MainController {
	
	@Autowired
	private MarkDao m;
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String test() {
//		HibernateUtil.getSessionFactory();
//		m.get(1);
//		return "test";
//	}
	
	@RequestMapping(value = "/test")
	//@ResponseBody
	public String test1() {
		//model.addAttribute("mark", m.get(1));
		//m.get(1);
		return "test";
	}
	
	@RequestMapping(value = {"/", "home"})
	public String homePage() {
		return "home";
	}
	
	@RequestMapping(value = "/login")
	public String loginPage() {
		return "login";
	}

	@GetMapping(value = "/registration")
	public String userRegisrationPage(Model model) {	
		return "userRegistrationPage";
	}

}