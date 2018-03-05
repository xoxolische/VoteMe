package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.CommentMarkDao;
import com.voteme.model.CommentMark;

@Repository
public class CommentMarkDaoImpl extends AbstractDaoImpl<CommentMark, Long> implements CommentMarkDao {

	public CommentMarkDaoImpl() {
		super(CommentMark.class);
	}

}
