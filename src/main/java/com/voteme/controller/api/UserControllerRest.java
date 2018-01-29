package com.voteme.controller.api;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.User;
import com.voteme.model.mail.ConfirmationEmail;
import com.voteme.service.EmailService;
import com.voteme.service.UserService;
import com.voteme.validation.UserValidator;

@RestController
@RequestMapping(value = "/api/user")
public class UserControllerRest {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@PostMapping(value = "/create", produces = "application/json")
	public ResponseEntity<?> create(@RequestBody User user, BindingResult result) {
		new UserValidator().validate(user, result);
		if (result.hasErrors()) {
			List<String> errorList = new LinkedList<>();
			for (ObjectError e : result.getAllErrors()) {
				errorList.add(e.getCode());
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorList);
		} else {
			userService.create(user);
			emailService.send(new ConfirmationEmail(user));
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

}
