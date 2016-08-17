package com.revature.ims_backend.data.access;

import org.hibernate.Session;

public class DaoFactory {
	
	public static BasicDao getDao(Session session, String className) throws ClassNotFoundException {
		String entityPackage = "com.revature.ims_backend.entities"; // TODO: Probably a good thing to pull from a properties file or something
		Class clazz = Class.forName(entityPackage + "." + className);
		return new BasicDao(session, clazz);
	}
}
