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

import com.voteme.model.OpinionMark;
import com.voteme.service.OpinionMarkService;
import com.voteme.validation.OpinionMarkValidator;

@RestController
@RequestMapping(value = "/api/opinionMark")
public class OpinionMarkControllerRest {

	@Autowired
	private OpinionMarkService opinionMarkService;
	
	@Autowired
	private OpinionMarkValidator opinionMarkValidator;

	@PostMapping(value = "/create", produces = "application/json")
	public ResponseEntity<?> create(@RequestBody OpinionMark op, BindingResult result) {
		opinionMarkValidator.validate(op, result);
		if (result.hasErrors()) {
			List<String> errorList = new LinkedList<>();
			for (ObjectError e : result.getAllErrors()) {
				errorList.add(e.getCode());
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorList);
		} else {
			opinionMarkService.create(op);
			return new ResponseEntity<OpinionMark>(op, HttpStatus.OK);
		}
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable long id) {
		opinionMarkService.delete(id);
	}

	@PostMapping(value = "/get/{id}", produces = "application/json")
	public OpinionMark get(@PathVariable long id) {
		return opinionMarkService.get(id);
	}

	@PostMapping(value = "/getAll", produces = "application/json")
	public List<OpinionMark> getAll() {
		return opinionMarkService.getAll();
	}
	
}
