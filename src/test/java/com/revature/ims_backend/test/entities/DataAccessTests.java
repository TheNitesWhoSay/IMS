package com.revature.ims_backend.test.entities;

import static org.junit.Assert.*;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import com.revature.ims_backend.data.access.BasicDao;
import com.revature.ims_backend.data.access.DaoFactory;
import com.revature.ims_backend.entities.Address;
import com.revature.ims_backend.entities.Client;
import com.revature.ims_backend.entities.ClientType;
import com.revature.ims_backend.entities.StateAbbreviation;
import com.revature.ims_backend.test.IntegrationTest;

import junit.framework.TestCase;

@Category(IntegrationTest.class)
public class DataAccessTests {
	
	static SessionFactory sf;
	Session session;
	
	@BeforeClass
	public static void setUp() throws Exception {
		sf = new Configuration().configure().buildSessionFactory();
	}
	
	@Before
	public void openSession() throws Exception {
		session = sf.openSession();
		System.out.println("Opening session!");
	}
	
	@Test
	@Ignore
	public void testAddress() throws Exception {
		Transaction tx;
		BasicDao addressDao = DaoFactory.getDao(session, "Address");
		BasicDao stateDao = DaoFactory.getDao(session, "StateAbbreviation");
		System.out.println(stateDao);
		
		// TEST CREATE
		Address a1 = new Address();
		a1.setAddress1("1 College and Main");
		a1.setAddress2("CU Box 713");
		a1.setCity("Columbus");
		a1.setState((StateAbbreviation) 
				stateDao.get(49));
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
		tx = session.beginTransaction();
		addressDao.update(a2);
		tx.commit();
		
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
		assertNull(a4);
	}
	
	@Test
	public void testClient() throws Exception {
		Transaction tx;
		BasicDao addressDao = DaoFactory.getDao(session, "Address");
		BasicDao stateDao = DaoFactory.getDao(session, "StateAbbreviation");
		BasicDao clientDao = DaoFactory.getDao(session, "Client");
		BasicDao clientTypeDao = DaoFactory.getDao(session, "ClientType");
		
		System.out.println(stateDao);
		
		// BOILERPLATE
		Address a1 = new Address();
		Address a2 = new Address();
		a1.setAddress1("1 College and Main");
		a1.setAddress2("CU Box 713");
		a1.setCity("Columbus");
		a1.setState((StateAbbreviation) stateDao.get(49));
		a1.setZip("43209");
		
		a2.setAddress1("11730 Plaza America Drive");
		a2.setAddress2(null);
		a2.setCity("Reston");
		a2.setState((StateAbbreviation) stateDao.get(60));
		a2.setZip("20190");
		
		ClientType ct1 = new ClientType();
		ct1.setType("Incoming");
		
		tx = session.beginTransaction();
		addressDao.insert(a1);
		addressDao.insert(a2);
		clientTypeDao.insert(ct1);
		tx.commit();
				
		// TEST CREATE
		Client c1 = new Client();
		c1.setAddress(a1);
		c1.setClientType(ct1);
		c1.setEmail("revature@revature.com");
		c1.setFaxNumber("+441619998888");
		c1.setName("Revature");
		c1.setPhoneNumber("9996276144");
		c1.setPointOfContactName("Grace Gioglio");
		tx = session.beginTransaction();
		clientDao.insert(c1);
		tx.commit();
		
		// TEST READ
		Client c2 = (Client) clientDao.get(c1.getId());
		assertEquals(c1.getEmail(), c2.getEmail());
		assertEquals(c1.getFaxNumber(), c2.getFaxNumber());
		assertEquals(c1.getId(), c2.getId());
		assertEquals(c1.getName(), c2.getName());
		assertEquals(c1.getPhoneNumber(), c2.getPhoneNumber());
		assertEquals(c1.getPointOfContactName(), c2.getPointOfContactName());
		assertEquals(c1.getAddress().getId(), c2.getAddress().getId());
		assertEquals(c1.getClientType().getType(), c2.getClientType().getType());
		
		// TEST UPDATE
		c2.setAddress(a2);
		c2.setEmail("housing@revature.com");
		c2.setName("Reevature");
		c2.setPhoneNumber("6144074903");
		c2.setPointOfContactName("Trey McDeane");
		tx = session.beginTransaction();
		clientDao.update(c2);
		tx.commit();
		
		Client c3 = (Client) clientDao.get(c2.getId());
		assertEquals(c3.getClientType().getType(), c2.getClientType().getType());
		assertEquals(c3.getEmail(), c2.getEmail());
		assertEquals(c3.getFaxNumber(), c2.getFaxNumber());
		assertEquals(c3.getId(), c2.getId());
		assertEquals(c3.getName(), c2.getName());
		assertEquals(c3.getPhoneNumber(), c2.getPhoneNumber());
		assertEquals(c3.getPointOfContactName(), c2.getPointOfContactName());
		assertEquals(c3.getAddress().getId(), c2.getAddress().getId());
		
		// TEST DELETE (& CLEANUP)
		tx = session.beginTransaction();
		clientDao.delete(c3);
		addressDao.delete(a1);
		addressDao.delete(a2);
		clientTypeDao.delete(ct1);
		tx.commit();
		
		Client c4 = (Client) clientDao.get(c3.getId());
		assertNull(c4);
	}
	
	@After
	public void closeSession() throws Exception {
		if (session.isOpen()) 
			session.close();
	}
	
	@AfterClass
	public static void tearDown() throws Exception {
		sf.close();
	}
	
}
