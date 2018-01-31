package com.voteme.dao;

import java.util.List;

import com.voteme.model.VersusMark;

public interface VersusMarkDao extends CrudDao<VersusMark>{

	List<VersusMark> getByUser(long id);

}
