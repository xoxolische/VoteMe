package com.voteme.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.voteme.model.mail.ConfirmationMail;
import com.voteme.model.mail.PasswordResetMail;
import com.voteme.model.mail.SuccessActivationMail;
import com.voteme.model.mail.SuccessResetMail;

import freemarker.core.ParseException;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.TemplateException;
import freemarker.template.TemplateNotFoundException;

public interface EmailService {

	// void send(SimpleMailMessage message);

	void send(ConfirmationMail mail) throws MessagingException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;

	void send(SuccessActivationMail mail) throws MessagingException, TemplateNotFoundException,
			MalformedTemplateNameException, ParseException, IOException, TemplateException;
	
	void send(PasswordResetMail mail) throws MessagingException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException;

	void send(SuccessResetMail mail) throws MessagingException, TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException;
}
