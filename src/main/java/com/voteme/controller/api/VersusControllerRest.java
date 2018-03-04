package com.voteme.controller.api;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.UserAuth;
import com.voteme.model.Versus;
import com.voteme.service.VersusService;
import com.voteme.utils.CurrentUser;
import com.voteme.validation.VersusValidator;

@RestController
@RequestMapping(value = "/api/versus")
public class VersusControllerRest {
	@Autowired
	private VersusService versusService;

	@Autowired
	private VersusValidator versusValidator;

	@PostMapping(value = "/create", produces = "application/json")
	public ResponseEntity<?> create(@RequestBody Versus versus, BindingResult result, Authentication a) {
		if (versus.getAuthor() != null) {
			if (CurrentUser.isCurrentUser(versus.getAuthor().getId(), a)) {
				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Be careful, son!");
			}
		}
		versusValidator.validate(versus, result);
		if (result.hasErrors()) {
			List<String> errorList = new LinkedList<>();
			for (ObjectError e : result.getAllErrors()) {
				errorList.add(e.getCode());
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorList);
		} else {
			versusService.create(versus);
			return new ResponseEntity<Versus>(versus, HttpStatus.OK);
		}
	}

	// @PostMapping(value = "/update", produces = "application/json")
	// public void update(@RequestBody Versus versus) {
	// versusService.update(versus);
	// }
	//
	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable long id, Authentication authentication) {
		UserAuth currentUser = (UserAuth) authentication.getPrincipal();
		if (currentUser.getRole().getName().equalsIgnoreCase("admin")) {
			versusService.delete(id);
		}
	}

	@GetMapping(value = "/get/{id}", produces = "application/json")
	public Versus get(@PathVariable long id) {
		return versusService.get(id);
	}

	@GetMapping(value = "/getAll", produces = "application/json")
	public List<Versus> getAll() {
		return versusService.getAllOrderByDate(5);
	}

	@GetMapping(value = "/getMore/{lastDate}", produces = "application/json")
	public List<Versus> getMore(@PathVariable long lastDate) {
		return versusService.getMore(lastDate, 5);
	}

}
