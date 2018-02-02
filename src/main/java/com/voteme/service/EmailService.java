package com.voteme.service;

import java.io.IOException;

import javax.mail.MessagingException;

import com.voteme.model.mail.ConfirmationMail;
import com.voteme.model.mail.SuccessActivationMail;

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

}
