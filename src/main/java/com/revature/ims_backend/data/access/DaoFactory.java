package com.revature.ims_backend.data.access;

import org.hibernate.Session;

public class DaoFactory {
	
	public static BasicDao getDao(Session session, String className) {
		return new BasicDao(session, className);
	}
}
