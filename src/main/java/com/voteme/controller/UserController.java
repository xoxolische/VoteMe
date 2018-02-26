package com.voteme.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.UUID;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.voteme.model.mail.PasswordResetMail;
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
	public String userResetLinkRequest(@RequestParam(name = "token") String token, Model model) {
		User u = userService.getByResetPasswordCode(token);
		if (u != null) {
			if (!u.isResetUsed()) {
				StringRandomGen msr = new StringRandomGen();
				String s = msr.generateRandomString();
				//System.out.println(s);
				u.setPassword(new BCryptPasswordEncoder().encode(s));
				u.setResetUsed(true);
				userService.update(u);
				try {
					emailService.send(new SuccessResetMail(u, s));
					model.addAttribute("success", "Your reset password request successfully done, check your email address, we have sent a new one. Log in and go profile setting if you want change it.");
				} catch (MessagingException | IOException | TemplateException e) {
					e.printStackTrace();
					u.setResetUsed(false);
					userService.update(u);
					model.addAttribute("error", "We have failed letter sending via email. Please, try again later.");
				}
			} else {
				//System.out.println("Reset link already used!");
				model.addAttribute("error", "Reset link already used! You can request a new one or use a password from letter we have sent you before.");
			}
		}else {
			model.addAttribute("error", "Acess token is wrong!");
		}

		return "resetPassword";
	}

	@GetMapping(value = "/resetPassword")
	public ResponseEntity<?> userResetPassword(@RequestParam(name = "email") String email) {
		if (email != null && !email.equals("")) {
			User u = userService.getUserByEmail(email);
			if (u != null) {
				long delta = 0;
				boolean nullable = false;
				if (u.getResetCodeDate() != null) {
					Timestamp current = new Timestamp(System.currentTimeMillis());
					delta = current.getTime() - u.getResetCodeDate().getTime();
				}else {
					nullable = true;
				}
				// if less than 24h
				if (nullable || delta > (1000 * 60 * 60 * 24)) {
					u.setResetCode(UUID.randomUUID().toString());
					u.setResetCodeDate(new Timestamp(System.currentTimeMillis()));
					u.setResetUsed(false);
					userService.update(u);
					try {
						emailService.send(new PasswordResetMail(u));
						return ResponseEntity.status(HttpStatus.OK).body("Ok, we have sent you a letter with reset link. Check your email address.");
					} catch (MessagingException | IOException | TemplateException e) {
						e.printStackTrace();
						return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body("Something went wrong. error 500");
					}
				} else {
					return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("You can request password reset once per 24h!");
					//System.out.println("You can request password reset once per 24h!");
				}
			} else {
				return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("User with such email address does not exists!");
				//System.out.println("Wrong email!");
			}
		}
		return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body("Email can not be empty!");
	}
}
