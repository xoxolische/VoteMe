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

import com.voteme.model.Comment;
import com.voteme.service.CommentService;
import com.voteme.validation.CommentValidator;

@RestController
@RequestMapping(value = "/api/comment")
public class CommentControllerRest {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private CommentValidator commentValidator;

	@PostMapping(value = "/create", produces = "application/json")
	public ResponseEntity<?> create(@RequestBody Comment c, BindingResult result) {
		commentValidator.validate(c, result);
		if (result.hasErrors()) {
			List<String> errorList = new LinkedList<>();
			for (ObjectError e : result.getAllErrors()) {
				errorList.add(e.getCode());
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorList);
		} else {
			commentService.create(c);
			return new ResponseEntity<Comment>(c, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/update", produces = "application/json")
	public void update(@RequestBody Comment c) {
		commentService.update(c);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable long id) {
		commentService.delete(id);
	}

	@PostMapping(value = "/get/{id}", produces = "application/json")
	public Comment get(@PathVariable long id) {
		return commentService.get(id);
	}

	@PostMapping(value = "/getAll", produces = "application/json")
	public List<Comment> getAll() {
		return commentService.getAll();
	}

}
