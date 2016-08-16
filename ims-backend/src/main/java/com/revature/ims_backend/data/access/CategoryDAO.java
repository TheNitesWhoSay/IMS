package com.revature.ims_backend.data.access;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.Session;

import com.revature.ims_backend.entities.Category;

public class CategoryDAO {
	
	Session session;
	
	public CategoryDAO(Session session) {
		this.session = session;
	}
	
	public Category getCategory(int id) {
		return new Category();
	}
	
	public Set<Category> getCategories(int id) {
		return new HashSet<Category>();
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
