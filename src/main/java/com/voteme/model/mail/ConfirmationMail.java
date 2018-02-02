package com.voteme.model.mail;

import com.voteme.model.User;

public class ConfirmationMail extends Mail {

	private String subject;

	public ConfirmationMail(User u) {
		super(u);
		this.getModel().put("activationLink", "http://localhost:8080/VoteMe/users/confirmation?token="+u.getCode());
		this.subject = "no-reply confirmation email";
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
