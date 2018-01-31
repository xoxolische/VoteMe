package com.voteme.service;

import java.util.List;

import com.voteme.model.OpinionMark;

public interface OpinionMarkService extends CrudInterface<OpinionMark> {

	/**
	 * 
	 * @param userId
	 * @param opinionId
	 * @return mark of the 2nd opinion if exists, otherwise null
	 */
	OpinionMark getCouple(long userId, long opinionId);

	/**
	 * 
	 * @param userId
	 * @param opinionId
	 * @return OpinionMark from user for concrete opinion
	 */
	OpinionMark getBy(long userId, long opinionId);
	
	List<OpinionMark> getByUser(long id);

}
