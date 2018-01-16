package com.voteme.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.User;
import com.voteme.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserControllerRest {

	@Autowired
	private UserService userService;

	@PostMapping(value = "/create", produces = "application/json")
	public void create(@RequestBody User User) {
		userService.create(User);
	}

	@PostMapping(value = "/update", produces = "application/json")
	public void update(@RequestBody User User) {
		userService.update(User);
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
