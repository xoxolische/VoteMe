package com.voteme.model.mail;

import java.util.HashMap;
import java.util.Map;

import com.voteme.model.User;

public class Mail {

	private static final String FROM = "votemeproject@gmail.com";
	private String to;
	private Map<String, String> model;

	public Mail(User u) {
		this.to = u.getEmail();
		this.model = new HashMap<>();
		model.put("name", u.getNickName());
	}

	public String getFrom() {
		return FROM;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public Map<String, String> getModel() {
		return model;
	}

	public void setModel(Map<String, String> model) {
		this.model = model;
	}

}