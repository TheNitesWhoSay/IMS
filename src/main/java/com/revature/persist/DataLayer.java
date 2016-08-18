package com.revature.persist;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.ims_backend.data.access.BasicDao;
import com.revature.ims_backend.data.access.DaoFactory;
import com.revature.ims_backend.entities.Category;
import com.revature.session.SessionFactoryManager;

public class DataLayer implements AutoCloseable {

	private Session session;
	private Transaction tx;
	
	// TODO: Maybe find some way to optionally load
	private BasicDao clientDao;
	private BasicDao clientTypeDao;
	private BasicDao addressDao;
	private BasicDao stateDao;
	private BasicDao productDao;
	private BasicDao categoryDao;
	private BasicDao productImageDao;
	private BasicDao purchaseOrderDao;
	private BasicDao orderLineDao;
	
	private ClassroomDao classroomDao;
	
	public DataLayer() {
		session = SessionFactoryManager.getSessionFactory().openSession();
		clientDao = DaoFactory.getDao(session, "Client");
		clientTypeDao = DaoFactory.getDao(session, "ClientType");
		addressDao = DaoFactory.getDao(session, "Address");
		stateDao = DaoFactory.getDao(session, "StateAbbreviation");
		productDao = DaoFactory.getDao(session, "Product");
		categoryDao = DaoFactory.getDao(session, "Category");
		productImageDao = DaoFactory.getDao(session, "ProductImage");
		purchaseOrderDao = DaoFactory.getDao(session, "PurchaseOrder");
		orderLineDao = DaoFactory.getDao(session, "OrderLine");
		
		classroomDao = new ClassroomDao(session);
	}
	
	public void close() {
		if (session.isOpen())
			session.close();
	}
	
	public void commitOrRollback() {
		try {
			if (tx.wasCommitted() || tx.wasRolledBack()) return;
			else tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}
	}
	
	public void insertObject(Object obj) {
		Transaction tx = session.beginTransaction();
		try {
			session.save(obj);
			tx.commit();
		} catch ( Throwable t ) {
			tx.rollback();
		}
	}
	
	public Category getCategoryById(int id) {
		Query query = session.createQuery("from Category where id = :id");
		query.setInteger("id",  id);
		return (Category)query.uniqueResult();
	}
}
