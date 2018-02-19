package com.voteme.service;

import java.util.List;

import com.voteme.model.Versus;

public interface VersusService extends CrudInterface<Versus>{

	List<Versus> getAllOrderByDate(int limit);
	
	List<Versus> getMore(long lastDate, int limit);
}
