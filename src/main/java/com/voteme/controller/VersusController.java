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
	
	@RequestMapping(value = "/hib")
	public String test1(Model model) {
		model.addAttribute("mark", m.get(1));
		return "test";
	}
}
