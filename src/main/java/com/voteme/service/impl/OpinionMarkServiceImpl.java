package com.voteme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voteme.dao.OpinionMarkDao;
import com.voteme.model.OpinionMark;
import com.voteme.service.OpinionMarkService;

@Service
@Transactional
public class OpinionMarkServiceImpl implements OpinionMarkService {

	@Autowired
	private OpinionMarkDao markDao;

	@Override
	public void create(OpinionMark entity) {
		markDao.create(entity);
	}

	@Override
	public void update(OpinionMark entity) {
		markDao.update(entity);
	}

	@Override
	public OpinionMark get(long id) {
		return markDao.get(id);
	}

	@Override
	public List<OpinionMark> getAll() {
		return markDao.getAll();
	}

	@Override
	public void delete(long id) {
		markDao.delete(id);
	}

	@Override
	public void delete(OpinionMark entity) {
		markDao.delete(entity);
	}

}
