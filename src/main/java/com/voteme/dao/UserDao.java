package com.voteme.dao;

import com.voteme.model.User;
import com.voteme.model.UserAuth;

public interface UserDao extends CrudDao<User>{

	UserAuth getUserAuth(String email);

}
