package com.voteme.controller.api;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.User;
import com.voteme.model.mail.ConfirmationMail;
import com.voteme.model.mail.PasswordResetMail;
import com.voteme.service.EmailService;
import com.voteme.service.RoleService;
import com.voteme.service.UserService;
import com.voteme.validation.UserValidator;

import freemarker.template.TemplateException;

@RestController
@RequestMapping(value = "/api/user")
public class UserControllerRest {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	// @Autowired
	// private RoleService roleService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private UserValidator userValidator;

	@PostMapping(value = "/create", produces = "application/json")
	public ResponseEntity<?> create(@RequestBody User user, BindingResult result, HttpServletRequest request) {
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			List<String> errorList = new LinkedList<>();
			for (ObjectError e : result.getAllErrors()) {
				errorList.add(e.getCode());
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorList);
		} else {
			userService.create(user);
			try {
				emailService.send(new ConfirmationMail(user, request.getContextPath()));
			} catch (MessagingException | IOException | TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/register", produces = "application/json")
	public ResponseEntity<?> createCommonUser(@RequestBody User user, BindingResult result,
			HttpServletRequest request) {
		user.setRole(roleService.getByName("USER"));
		userValidator.validate(user, result);
		if (result.hasErrors()) {
			List<String> errorList = new LinkedList<>();
			for (ObjectError e : result.getAllErrors()) {
				errorList.add(e.getCode());
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorList);
		} else {
			userService.create(user);
			try {
				emailService.send(new ConfirmationMail(user, request.getContextPath()));
			} catch (MessagingException | IOException | TemplateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return new ResponseEntity<User>(user, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/update", produces = "application/json")
	public void update(@RequestBody User user) {
		userService.update(user);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable long id) {
		userService.delete(id);
	}

	@PostMapping(value = "/get/{id}", produces = "application/json")
	public User get(@PathVariable long id) {
		return userService.get(id);
	}

	@PostMapping(value = "/getAll", produces = "application/json")
	public List<User> getAll() {
		return userService.getAll();
	}

	@GetMapping(value = "/resetPassword")
	public void userResetPassword(@RequestParam(name = "email") String email) {
		if (email != null && !email.equals("")) {
			User u = userService.getUserByEmail(email);
			if (u != null) {
				u.setResetCode(UUID.randomUUID().toString());
				u.setResetCodeDate(new Timestamp(System.currentTimeMillis()));
				userService.update(u);
				try {
					emailService.send(new PasswordResetMail(u));
				} catch (MessagingException | IOException | TemplateException e) {
					e.printStackTrace();
				}
				
			}

		}
	}

}
