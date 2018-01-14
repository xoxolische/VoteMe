package com.voteme.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;

import com.voteme.dao.CrudDao;
import com.voteme.hibernate.HibernateUtil;

public abstract class AbstractDaoImpl<E, K> implements CrudDao<E> {

	protected final Class<E> entityClass;

	public AbstractDaoImpl(Class<E> entityClass) {
		this.entityClass = entityClass;
	}

	@Override
	public void create(E entity) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.save(entity);
		session.getTransaction().commit();
	}

	@Override
	public void update(E entity) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.update(entity);
		session.getTransaction().commit();
	}

	@Override
	public E get(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		E e = (E) session.get(entityClass, id);
		session.getTransaction().commit();
		return e;
	}

	@Override
	public void delete(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		E e = (E) session.load(entityClass, id);
		session.delete(e);
		session.getTransaction().commit();
	}

	@Override
	public void delete(E entity) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		session.delete(entity);
		session.getTransaction().commit();
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<E> getAll() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(entityClass);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
		List<E> l = (List<E>) criteria.list();
		session.getTransaction().commit();
		return l;
	}

}
