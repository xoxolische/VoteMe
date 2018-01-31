package com.voteme.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.voteme.dao.RoleDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.Role;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Role, Long> implements RoleDao{

	public RoleDaoImpl() {
		super(Role.class);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Role getByName(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(Role.class);
		Role r = (Role) criteria.add(Restrictions.eq("name", name)).uniqueResult();
		session.getTransaction().commit();
		return r;
	}

}
