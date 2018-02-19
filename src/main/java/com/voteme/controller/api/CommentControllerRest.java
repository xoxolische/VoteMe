package com.voteme.controller.api;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.Comment;
import com.voteme.service.CommentService;

@RestController
@RequestMapping(value = "/api/comment")
public class CommentControllerRest {

	@Autowired
	private CommentService commentService;

	@PostMapping(value = "/create", produces = "application/json")
	public Comment create(@RequestBody Comment c, BindingResult result, HttpServletRequest request) {
		commentService.create(c);
		return c;
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
