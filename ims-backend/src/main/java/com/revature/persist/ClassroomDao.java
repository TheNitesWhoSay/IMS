package com.revature.persist;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.Classroom;

public class ClassroomDao {

	private Session session;
	
	public ClassroomDao(Session session) {
		this.session = session;
	}
	
	public Classroom getById(int id) {
		Query query = session.createQuery("from Classroom where id = :id");
		query.setInteger("id",  id);
		return (Classroom)query.uniqueResult();
	}
}
