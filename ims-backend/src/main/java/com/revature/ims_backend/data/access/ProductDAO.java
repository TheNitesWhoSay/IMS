package com.revature.ims_backend.data.access;

import java.util.HashSet;
import java.util.Set;

import com.revature.ims_backend.entities.Product;

public class ProductDAO {
	
	public Product getProduct(int id) {
		return new Product();
	}
	
	public Set<Product> getProducts(int id) {
		return new HashSet<Product>();
	}
	
	public boolean addProduct(Product product) {
		return false;
	}
	
	public boolean updateProduct(Product product) {
		return false;
	}
	
	public boolean removeProduct(Product product) {
		return false;
	}
	
}
