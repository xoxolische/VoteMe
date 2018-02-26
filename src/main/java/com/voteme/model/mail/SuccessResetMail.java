package com.voteme.model.mail;

import com.voteme.model.User;

public class SuccessResetMail extends Mail {

	private String subject;

	public SuccessResetMail(User u, String password) {
		super(u);
		this.subject = "no-reply successful password reset";
		this.getModel().put("newPassword", password);
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
