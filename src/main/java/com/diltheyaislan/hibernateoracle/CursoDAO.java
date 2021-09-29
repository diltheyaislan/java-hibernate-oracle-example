package com.diltheyaislan.hibernateoracle;
// Generated 29 de set. de 2021 18:52:44 by Hibernate Tools 5.5.3.Final

import java.math.BigInteger;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 * Home object for domain model class Curso.
 * @see com.diltheyaislan.hibernateoracle.Curso
 * @author Hibernate Tools
 */
public class CursoDAO {

	private static final Logger logger = Logger.getLogger(CursoDAO.class.getName());

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		return AppSessionFactory.getSessionFactory(); 
	}

	public void persist(Curso transientInstance) {
		logger.log(Level.INFO, "persisting Curso instance");
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

	public void delete(Curso persistentInstance) {
		logger.log(Level.INFO, "deleting Curso instance");
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

	public void merge(Curso detachedInstance) {
		logger.log(Level.INFO, "merging Curso instance");
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
	
	public Curso find(BigInteger cdcurso) {
		logger.log(Level.INFO, "getting Curso instance with id: " + cdcurso);
		try {
			Curso instance = (Curso) sessionFactory.getCurrentSession().get("com.diltheyaislan.hibernateoracle.Curso",
					cdcurso);
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
	public List<Curso> findAll() {
		logger.log(Level.INFO, "getting all Cursos");
		try {
			Session session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			String hql = "from Curso";
			Query<?> query = session.createQuery(hql);
			List<Curso> cursos = (List<Curso>) query.list();
			session.getTransaction().commit();
			logger.log(Level.INFO, "get successful");
			return cursos;
		} catch (RuntimeException re) {
			logger.log(Level.SEVERE, "get failed", re);
			throw re;
		}
	}
}
