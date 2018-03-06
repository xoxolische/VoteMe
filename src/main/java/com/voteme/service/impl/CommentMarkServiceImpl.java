package com.voteme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voteme.dao.CommentMarkDao;
import com.voteme.model.CommentMark;
import com.voteme.service.CommentMarkService;

@Service
@Transactional
public class CommentMarkServiceImpl implements CommentMarkService {

	@Autowired
	private CommentMarkDao markDao;

	@Override
	public void create(CommentMark entity) {
		markDao.create(entity);
	}

	@Override
	public void update(CommentMark entity) {
		markDao.update(entity);
	}

	@Override
	public CommentMark get(long id) {
		return markDao.get(id);
	}

	@Override
	public List<CommentMark> getAll() {
		return markDao.getAll();
	}

	@Override
	public void delete(long id) {
		markDao.delete(id);
	}

	@Override
	public void delete(CommentMark entity) {
		markDao.delete(entity);
	}

	@Override
	public List<CommentMark> getByUser(long userId) {
		return markDao.getByUser(userId);
	}

}
