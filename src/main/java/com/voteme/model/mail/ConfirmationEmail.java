package com.voteme.model.mail;

import org.springframework.mail.SimpleMailMessage;

import com.voteme.model.User;

public class ConfirmationEmail extends SimpleMailMessage {

	private static final long serialVersionUID = -6169904832336357965L;

	public ConfirmationEmail(User u) {
		super();
		this.setTo(u.getEmail());
		this.setSubject("Confirmation letter");
		String text = "<p> Dear, " + u.getNickName() + ",</p>"
				+ "<p>We need your account confirmation to give you an opportunity to take part in surveys.</p>"
				+ "<p>Please, follow the link. [LINKLINKLINKLINK] "+u.getCode()+" </p>"
				+ "<p>In case you did not register and dont know why you received this message,then ignore it.</p>";
		this.setText(text);
	}
}
