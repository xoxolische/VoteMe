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

import com.voteme.model.Mark;
import com.voteme.service.MarkService;

@RestController
@RequestMapping(value = "/mark")
public class MarkControllerRest {

	@Autowired
	private MarkService markService;

	@PostMapping(value = "/create", produces = "application/json")
	@ResponseBody
	public void create(@RequestBody Mark mark) {
		markService.create(mark);
	}

	@PostMapping(value = "/update", produces = "application/json")
	@ResponseBody
	public void update(@RequestBody Mark mark) {
		markService.update(mark);
	}

	@DeleteMapping(value = "/delete/{id}")
	@ResponseBody
	public void delete(@PathVariable long id) {
		markService.delete(id);
	}

	@PostMapping(value = "/get/{id}", produces = "application/json")
	@ResponseBody
	public Mark get(@PathVariable long id) {
		return markService.get(id);
	}

	@PostMapping(value = "/getAll", produces = "application/json")
	@ResponseBody
	public List<Mark> getAll() {
		return markService.getAll();
	}

}
