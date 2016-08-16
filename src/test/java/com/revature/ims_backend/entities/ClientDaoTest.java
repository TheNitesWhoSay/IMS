package com.revature.ims_backend.entities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import junit.framework.TestCase;

public class ClientDaoTest extends TestCase {
	
	SessionFactory sf;
	
	@Override
	protected void setUp() throws Exception {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@Override
	protected void tearDown() throws Exception {
		sf.close();
	}
}
