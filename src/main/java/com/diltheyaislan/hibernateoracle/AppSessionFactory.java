package com.diltheyaislan.hibernateoracle;

import java.io.File;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AppSessionFactory {

	public static SessionFactory getSessionFactory() {
		SessionFactory sessionFactory = new Configuration()
				.configure(new File("src/main/resources/META-INF/hibernate.cfg.xml"))
				.buildSessionFactory();
		return sessionFactory; 
	}
}
