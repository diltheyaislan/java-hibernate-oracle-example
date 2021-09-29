package com.diltheyaislan.hibernateoracle;
// Generated 29 de set. de 2021 18:52:44 by Hibernate Tools 5.5.3.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * Home object for domain model class Pagamento.
 * @see com.diltheyaislan.hibernateoracle.Pagamento
 * @author Hibernate Tools
 */
public class PagamentoDAO {

	private static final Logger logger = Logger.getLogger(PagamentoDAO.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return AppSessionFactory.getSessionFactory(); 
	}

	public void persist(Pagamento transientInstance) {
		logger.log(Level.INFO, "persisting Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.persist(transientInstance);
			session.getTransaction().commit();
			logger.log(Level.INFO, "persist successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "persist failed", re);
			throw re;
		}
	}

	public void delete(Pagamento persistentInstance) {
		logger.log(Level.INFO, "deleting Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.delete(persistentInstance);
			session.getTransaction().commit();
			logger.log(Level.INFO, "delete successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "delete failed", re);
			throw re;
		}
	}

	public void merge(Pagamento detachedInstance) {
		logger.log(Level.INFO, "merging Pagamento instance");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			session.merge(detachedInstance);
			session.getTransaction().commit();
			logger.log(Level.INFO, "merge successful");
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "merge failed", re);
			throw re;
		}
	}
	
	public Pagamento find(PagamentoId id) {
		logger.log(Level.INFO, "getting Pagamento instance with id: " + id);
		try {
			Pagamento instance = (Pagamento) sessionFactory.getCurrentSession().get("com.diltheyaislan.hibernateoracle.Pagamento",
					id);
			if (instance == null) {
				logger.log(Level.INFO, "get successful, no instance found");
			} else {
				logger.log(Level.INFO, "get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Pagamento> findAll() {
		logger.log(Level.INFO, "getting all Pagamentos");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			String hql = "from Pagamento";
			Query<?> query = session.createQuery(hql);
			List<Pagamento> pagamentos = (List<Pagamento>) query.list();
			session.getTransaction().commit();
			logger.log(Level.INFO, "get successful");
			return pagamentos;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}
}
