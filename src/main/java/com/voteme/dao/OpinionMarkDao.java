package com.voteme.dao;

import java.util.List;

import com.voteme.model.OpinionMark;

public interface OpinionMarkDao extends CrudDao<OpinionMark>{

	OpinionMark getCouple(long userId, long opinionId);

	OpinionMark getBy(long userId, long opinionId);

	List<OpinionMark> getByUser(long id);

}
