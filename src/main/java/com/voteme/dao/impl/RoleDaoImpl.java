package com.voteme.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.voteme.dao.RoleDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.Role;

@Repository
public class RoleDaoImpl extends AbstractDaoImpl<Role, Long> implements RoleDao {

	public RoleDaoImpl() {
		super(Role.class);
	}

	@Override
	public Role getByName(String name) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Role> query = builder.createQuery(Role.class);
			Root<Role> root = query.from(Role.class);
			query.select(root).where(builder.equal(root.get("name"), name));
			Query<Role> q = session.createQuery(query);
			Role r = q.getSingleResult();
			session.getTransaction().commit();
			return r;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}

	}

}
