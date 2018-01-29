package com.voteme.model.mail;

import org.springframework.mail.SimpleMailMessage;

import com.voteme.model.User;

public class ConfirmationEmail extends SimpleMailMessage {

	private static final long serialVersionUID = -6169904832336357965L;

	public ConfirmationEmail(User u) {
		super();
		this.setTo(u.getEmail());
		this.setSubject("Confirmation letter");
		String text = "Dear, " + u.getNickName() + ", "
				+ "We need your account confirmation to give you an opportunity to take part in surveys."
				+ "Please, follow the link."+"http://localhost:8080/VoteMe/users/confirmation?token="+u.getCode()
				+ " In case you did not register and dont know why you received this message,then ignore it.";
		this.setText(text);
	}
}
