package com.voteme.controller.api;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.BugReport;
import com.voteme.service.BugReportService;
import com.voteme.validation.BugReportValidator;

@RestController
@RequestMapping(value = "/api/bugs")
public class BugReportControllerRest {

	@Autowired
	private BugReportService bugReportService;
	
	@Autowired
	private BugReportValidator bugValidator;
	
	@PostMapping(value = "/create", produces = "application/json")
	public ResponseEntity<?> create(@RequestBody BugReport b, BindingResult result) {
		bugValidator.validate(b, result);
		if (result.hasErrors()) {
			List<String> errorList = new LinkedList<>();
			for (ObjectError e : result.getAllErrors()) {
				errorList.add(e.getCode());
			}
			return ResponseEntity.status(HttpStatus.FORBIDDEN).body(errorList);
		} else {
			bugReportService.create(b);
			return new ResponseEntity<BugReport>(b, HttpStatus.OK);
		}
	}

	@PostMapping(value = "/get/{id}", produces = "application/json")
	public BugReport get(@PathVariable long id) {
		return bugReportService.get(id);
	}

	@PostMapping(value = "/getAll", produces = "application/json")
	public List<BugReport> getAll() {
		return bugReportService.getAll();
	}
	
}
