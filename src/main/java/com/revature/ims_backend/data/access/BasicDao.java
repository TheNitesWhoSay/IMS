package com.revature.ims_backend.data.access;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class BasicDao {
	
	private Session session;
	private Class clazz;
	
	public BasicDao(Session session, Class clazz) {
		this.session = session;
		this.clazz = clazz;
	}
	
	public Object get(int id) {
		return session.createCriteria(clazz).add(Restrictions.idEq(id)).uniqueResult();
	}
	
	public List<Object> getAll() {
		return session.createCriteria(clazz).list();
	}
	
	public void insert(Object obj) {
		session.save(obj);
	}
	
	public void update(Object obj) {
		session.update(obj);
	}
	
	public void delete(Object obj) {
		session.delete(obj);
	}
}
