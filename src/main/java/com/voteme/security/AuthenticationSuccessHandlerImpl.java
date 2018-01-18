package com.voteme.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.voteme.model.UserAuth;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		UserAuth userAuth = (UserAuth) auth.getPrincipal();
		switch (userAuth.getRole().getName()) {
		case "ADMIN":
			response.sendRedirect("/VoteMe/home");
			break;
		}
	}

}
