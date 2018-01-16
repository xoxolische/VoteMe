package com.voteme.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.voteme.dao.UserDao;
import com.voteme.hibernate.HibernateUtil;
import com.voteme.model.User;
import com.voteme.model.UserAuth;

@Repository
public class UserDaoImpl extends AbstractDaoImpl<User, Long> implements UserDao{

	public UserDaoImpl() {
		super(User.class);
	}

	@SuppressWarnings("deprecation")
	@Override
	public UserAuth getUserAuth(String email) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		Criteria criteria = session.createCriteria(User.class);
		User u = (User) criteria.add(Restrictions.eq("nickName", email)).uniqueResult();
		session.getTransaction().commit();
		return new UserAuth(u);
	}

}
