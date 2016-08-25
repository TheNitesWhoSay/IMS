package com.revature.ims_backend.data.access;

import org.hibernate.Session;

public class DaoFactory {
	
	public static BasicDao getDao(Session session, String className) {
		String entityPackage = "com.revature.ims_backend.entities"; // TODO: Probably a good thing to pull from a properties file or something
		try {
			Class clazz = Class.forName(entityPackage + "." + className);
			return new BasicDao(session, clazz);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			System.exit(1);
			return new BasicDao(session, Class.class); // Necessary workaround
		}
	}
}
