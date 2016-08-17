package com.revature.ims_backend.test.entities;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.revature.ims_backend.test.IntegrationTest;

import junit.framework.TestCase;

@Category(IntegrationTest.class)
public class DataAccessTests extends TestCase {
	
	SessionFactory sf;
	
	@BeforeClass
	protected void setUp() throws Exception {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@Test
	public void testAddress() throws Exception {
		assertTrue(true);
	}
	
	@AfterClass
	protected void tearDown() throws Exception {
		sf.close();
	}
	
}
