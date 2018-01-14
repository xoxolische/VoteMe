package com.voteme.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.voteme.dao.MarkDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.Mark;

@Controller
public class MainController {
	
	@Autowired
	MarkDao m;
	
//	@RequestMapping(value = "/test", method = RequestMethod.GET)
//	public String test() {
//		HibernateUtil.getSessionFactory();
//		m.get(1);
//		return "test";
//	}
	
	@RequestMapping(value = "/test1", method = RequestMethod.GET)
	public String test1() {
		
		return "test";
	}


}
