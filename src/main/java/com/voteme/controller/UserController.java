package com.voteme.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.voteme.model.User;
import com.voteme.model.UserAuth;
import com.voteme.model.mail.SuccessActivationMail;
import com.voteme.model.mail.SuccessResetMail;
import com.voteme.service.EmailService;
import com.voteme.service.RoleService;
import com.voteme.service.UserService;
import com.voteme.utils.StringRandomGen;

import freemarker.template.TemplateException;

@Controller
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private EmailService emailService;

	@GetMapping(value = "/")
	public String allUsersPage(Model model) {
		model.addAttribute("userList", userService.getAll());
		return "usersPage";
	}

	@GetMapping(value = "/create")
	public String createPage(Model model) {
		model.addAttribute("roles", roleService.getAll());
		return "createUser";
	}

	@GetMapping(value = "/{id}")
	public String userInfoPage(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.get(id));
		return "userInfoPage";
	}

	@GetMapping(value = "/update/{id}")
	public String userUpdateInfoPage(Model model, @PathVariable long id) {
		model.addAttribute("user", userService.get(id));
		return "userInfoPage";
	}

	@GetMapping(value = "/confirmation")
	public String userConfirmation(Model model, @RequestParam(name = "token") String token,
			Authentication authentication) {
		UserAuth currentUser = (UserAuth) authentication.getPrincipal();
		User u = userService.getByCode(token);
		UserAuth originUser = new UserAuth(u);

		if (originUser != null && originUser.equals(currentUser) && !originUser.isEnabled()) {
			u.setIs_verified(true);
			userService.update(u);
			try {
				emailService.send(new SuccessActivationMail(u));
			} catch (MessagingException | IOException | TemplateException e) {
				e.printStackTrace();
			}
		}

		return "home";
	}

	@GetMapping(value = "/resetLink")
	public String userConfirmation(@RequestParam(name = "token") String token) {
		User u = userService.getByResetPasswordCode(token);
		if (u != null) {
			Timestamp current = new Timestamp(System.currentTimeMillis());
			long delta = current.getTime() - u.getResetCodeDate().getTime();
			// if less than 24h
			if (delta < (1000 * 60 * 60 * 24)) {
				StringRandomGen msr = new StringRandomGen();
				String s = msr.generateRandomString();
				System.out.println(s);
				u.setPassword(new BCryptPasswordEncoder().encode(s));
				userService.update(u);
				try {
					emailService.send(new SuccessResetMail(u, s));
				} catch (MessagingException | IOException | TemplateException e) {
					e.printStackTrace();
				}
			}
		}

		return "home";
	}
}
