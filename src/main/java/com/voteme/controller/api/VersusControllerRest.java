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

import com.voteme.model.Versus;
import com.voteme.service.VersusService;

@RestController
@RequestMapping(value = "/versus")
public class VersusControllerRest {
	@Autowired
	private VersusService VersusService;

	@PostMapping(value = "/create", produces = "application/json")
	public void create(@RequestBody Versus Versus) {
		VersusService.create(Versus);
	}

	@PostMapping(value = "/update", produces = "application/json")
	public void update(@RequestBody Versus Versus) {
		VersusService.update(Versus);
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable long id) {
		VersusService.delete(id);
	}

	@PostMapping(value = "/get/{id}", produces = "application/json")
	public Versus get(@PathVariable long id) {
		return VersusService.get(id);
	}

	@PostMapping(value = "/getAll", produces = "application/json")
	public List<Versus> getAll() {
		return VersusService.getAll();
	}
}
