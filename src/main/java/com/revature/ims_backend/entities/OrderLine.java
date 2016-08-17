package com.revature.ims_backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="IMS_PO_LINE")
public class OrderLine {
	
	@Id
	@Column(name="ORDER_NUMBER")
	private int orderNumber;
	
	@Column(name="LINE_NUMBER")
	private int lineNumber;
	
	@Column(name="UNIT_PRICE")
	private double unitPrice;
	
	@Column(name="QUANTITY_ORDERED")
	private int quantityOrdered;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PRODUCT_UPC")
	private Product product;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_NUMBER", insertable=false, updatable=false)
	private PurchaseOrder order; // Lazy-load
	
	
	public OrderLine(int orderNumber, int lineNumber, double unitPrice, int quantityOrdered, Product product) {
		super();
		this.orderNumber = orderNumber;
		this.lineNumber = lineNumber;
		this.unitPrice = unitPrice;
		this.quantityOrdered = quantityOrdered;
		this.product = product;
	}

	public OrderLine() {
		super();
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public void setLineNumber(int lineNumber) {
		this.lineNumber = lineNumber;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantityOrdered() {
		return quantityOrdered;
	}

	public void setQuantityOrdered(int quantityOrdered) {
		this.quantityOrdered = quantityOrdered;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PurchaseOrder getOrder() {
		return order;
	}

	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}
	
	
}
