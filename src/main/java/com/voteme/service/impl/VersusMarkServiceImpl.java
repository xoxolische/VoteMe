package com.voteme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voteme.dao.VersusMarkDao;
import com.voteme.model.VersusMark;
import com.voteme.service.VersusMarkService;

@Service
@Transactional
public class VersusMarkServiceImpl implements VersusMarkService {

	@Autowired
	private VersusMarkDao markDao;

	@Override
	public void create(VersusMark entity) {
		markDao.create(entity);
	}

	@Override
	public void update(VersusMark entity) {
		markDao.update(entity);
	}

	@Override
	public VersusMark get(long id) {
		return markDao.get(id);
	}

	@Override
	public List<VersusMark> getAll() {
		return markDao.getAll();
	}

	@Override
	public void delete(long id) {
		markDao.delete(id);
	}

	@Override
	public void delete(VersusMark entity) {
		markDao.delete(entity);
	}

	@Override
	public List<VersusMark> getByUser(long id) {
		return markDao.getByUser(id);
	}

	@Override
	public boolean userHasVote(long userId, long versusId) {
		return markDao.userHasVote(userId, versusId);
	}

}
