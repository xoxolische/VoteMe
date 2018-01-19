package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.OpinionMarkDao;
import com.voteme.model.OpinionMark;

@Repository
public class OpinionMarkDaoImpl extends AbstractDaoImpl<OpinionMark, Long> implements OpinionMarkDao{

	public OpinionMarkDaoImpl() {
		super(OpinionMark.class);
	}

}
