package com.daorest.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * 
 * @author Rajesh Vibhudi
 */
public class HibernateUtil {

	private static final SessionFactory sessionFactory;

	static {
		try {
			// Create the SessionFactory from standard (hibernate.cfg.xml)
			// config file.

			sessionFactory = new Configuration().configure("/hibernate.cfg.xml")
					.buildSessionFactory();
			System.out.println("load success");

		} catch (Throwable ex) {
			// Log the exception.
			System.err.println("Initial SessionFactory creation failed." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session beginTransaction() {
		Session hibernateSession = HibernateUtil.getSession();
		hibernateSession.beginTransaction();
		return hibernateSession;
	}

	public static void commitTransaction() {
		HibernateUtil.getSession().getTransaction().commit();
	}

	public static void rollbackTransaction() {
		HibernateUtil.getSession().getTransaction().rollback();
	}

	public static void closeSession() {
		HibernateUtil.getSession().close();
	}

	public static Session getSession() {
		Session hibernateSession = sessionFactory.openSession();
		return hibernateSession;
	}
}

