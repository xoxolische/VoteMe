package com.voteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.voteme.service.VersusMarkService;

@Controller
public class VersusController {
	
	@Autowired
	private VersusMarkService m;
	
	@RequestMapping(value = "/createVersus")
	public String createVersusPage() {
		return "createVersus";
	}
}
