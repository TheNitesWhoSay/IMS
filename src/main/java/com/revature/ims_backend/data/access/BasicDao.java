package com.revature.ims_backend.data.access;

import java.util.List;

import org.hibernate.Session;

public class BasicDao {
	
	private Session session;
	private String className;
	
	public BasicDao(Session session, String className) {
		this.session = session;
		this.className = className;
	}
	
	public Object get(int id) {
		return session.get(className, id);
	}
	
	public List<Object> getAll() {
		return session.createCriteria(className).list();
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
