package com.sol.api.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.sol.api.model.Lesson;
import com.sol.api.model.Question;

public class HibernateSessionHandler {

	private static SessionFactory sessionFactory = initializeConfiguration().buildSessionFactory((new StandardServiceRegistryBuilder().configure().build()));
		
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public static Session getHibernateSession() {
		final SessionFactory sf = getSessionFactory();
		final Session session = sf.openSession();
		return session;
	}
	
	private static Configuration initializeConfiguration() {
		return new Configuration().configure()
				.addAnnotatedClass(Lesson.class)
				.addAnnotatedClass(Question.class);
	}
	
}
