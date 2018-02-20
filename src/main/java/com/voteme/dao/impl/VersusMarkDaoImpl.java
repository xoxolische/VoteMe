package com.voteme.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.voteme.dao.VersusMarkDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.VersusMark;

@Repository
public class VersusMarkDaoImpl extends AbstractDaoImpl<VersusMark, Long> implements VersusMarkDao {

	public VersusMarkDaoImpl() {
		super(VersusMark.class);
	}

	@Override
	public List<VersusMark> getByUser(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<VersusMark> query = builder.createQuery(VersusMark.class);
			Root<VersusMark> root = query.from(VersusMark.class);
			query.select(root).where(builder.equal(root.get("user").get("id"), id));
			Query<VersusMark> q = session.createQuery(query);
			List<VersusMark> l = q.getResultList();
			session.getTransaction().commit();
			return l;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}

	@Override
	public boolean userHasVote(long userId, long versusId) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<VersusMark> query = builder.createQuery(VersusMark.class);
			Root<VersusMark> root = query.from(VersusMark.class);
			query.select(root).where(builder.and(builder.equal(root.get("versus").get("id"), versusId),
					builder.equal(root.get("user").get("id"), userId)));
			Query<VersusMark> q = session.createQuery(query);
			List<VersusMark> l = q.getResultList();
			session.getTransaction().commit();
			if (l == null || l.size() == 0) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			session.getTransaction().rollback();
			return true;
		}
	}

}
