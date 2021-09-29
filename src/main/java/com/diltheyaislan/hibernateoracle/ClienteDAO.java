package com.diltheyaislan.hibernateoracle;
// Generated 29 de set. de 2021 18:52:44 by Hibernate Tools 5.5.3.Final

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * Home object for domain model class Cliente.
 * @see com.diltheyaislan.hibernateoracle.Cliente
 * @author Hibernate Tools
 */
public class ClienteDAO {

	private static final Logger logger = Logger.getLogger(ClienteDAO.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return AppSessionFactory.getSessionFactory(); 
	}

	public void persist(Cliente transientInstance) {
		logger.log(Level.INFO, "persisting Cliente instance");
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

	public void delete(Cliente persistentInstance) {
		logger.log(Level.INFO, "deleting Cliente instance");
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

	public void merge(Cliente detachedInstance) {
		logger.log(Level.INFO, "merging Cliente instance");
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
	
	public Cliente find(String cpf) {
		logger.log(Level.INFO, "getting Cliente instance with id: " + cpf);
		try {
			Cliente instance = (Cliente) sessionFactory.getCurrentSession().get("com.diltheyaislan.hibernateoracle.Cliente",
					cpf);
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
	public List<Cliente> findAll() {
		logger.log(Level.INFO, "getting all Clientes");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			String hql = "from Cliente";
			Query<?> query = session.createQuery(hql);
			List<Cliente> clientes = (List<Cliente>) query.list();
			session.getTransaction().commit();
			logger.log(Level.INFO, "get successful");
			return clientes;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}
}
