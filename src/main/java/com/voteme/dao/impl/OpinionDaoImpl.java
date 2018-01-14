package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.OpinionDao;
import com.voteme.model.Opinion;

@Repository
public class OpinionDaoImpl extends AbstractDaoImpl<Opinion, Long> implements OpinionDao{

	public OpinionDaoImpl() {
		super(Opinion.class);
	}

}
