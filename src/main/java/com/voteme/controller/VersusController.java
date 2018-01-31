package com.voteme.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/versus")
public class VersusController {

	@RequestMapping(value = "/create")
	public String createVersusPage() {
		return "createVersus";
	}
	
	@RequestMapping(value = "/show/{id}")
	public String showVersusPage() {
		return "showVersus";
	}

}
