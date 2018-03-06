package com.voteme.dao.impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.voteme.dao.CommentMarkDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.CommentMark;

@Repository
public class CommentMarkDaoImpl extends AbstractDaoImpl<CommentMark, Long> implements CommentMarkDao {

	public CommentMarkDaoImpl() {
		super(CommentMark.class);
	}

	@Override
	public List<CommentMark> getByUser(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			CriteriaBuilder builder = session.getCriteriaBuilder();
			CriteriaQuery<CommentMark> query = builder.createQuery(CommentMark.class);
			Root<CommentMark> root = query.from(CommentMark.class);
			query.select(root).where(builder.equal(root.get("user").get("id"), id));
			Query<CommentMark> q = session.createQuery(query);
			List<CommentMark> l = q.getResultList();
			session.getTransaction().commit();
			return l;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}

}
