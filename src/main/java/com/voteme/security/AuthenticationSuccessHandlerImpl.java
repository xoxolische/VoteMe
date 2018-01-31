package com.voteme.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.voteme.model.UserAuth;
import com.voteme.service.OpinionMarkService;
import com.voteme.service.VersusMarkService;

@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {

	@Autowired
	private OpinionMarkService opMarkService;

	@Autowired
	private VersusMarkService versusMarkService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth)
			throws IOException, ServletException {
		UserAuth userAuth = (UserAuth) auth.getPrincipal();
		HttpSession session = request.getSession();
		session.setAttribute("currentUserId", userAuth.getId());
		session.setAttribute("currentUserVersusMarks", versusMarkService.getByUser(userAuth.getId()));
		session.setAttribute("currentUserOpinionMarks", opMarkService.getByUser(userAuth.getId()));
		response.sendRedirect("/VoteMe/home");
		// switch (userAuth.getRole().getName()) {
		// case "ADMIN":
		// response.sendRedirect("/VoteMe/home");
		// break;
		// case "MODERATOR":
		// response.sendRedirect("/VoteMe/home");
		// break;
		// case "USER":
		// response.sendRedirect("/VoteMe/home");
		// break;
		// }
	}

}
