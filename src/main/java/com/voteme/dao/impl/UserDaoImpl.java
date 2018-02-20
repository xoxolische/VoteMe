package com.voteme.dao.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.voteme.dao.UserDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.User;
import com.voteme.model.UserAuth;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, Long> implements UserDao {

	public UserDaoImpl() {
		super(User.class);
	}

	@Override
	public UserAuth getUserAuth(String email) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("email"), email));
			Query<User> q = session.createQuery(query);
			User u = q.getSingleResult();
			session.getTransaction().commit();
			return new UserAuth(u);
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public boolean userExists(String email) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("email"), email));
			Query<User> q = session.createQuery(query);
			User u = q.getSingleResult();
			session.getTransaction().commit();
			if (u != null) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}
	}

	@Override
	public User getByCode(String token) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<User> query = builder.createQuery(User.class);
			Root<User> root = query.from(User.class);
			query.select(root).where(builder.equal(root.get("code"), token));
			Query<User> q = session.createQuery(query);
			User u = q.getSingleResult();
			session.getTransaction().commit();
			return u;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}

}
