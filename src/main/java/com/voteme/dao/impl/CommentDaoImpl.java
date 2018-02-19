package com.voteme.dao.impl;

import org.springframework.stereotype.Repository;

import com.voteme.dao.CommentDao;
import com.voteme.model.Comment;

@Repository
public class CommentDaoImpl extends AbstractDaoImpl<Comment, Long> implements CommentDao {

	public CommentDaoImpl() {
		super(Comment.class);
	}

//	@SuppressWarnings({ "unchecked", "deprecation" })
//	@Override
//	public List<Comment> getByUser(long id) {
//		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
//		session.beginTransaction();
//		try {
//			Criteria criteria = session.createCriteria(VersusMark.class).createAlias("user", "u")
//					.add(Restrictions.eq("u.id", id));
//			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
//			List<VersusMark> l = (List<VersusMark>) criteria.list();
//			session.getTransaction().commit();
//			return l;
//		} catch (Exception e) {
//			session.getTransaction().rollback();
//			return null;
//		}
//	}

}
