package com.voteme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voteme.dao.MarkDao;
import com.voteme.model.Mark;
import com.voteme.service.MarkService;

@Service
@Transactional
public class MarkServiceImpl implements MarkService {

	@Autowired
	private MarkDao markDao;

	@Override
	public void create(Mark entity) {
		markDao.create(entity);
	}

	@Override
	public void update(Mark entity) {
		markDao.update(entity);
	}

	@Override
	public Mark get(long id) {
		return markDao.get(id);
	}

	@Override
	public List<Mark> getAll() {
		return markDao.getAll();
	}

	@Override
	public void delete(long id) {
		markDao.delete(id);
	}

	@Override
	public void delete(Mark entity) {
		markDao.delete(entity);
	}

}
