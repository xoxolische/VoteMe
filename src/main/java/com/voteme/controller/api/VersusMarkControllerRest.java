package com.voteme.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.Mark;
import com.voteme.model.VersusMark;
import com.voteme.service.VersusMarkService;

@RestController
@RequestMapping(value = "/api/versusMark")
public class VersusMarkControllerRest {

	@Autowired
	private VersusMarkService markService;

	@PostMapping(value = "/create", produces = "application/json")
	public void create(@RequestBody VersusMark mark) {
		markService.create(mark);
	}

	@PostMapping(value = "/update", produces = "application/json")
	public void update(@RequestBody VersusMark mark) {
		markService.update(mark);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable long id) {
		markService.delete(id);
	}

	@GetMapping(value = "/get/{id}", produces = "application/json")
	public Mark get(@PathVariable long id) {
		return markService.get(id);
	}

	@GetMapping(value = "/getAll", produces = "application/json")
	public List<VersusMark> getAll() {
		return markService.getAll();
	}

}
