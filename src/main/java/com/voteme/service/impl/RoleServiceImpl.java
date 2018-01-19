package com.voteme.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.voteme.dao.RoleDao;
import com.voteme.model.Role;
import com.voteme.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

	@Autowired
	private RoleDao roleDao;

	@Override
	public void create(Role entity) {
		roleDao.create(entity);
	}

	@Override
	public void update(Role entity) {
		roleDao.update(entity);
	}

	@Override
	public Role get(long id) {
		return roleDao.get(id);
	}

	@Override
	public List<Role> getAll() {
		return roleDao.getAll();
	}

	@Override
	public void delete(long id) {
		roleDao.delete(id);
	}

	@Override
	public void delete(Role entity) {
		roleDao.delete(entity);
	}

}
