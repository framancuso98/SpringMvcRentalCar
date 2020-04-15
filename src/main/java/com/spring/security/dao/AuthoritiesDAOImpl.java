package com.spring.security.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.security.model.Authorities;

@Repository
@Transactional(rollbackFor = Exception.class)
public class AuthoritiesDAOImpl implements AuthoritiesDAO{

	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	public Authorities getAuth(int id) {
		Session session = null;
		Transaction transaction = null;
		Authorities auth = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			auth = session.get(Authorities.class, id);
			transaction.rollback();
			return auth;
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
			return null;
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

}
