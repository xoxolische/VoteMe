package com.voteme.model.mail;

import com.voteme.model.User;

public class ConfirmationMail extends Mail {

	private static final String APP_NAME = "";
	
	private String subject;

	public ConfirmationMail(User u, String contextPath) {
		super(u);
		String link = contextPath + "/users/confirmation?token="+u.getCode();
		this.getModel().put("activationLink", link);
		this.subject = "no-reply confirmation email";
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
