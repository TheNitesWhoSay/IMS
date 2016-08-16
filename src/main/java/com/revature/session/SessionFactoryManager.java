package com.revature.session;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryManager {

	private static SessionFactory sf =
			new Configuration().configure().buildSessionFactory();
	
	private SessionFactoryManager() {}
	
	public static SessionFactory getSessionFactory() {
		return sf;
	}
}
