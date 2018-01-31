package com.voteme.service;

import java.util.List;

import com.voteme.model.VersusMark;

public interface VersusMarkService extends CrudInterface<VersusMark>{

	List<VersusMark> getByUser(long id);

}
