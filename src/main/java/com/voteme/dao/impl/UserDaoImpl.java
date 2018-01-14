package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.UserDao;
import com.voteme.model.User;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, Long> implements UserDao{

	public UserDaoImpl() {
		super(User.class);
	}

}
