package com.revature.ims_backend.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="IMS_PRODUCT_STOCK")
public class Stock {

	@Id
	@Column(name="STOCK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="NUM_IN_STOCK")
	private int numInStock;
	
	@OneToOne(mappedBy="stock", cascade=CascadeType.ALL)
	@JsonBackReference
	private Product product;

	public Stock(int id, int numInStock) {
		super();
		this.id = id;
		this.numInStock = numInStock;
	}

	public Stock() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getNumInStock() {
		return numInStock;
	}

	public void setNumInStock(int numInStock) {
		this.numInStock = numInStock;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
}
