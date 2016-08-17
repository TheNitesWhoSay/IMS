package com.revature.ims_backend.entities;

import java.util.List;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="CATEGORY_DESCRIPTION")
	private String description;
	
	@ManyToMany//(fetch=FetchType.EAGER)
	@JoinTable(name="PRODUCT_CATEGORIES",
		joinColumns=@JoinColumn(name="CATEGORY_ID", referencedColumnName="CATEGORY_ID"),
		inverseJoinColumns=@JoinColumn(name="PRODUCT_UPC", referencedColumnName="PRODUCT_UPC"))
	private List<Product> products; // Lazy-load
	
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

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
