package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.VersusMarkDao;
import com.voteme.model.VersusMark;

@Repository
public class VersusMarkDaoImpl extends AbstractDaoImpl<VersusMark, Long> implements VersusMarkDao{

	public VersusMarkDaoImpl() {
		super(VersusMark.class);
	}

}
