package com.spring.security.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.spring.security.model.Auto;
import com.spring.security.model.Prenotazione;
import com.spring.security.model.User;

@Repository
public class PrenotazioneDAOImpl implements PrenotazioneDAO {

	@Autowired 
	SessionFactory sessionFactory;
	
	@Override
	public void aggiungiPrenotazione(Prenotazione p) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(p);
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
	public List<Prenotazione> findAllPrenotazioni() {
		Session session = null;
		Transaction transaction = null;
		List<Prenotazione> lista = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			lista = session.createQuery("from Prenotazione").getResultList();
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
	public Prenotazione findById(int id) {
		Session session = null;
		Transaction transaction = null;
		Prenotazione prenotazione = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			prenotazione = session.get(Prenotazione.class, id);
			transaction.commit();
			return prenotazione;
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
	public void rimuoviPrenotazione(int id) {
		Session session = null;
		Transaction transaction = null;
		Prenotazione prenotazione = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			prenotazione = session.get(Prenotazione.class, id);
			session.delete(prenotazione);
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
	public void accettaPrenotazione(Prenotazione p) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(p);
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
	public void rifiutaPrenotazione(Prenotazione p) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.update(p);
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
	public Prenotazione findByUtente(User user) {
		Session session = null;
		Transaction transaction = null;
		Prenotazione prenotazione = null;
		try {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Prenotazione> cq = cb.createQuery(Prenotazione.class);
		Root<Prenotazione> root = cq.from(Prenotazione.class);
		Predicate u = cb.equal(root.get("user"), user);
		cq.where(u);
		TypedQuery<Prenotazione> query = session.createQuery(cq);
		try {
			prenotazione = query.getSingleResult() ;
		} catch (NoResultException nre) {
		}
		return prenotazione;
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
	public Prenotazione findByAuto(Auto auto) {
		Session session = null;
		Transaction transaction = null;
		Prenotazione prenotazione = null;
		try {
		session = sessionFactory.openSession();
		transaction = session.beginTransaction();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Prenotazione> cq = cb.createQuery(Prenotazione.class);
		Root<Prenotazione> root = cq.from(Prenotazione.class);
		Predicate a = cb.equal(root.get("auto"), auto);
		cq.where(a);
		TypedQuery<Prenotazione> query = session.createQuery(cq);
		try {
			prenotazione = query.getSingleResult() ;
		} catch (NoResultException nre) {
		}
		
		return prenotazione;
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
