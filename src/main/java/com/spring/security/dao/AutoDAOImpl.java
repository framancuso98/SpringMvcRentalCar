package com.spring.security.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.security.model.Auto;

@Repository
public class AutoDAOImpl implements AutoDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean save(Auto auto) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(auto);
			transaction.commit();
			return true;
		} catch (Exception e) {
			transaction.rollback();
			return false;
		}finally {
			try {
				session.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public List<Auto> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Auto get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Auto findAutoById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
