package com.spring.security.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

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
	public void saveAuto(Auto auto) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(auto);
			transaction.commit();
		} catch (Exception e) {
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
	public List<Auto> listAuto() {
		Session session = null;
		Transaction transaction = null;
		List<Auto> listAuto =  null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			listAuto = session.createQuery("from Auto").getResultList();
			transaction.commit();
			return listAuto;
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
	public void deleteAuto(int id) {
		Session session = null;
		Transaction transaction = null;
		Auto auto = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			auto = session.get(Auto.class, id);
			session.delete(auto);
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

	@Override
	public Auto findAutoById(int id) {
		Session session = null;
		Transaction transaction = null;
		Auto auto = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			auto = session.get(Auto.class, id);
			transaction.commit();
			return auto;
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
			return null;
		}finally {
			try {
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	@Override
	public void updateAuto(Auto auto) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(auto);
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

	@Override
	public Auto findAutoByTarga(String targa) {
		Session session = null;
		Transaction transaction = null;
		Auto auto = null;
		try {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Auto> cq = cb.createQuery(Auto.class);
		Root<Auto> root = cq.from(Auto.class);
		Predicate a = cb.equal(root.get("targa"), targa);
		cq.where(a);
		TypedQuery<Auto> query = session.createQuery(cq);
		try {
			auto = query.getSingleResult() ;
		} catch (NoResultException nre) {
		}
		return auto;
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
