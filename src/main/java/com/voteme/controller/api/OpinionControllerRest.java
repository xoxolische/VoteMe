package com.voteme.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.Opinion;
import com.voteme.service.OpinionService;

@RestController
@RequestMapping(value = "/api/opinion")
public class OpinionControllerRest {

	@Autowired
	private OpinionService opinionService;

	@PostMapping(value = "/create", produces = "application/json")
	public void create(@RequestBody Opinion Opinion) {
		opinionService.create(Opinion);
	}

	@PostMapping(value = "/update", produces = "application/json")
	public void update(@RequestBody Opinion Opinion) {
		opinionService.update(Opinion);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable long id) {
		opinionService.delete(id);
	}

	@PostMapping(value = "/get/{id}", produces = "application/json")
	public Opinion get(@PathVariable long id) {
		return opinionService.get(id);
	}

	@PostMapping(value = "/getAll", produces = "application/json")
	public List<Opinion> getAll() {
		return opinionService.getAll();
	}
	
}
