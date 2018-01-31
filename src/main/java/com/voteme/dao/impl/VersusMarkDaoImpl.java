package com.voteme.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.voteme.dao.VersusMarkDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.VersusMark;

@Repository
public class VersusMarkDaoImpl extends AbstractDaoImpl<VersusMark, Long> implements VersusMarkDao {

	public VersusMarkDaoImpl() {
		super(VersusMark.class);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<VersusMark> getByUser(long id) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(VersusMark.class).createAlias("user", "u")
					.add(Restrictions.eq("u.id", id));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<VersusMark> l = (List<VersusMark>) criteria.list();
			session.getTransaction().commit();
			return l;
		} catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}

}
