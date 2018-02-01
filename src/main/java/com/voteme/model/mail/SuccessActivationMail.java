package com.voteme.model.mail;

import com.voteme.model.User;

public class SuccessActivationMail extends Mail {

	private String subject;

	public SuccessActivationMail(User u) {
		super(u);
		this.subject = "no-reply successful confirmation";
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
