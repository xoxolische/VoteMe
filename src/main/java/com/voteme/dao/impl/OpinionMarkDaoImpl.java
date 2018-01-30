package com.voteme.dao.impl;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
		Query q = session.createNativeQuery(COUPLE_MARK_EXISTS_QUERY, OpinionMark.class);
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

	@SuppressWarnings("deprecation")
	@Override
	public OpinionMark getBy(long userId, long opinionId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(OpinionMark.class).createAlias("user", "u").createAlias("opinion",
				"o");
		OpinionMark opMark = (OpinionMark) criteria
				.add(Restrictions.and(Restrictions.eq("u.id", userId), Restrictions.eq("o.id", opinionId)))
				.uniqueResult();
		session.getTransaction().commit();
		return opMark;
	}

}
