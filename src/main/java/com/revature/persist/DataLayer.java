package com.revature.persist;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Classroom;
import com.revature.ims_backend.data.access.CategoryDAO;
import com.revature.ims_backend.entities.Category;
import com.revature.session.SessionFactoryManager;

public class DataLayer {

	private Session session;
	private ClassroomDao classroomDao;
	private CategoryDAO categoryDao;
	
	public DataLayer() {
		session = SessionFactoryManager.getSessionFactory().openSession();
		classroomDao = new ClassroomDao(session);
		categoryDao = new CategoryDAO(session);
	}
	
	public void close() {
		if ( session != null )
			session.close();
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
	
	public Classroom getClassroomById(int id) {
		return classroomDao.getById(id);
	}
	
	public Category getCategoryById(int id) {
		return categoryDao.getCategory(id);
	}
}
