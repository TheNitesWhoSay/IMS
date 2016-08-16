package com.revature.persist;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.beans.Classroom;
import com.revature.session.SessionFactoryManager;

public class DataLayer {

	private Session session;
	private ClassroomDao classroomDao;
	
	public DataLayer() {
		session = SessionFactoryManager.getSessionFactory().openSession();
		classroomDao = new ClassroomDao(session);
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
}
