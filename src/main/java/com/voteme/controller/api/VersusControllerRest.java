package com.voteme.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.Versus;
import com.voteme.service.VersusService;

@RestController
@RequestMapping(value = "/api/versus")
public class VersusControllerRest {
	@Autowired
	private VersusService versusService;

	@PostMapping(value = "/create", produces = "application/json")
	public ResponseEntity<Versus> create(@RequestBody Versus versus) {
		try {
			versusService.create(versus);			
			return new ResponseEntity<>(versus, HttpStatus.OK);
		}catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(versus, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(value = "/update", produces = "application/json")
	public void update(@RequestBody Versus versus) {
		versusService.update(versus);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable long id) {
		versusService.delete(id);
	}

	@PostMapping(value = "/get/{id}", produces = "application/json")
	public Versus get(@PathVariable long id) {
		return versusService.get(id);
	}

	@GetMapping(value = "/getAll", produces = "application/json")
	public List<Versus> getAll() {
		return versusService.getAll();
	}
}
