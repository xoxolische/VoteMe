package com.voteme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voteme.dao.OpinionDao;
import com.voteme.model.Opinion;
import com.voteme.service.OpinionService;

@Service
@Transactional
public class OpinionServiceImpl implements OpinionService {

	@Autowired
	private OpinionDao opinionDao;

	@Override
	public void create(Opinion entity) {
		opinionDao.create(entity);
	}

	@Override
	public void update(Opinion entity) {
		opinionDao.update(entity);
	}

	@Override
	public Opinion get(long id) {
		return opinionDao.get(id);
	}

	@Override
	public List<Opinion> getAll() {
		return opinionDao.getAll();
	}

	@Override
	public void delete(long id) {
		opinionDao.delete(id);
	}

	@Override
	public void delete(Opinion entity) {
		opinionDao.delete(entity);
	}

}
