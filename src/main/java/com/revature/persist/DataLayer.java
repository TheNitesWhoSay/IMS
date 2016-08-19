package com.revature.persist;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.ims_backend.data.access.BasicDao;
import com.revature.ims_backend.data.access.DaoFactory;
import com.revature.ims_backend.entities.Category;
import com.revature.ims_backend.entities.Client;
import com.revature.ims_backend.entities.ClientType;
import com.revature.ims_backend.entities.Product;
import com.revature.ims_backend.entities.StateAbbreviation;
import com.revature.logging.Log;
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
	}
	
	public void close() {
		if (session.isOpen())
			session.close();
	}
	
	public void beginTransaction() {
		tx = session.beginTransaction();
	}
	
	public boolean commitOrRollback() {
		try {
			if ( !(tx.wasCommitted() || tx.wasRolledBack()) ) {
				tx.commit();
				Log.info(" ||||||||||||||| Committed Transaction! ||||||||||||||| ");
				return true;
			}
		} catch (Exception e) {
			tx.rollback();
		}
		return false;
	}
	
	public Client getClient(int id) {
		return (Client) clientDao.get(id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Client> getAllClients() {
		return (List<Client>)(List) clientDao.getAll();
	}
	
	public void insertClient(Client c) {
		addressDao.insert(c.getAddress());
		clientDao.insert(c);
	}
	
	public void updateClient(Client c) {
		addressDao.update(c.getAddress());
		clientDao.update(c);
	}
	
	public List<StateAbbreviation> getStates() {
		List<StateAbbreviation> states = (List<StateAbbreviation>)(List) stateDao.getAll();
		states.sort( (s1, s2) -> s1.getAbbreviation().compareTo(s2.getAbbreviation()) );
		return states;
	}
	
	public List<ClientType> getClientTypes() {
		return (List<ClientType>)(List) clientTypeDao.getAll();
	}
	
	public void insertObject(Object obj) {
		
	}
	
	public Category getCategoryById(int id) {
		Query query = session.createQuery("from Category where id = :id");
		query.setInteger("id",  id);
		return (Category)query.uniqueResult();
	}
	
	public Set<Category> getCategories() {
		Log.info("Fetching Categories List...");
		return (Set<Category>)(Set) categoryDao.getAllUnique();
	}
	
	public Set<Product> getProducts() {
		Log.info("Fetching products List...");
		return (Set<Product>)(Set) productDao.getAllUnique();
	}

	public void insertProduct(Product product) {
		if ( productDao.get(product.getUpc()) == null ) {
			Log.info("Inserting: " + product);
			productDao.insert(product);
		} else {
			Log.error("NOT INSERTING: " + product);
		}
	}
	
	public void insertCategory(Category category) {
		if ( categoryDao.get(category.getId()) == null ) {
			categoryDao.insert(category);
		}
	}
	
	public void updateCategory(Category category) {
		categoryDao.update(category);
	}
}
