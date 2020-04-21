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
	public void saveUser(User user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUser() {
		Session session = null;
		Transaction transaction = null;
		List<User> listaUser = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			listaUser = session.createQuery("from User").getResultList();
			transaction.commit();
			return listaUser; 
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

	@Override
	public User getUser(int id) {
		Session session = null;
		Transaction transaction = null;
		User user = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
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

	@Override
	public void deleteUser(int id) {
		Session session = null;
		Transaction transaction = null;
		User user = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			user = session.get(User.class, id);
			session.delete(user);
			transaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
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

	@Override
	public void updateUser(User user) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(user);
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}

}
