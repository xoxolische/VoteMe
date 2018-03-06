package com.voteme.dao;

import java.util.List;

import com.voteme.model.CommentMark;

public interface CommentMarkDao extends CrudDao<CommentMark> {

	List<CommentMark> getByUser(long id);
}
