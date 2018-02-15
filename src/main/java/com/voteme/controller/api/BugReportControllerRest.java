package com.voteme.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.voteme.model.BugReport;
import com.voteme.service.BugReportService;

@RestController
@RequestMapping(value = "/api/bugs")
public class BugReportControllerRest {

	@Autowired
	private BugReportService bugReportService;

	@PostMapping(value = "/create", produces = "application/json")
	public void create(@RequestBody BugReport bugReport) {
		bugReportService.create(bugReport);
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
