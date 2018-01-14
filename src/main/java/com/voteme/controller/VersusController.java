package com.voteme.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.voteme.dao.MarkDao;

@Controller
public class VersusController {
	
	@Autowired
	MarkDao m;
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String test() {
//		HibernateUtil.getSessionFactory();
//		m.get(1);
//		return "test";
//	}
	
	@RequestMapping(value = {"/test1", "/", ""}, method = RequestMethod.GET)
	//@ResponseBody
	public String test1(Model model) {
		
		return "test";
	}


}
