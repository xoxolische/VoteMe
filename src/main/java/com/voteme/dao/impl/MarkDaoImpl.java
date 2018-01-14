package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.MarkDao;
import com.voteme.model.Mark;

@Repository
public class MarkDaoImpl extends AbstractDaoImpl<Mark, Long> implements MarkDao{

	public MarkDaoImpl() {
		super(Mark.class);
	}

}
