package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.VersusDao;
import com.voteme.model.Versus;

@Repository
public class VersusDaoImpl extends AbstractDaoImpl<Versus, Long> implements VersusDao{

	public VersusDaoImpl() {
		super(Versus.class);
	}

}
