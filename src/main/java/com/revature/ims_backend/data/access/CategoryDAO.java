package com.revature.ims_backend.data.access;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.revature.beans.Classroom;
import com.revature.ims_backend.entities.Category;

public class CategoryDAO {
	
	Session session;
	
	public CategoryDAO(Session session) {
		this.session = session;
	}
	
	public Category getCategory(int id) {
		Query query = session.createQuery("from Category where id = :id");
		query.setInteger("id",  id);
		return (Category)query.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public Set<Category> getCategories() {
		Query query = session.createQuery("from Category");
		return new HashSet<Category>(query.list());
	}
	
	public boolean addCategory(Category category) {
		return false;
	}
	
	public boolean updateCategory(Category category) {
		return false;
	}
	
	public boolean removeCategory(Category category) {
		return false;
	}
	
}
