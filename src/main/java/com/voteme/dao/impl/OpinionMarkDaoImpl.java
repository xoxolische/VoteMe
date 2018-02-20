package com.voteme.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.voteme.dao.OpinionMarkDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.OpinionMark;

@Repository
public class OpinionMarkDaoImpl extends AbstractDaoImpl<OpinionMark, Long> implements OpinionMarkDao {

	private static final String COUPLE_MARK_EXISTS_QUERY = "SELECT * FROM mark WHERE mark.user_id = ? AND mark.opinion_id = (SELECT opinion.id FROM versus INNER JOIN opinion ON versus.id = opinion.versus_id WHERE opinion.id <> ? AND opinion.versus_id = (SELECT opinion.versus_id FROM opinion WHERE opinion.id = ?))";

	public OpinionMarkDaoImpl() {
		super(OpinionMark.class);
	}

	@Override
	public OpinionMark getCouple(long userId, long opinionId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		javax.persistence.Query q = session.createNativeQuery(COUPLE_MARK_EXISTS_QUERY, OpinionMark.class);
		q.setParameter(1, userId);
		q.setParameter(2, opinionId);
		q.setParameter(3, opinionId);
		try {
			OpinionMark opMark = (OpinionMark) q.getSingleResult();
			session.getTransaction().commit();
			return opMark;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public OpinionMark getBy(long userId, long opinionId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<OpinionMark> query = builder.createQuery(OpinionMark.class);
			Root<OpinionMark> root = query.from(OpinionMark.class);
			query.select(root).where(builder.and(builder.equal(root.get("user").get("id"), userId),
					builder.equal(root.get("opinion").get("id"), opinionId)));
			Query<OpinionMark> q = session.createQuery(query);
			OpinionMark opMark = q.getSingleResult();
			session.getTransaction().commit();
			return opMark;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public List<OpinionMark> getByUser(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<OpinionMark> query = builder.createQuery(OpinionMark.class);
			Root<OpinionMark> root = query.from(OpinionMark.class);
			query.select(root).where(builder.equal(root.get("user").get("id"), id));
			Query<OpinionMark> q = session.createQuery(query);
			List<OpinionMark> l = q.getResultList();
			session.getTransaction().commit();
			return l;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}

}
