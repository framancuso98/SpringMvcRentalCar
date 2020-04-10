package com.spring.security.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.spring.security.model.User;

@Repository
public class UserDAOImpl implements UserDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean save(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public User findUserByName(String name) {
		List<User> list = null;
		User user = null;
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			Query<User> query = session.createQuery("from User where name = :name");
			query.setParameter("name", name);
			list = query.getResultList();
			if (list.size() > 0) {
				user = list.get(0);
			}
			transaction.commit();
			return user;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
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
