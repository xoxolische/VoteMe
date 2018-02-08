package com.voteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.voteme.service.VersusService;

@Controller
public class MainController {

	@Autowired
	private VersusService versusService;
	


	// @Autowired
	// private OpinionMarkService opMarkService;

	@RequestMapping(value = { "/", "home" })
	public String homePage(Model model) {
		model.addAttribute("versuses", versusService.getAll());
		// OpinionMark op = opMarkService.getCouple(1, 3);
		// if(op != null) {
		// System.out.println("error, user already voted for another opinion;
		// id="+op.getOpinion().getId());
		// }else {
		// System.out.println("all clear, u can vote for this opinion!");
		// }
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
