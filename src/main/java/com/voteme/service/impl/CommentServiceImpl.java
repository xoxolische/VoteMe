package com.voteme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voteme.dao.CommentDao;
import com.voteme.model.Comment;
import com.voteme.service.CommentService;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public void create(Comment entity) {
		commentDao.create(entity);
	}

	@Override
	public void update(Comment entity) {
		commentDao.update(entity);
	}

	@Override
	public Comment get(long id) {
		return commentDao.get(id);
	}

	@Override
	public List<Comment> getAll() {
		return commentDao.getAll();
	}

	@Override
	public void delete(long id) {
		commentDao.delete(id);
	}

	@Override
	public void delete(Comment entity) {
		commentDao.delete(entity);
	}

}
