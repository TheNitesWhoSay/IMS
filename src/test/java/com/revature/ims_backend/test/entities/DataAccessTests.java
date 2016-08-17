package com.revature.ims_backend.test.entities;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.revature.ims_backend.data.access.BasicDao;
import com.revature.ims_backend.data.access.DaoFactory;
import com.revature.ims_backend.entities.Address;
import com.revature.ims_backend.entities.StateAbbreviation;
import com.revature.ims_backend.test.IntegrationTest;

import junit.framework.TestCase;

@Category(IntegrationTest.class)
public class DataAccessTests extends TestCase {
	
	SessionFactory sf;
	Session session;
	
	@BeforeClass
	protected void setUp() throws Exception {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@Before
	protected void openSession() throws Exception {
		session = sf.openSession();
	}
	
	@Test
	public void testAddress() throws Exception {
		Transaction tx;
		BasicDao addressDao = DaoFactory.getDao(session, "Address");
		BasicDao stateDao = DaoFactory.getDao(session, "StateAbbreviation");
		
		// TEST CREATE
		Address a1 = new Address();
		a1.setAddress1("1 College and Main");
		a1.setAddress2("CU Box 713");
		a1.setCity("Columbus");
		a1.setState((StateAbbreviation) stateDao.get(49));
		a1.setZip("43209");
		tx = session.beginTransaction();
		addressDao.insert(a1);
		tx.commit();
		
		// TEST READ
		Address a2 = (Address) addressDao.get(a1.getId());
		assertEquals(a1.getAddress1(), a2.getAddress1());
		assertEquals(a1.getAddress2(), a2.getAddress2());
		assertEquals(a1.getState().getName(), a2.getState().getName());
		assertEquals(a1.getCity(), a2.getCity());
		assertEquals(a1.getZip(), a2.getZip());
		assertEquals(a1.getId(), a2.getId());
		
		// TEST UPDATE
		a2.setAddress1("11730 Plaza America Drive");
		a2.setAddress2(null);
		a2.setCity("Reston");
		a2.setState((StateAbbreviation) stateDao.get(60));
		a2.setZip("20190");
		addressDao.update(a2);
		
		Address a3 = (Address) addressDao.get(a2.getId());
		assertEquals(a2.getAddress1(), a3.getAddress1());
		assertEquals(a2.getAddress2(), a3.getAddress2());
		assertEquals(a2.getState().getName(), a3.getState().getName());
		assertEquals(a2.getCity(), a3.getCity());
		assertEquals(a2.getZip(), a3.getZip());
		assertEquals(a2.getId(), a3.getId());
		
		// TEST DELETE
		tx = session.beginTransaction();
		addressDao.delete(a3);
		tx.commit();
		
		Address a4 = (Address) addressDao.get(a3.getId());
		assertNull(a3);
	}
	
	@After
	protected void closeSession() throws Exception {
		if (session.isOpen()) 
			session.close();
	}
	
	@AfterClass
	protected void tearDown() throws Exception {
		sf.close();
	}
	
}
