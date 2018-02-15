package com.voteme.dao;

import java.util.List;

import com.voteme.model.Versus;

public interface VersusDao extends CrudDao<Versus>{

	List<Versus> getAllOrderDate();
}
