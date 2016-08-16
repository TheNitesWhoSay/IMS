package com.revature.ims_backend.entities;

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

@Entity
@Table(name="IMS_PRODUCT_CATEGORY")
public class Category {
	
	@Id
	@Column(name="CATEGORY_ID")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="CATEGORY_DESCRIPTION")
	private String description;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="PRODUCT_CATEGORIES",
		joinColumns=@JoinColumn(name="PRODUCT_UPC"),
		inverseJoinColumns=@JoinColumn(name="CATEGORY_ID"))
	private Set<Product> products; // Lazy-load
	
	public Category(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public Category() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}
	
}
