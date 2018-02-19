package com.voteme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voteme.dao.VersusDao;
import com.voteme.model.Versus;
import com.voteme.service.VersusService;

@Service
@Transactional
public class VersusServiceImpl implements VersusService {

	@Autowired
	private VersusDao versusDao;

	@Override
	public void create(Versus entity) {
		versusDao.create(entity);
	}

	@Override
	public void update(Versus entity) {
		versusDao.update(entity);
	}

	@Override
	public Versus get(long id) {
		return versusDao.get(id);
	}

	@Override
	public List<Versus> getAll() {
		return versusDao.getAll();
	}

	@Override
	public void delete(long id) {
		versusDao.delete(id);
	}

	@Override
	public void delete(Versus entity) {
		versusDao.delete(entity);
	}
	
	@Override
	public List<Versus> getAllOrderByDate(int limit) {
		return versusDao.getAllOrderDate(limit);
	}

	@Override
	public List<Versus> getMore(long lastDate, int limit) {
		return versusDao.getMore(lastDate, limit);
	}

}
