package com.spring.security.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.security.model.Categoria;
@Repository
public class CategoriaDAOImpl implements CategoriaDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Categoria> listaCat() {
		Session session = null;
		Transaction transaction = null;
		List<Categoria> lista = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			lista = session.createQuery("from Categoria").getResultList();
			transaction.commit();
			return lista;
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
	public Categoria findCatById(int id) {
		Session session = null;
		Transaction transaction = null;
		Categoria categoria = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			categoria = session.get(Categoria.class, id);
			transaction.commit();
			return categoria;
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
