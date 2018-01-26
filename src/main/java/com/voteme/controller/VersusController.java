package com.voteme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class VersusController {

	@RequestMapping(value = "/createVersus")
	public String createVersusPage() {
		return "createVersus";
	}
	
	@RequestMapping(value = "/showVersus")
	public String showVersusPage() {
		return "showVersus";
	}

}
