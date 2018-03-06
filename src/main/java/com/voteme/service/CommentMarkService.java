package com.voteme.service;

import java.util.List;

import com.voteme.model.CommentMark;

public interface CommentMarkService extends CrudInterface<CommentMark>{

	List<CommentMark> getByUser(long userId);

}
