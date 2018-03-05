package com.voteme.controller.api;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.Mark;
import com.voteme.model.VersusMark;
import com.voteme.service.VersusMarkService;
import com.voteme.utils.CurrentUser;
import com.voteme.validation.VersusMarkValidator;

@RestController
@RequestMapping(value = "/api/versusMark")
public class VersusMarkControllerRest {

	@Autowired
	private VersusMarkService markService;

	@Autowired
	private VersusMarkValidator versusMarkValidator;

	@PostMapping(value = "/create", produces = "application/json")
	public ResponseEntity<?> create(@RequestBody VersusMark mark, BindingResult result, Authentication a) {
//		if (mark.getUser() != null) {			
//			if(CurrentUser.isCurrentUser(mark.getUser().getId(), a)) {
//				return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Be careful, son!");
//			}
//		}
		versusMarkValidator.validate(mark, result);
		if (result.hasErrors()) {
			List<String> errorList = new LinkedList<>();
			for (ObjectError e : result.getAllErrors()) {
				errorList.add(e.getCode());
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorList);
		} else {
			markService.create(mark);
			return new ResponseEntity<VersusMark>(mark, HttpStatus.OK);
		}
	}

//	@PostMapping(value = "/update", produces = "application/json")
//	public void update(@RequestBody VersusMark mark) {
//		markService.update(mark);
//	}
//
//	@DeleteMapping(value = "/delete/{id}")
//	public void delete(@PathVariable long id) {
//		markService.delete(id);
//	}

	@GetMapping(value = "/get/{id}", produces = "application/json")
	public Mark get(@PathVariable long id) {
		return markService.get(id);
	}
	
	@GetMapping(value = "/getByUser/{userId}", produces = "application/json")
	public List<VersusMark> getByUser(@PathVariable long userId) {
		return markService.getByUser(userId);
	}

	@GetMapping(value = "/getAll", produces = "application/json")
	public List<VersusMark> getAll() {
		return markService.getAll();
	}

}
