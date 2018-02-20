package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.CommentDao;
import com.voteme.model.Comment;

@Repository
public class CommentDaoImpl extends AbstractDaoImpl<Comment, Long> implements CommentDao {

	public CommentDaoImpl() {
		super(Comment.class);
	}

}
