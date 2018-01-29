package com.voteme.model.mail;

import org.springframework.mail.SimpleMailMessage;

import com.voteme.model.User;

public class SuccessActivationEmail extends SimpleMailMessage {

	private static final long serialVersionUID = -6169904832336357965L;

	public SuccessActivationEmail(User u) {
		super();
		this.setTo(u.getEmail());
		this.setSubject("Confirmation success!");
		String text = "Dear, " + u.getNickName() + ", "
				+ "Your account activated! Have fun!";
		this.setText(text);
	}
}
