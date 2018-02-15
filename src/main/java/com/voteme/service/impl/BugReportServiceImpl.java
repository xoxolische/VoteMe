package com.voteme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voteme.dao.BugReportDao;
import com.voteme.model.BugReport;
import com.voteme.service.BugReportService;

@Service
@Transactional
public class BugReportServiceImpl implements BugReportService {

	@Autowired
	private BugReportDao bugDao;

	@Override
	public void create(BugReport entity) {
		bugDao.create(entity);
	}

	@Override
	public void update(BugReport entity) {
		bugDao.update(entity);
	}

	@Override
	public BugReport get(long id) {
		return bugDao.get(id);
	}

	@Override
	public List<BugReport> getAll() {
		return bugDao.getAll();
	}

	@Override
	public void delete(long id) {
		bugDao.delete(id);
	}

	@Override
	public void delete(BugReport entity) {
		bugDao.delete(entity);
	}

}
