package com.voteme.service;

import com.voteme.model.User;

public interface UserService extends CrudInterface<User>{

	User getByCode(String token);

}
