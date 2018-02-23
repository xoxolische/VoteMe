package com.voteme.model.mail;

import com.voteme.model.User;

public class PasswordResetMail extends Mail {

	private static final String APP_NAME = "http://localhost:8080/VoteMe";
	
	private String subject;

	public PasswordResetMail(User u) {
		super(u);
		String link = APP_NAME + "/users/resetLink?token="+u.getResetCode();
		this.getModel().put("resetLink", link);
		this.subject = "no-reply password reset";
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

}
