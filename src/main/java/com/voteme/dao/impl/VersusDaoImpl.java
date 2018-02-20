package com.voteme.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.voteme.dao.VersusDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.Versus;

@Repository
public class VersusDaoImpl extends AbstractDaoImpl<Versus, Long> implements VersusDao {

	public VersusDaoImpl() {
		super(Versus.class);
	}

	@Override
	public List<Versus> getAllOrderDate(int limit) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Versus> query = builder.createQuery(Versus.class);
			Root<Versus> root = query.from(Versus.class);
			query.select(root).orderBy(builder.desc(root.get("createdAt")));
			Query<Versus> q = session.createQuery(query);
			q.setMaxResults(limit);
			List<Versus> l = q.getResultList();
			session.getTransaction().commit();
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public List<Versus> getMore(long lastDate, int limit) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<Versus> query = builder.createQuery(Versus.class);
			Root<Versus> root = query.from(Versus.class);
			query.select(root).where(builder.lessThan(root.get("createdAt"), new Timestamp(lastDate)))
					.orderBy(builder.desc(root.get("createdAt")));
			Query<Versus> q = session.createQuery(query);
			q.setMaxResults(limit);
			List<Versus> l = q.getResultList();
			session.getTransaction().commit();
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

}
