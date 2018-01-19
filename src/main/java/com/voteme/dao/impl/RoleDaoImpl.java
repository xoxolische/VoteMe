package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.RoleDao;
import com.voteme.model.Role;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Role, Long> implements RoleDao{

	public RoleDaoImpl() {
		super(Role.class);
	}

}
