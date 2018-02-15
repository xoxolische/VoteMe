package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.BugReportDao;
import com.voteme.model.BugReport;

@Repository
public class BugReportDaoImpl extends AbstractDaoImpl<BugReport, Long> implements BugReportDao{

	public BugReportDaoImpl() {
		super(BugReport.class);
	}

}
