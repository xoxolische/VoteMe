package com.voteme.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;

import com.voteme.dao.VersusDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.Versus;

@Repository
public class VersusDaoImpl extends AbstractDaoImpl<Versus, Long> implements VersusDao{

	public VersusDaoImpl() {
		super(Versus.class);
	}
	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Versus> getAllOrderDate(){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		try {
			Criteria criteria = session.createCriteria(Versus.class);
			criteria.addOrder(Order.desc("createdAt"));
			criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
			List<Versus> l = (List<Versus>) criteria.list();
			session.getTransaction().commit();
			return l;
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();
			return null;
		}
	}

}
