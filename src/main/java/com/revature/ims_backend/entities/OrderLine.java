package com.revature.ims_backend.entities;

import java.io.Serializable;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable class CompKey implements Serializable {
	
	
	private int orderNumber;
	
	private int lineNumber;

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

	public CompKey() {
		super();
	}
	
}

@Entity
@Table(name="IMS_PO_LINE")
public class OrderLine implements Serializable {
	
	
	
	@EmbeddedId
	@AttributeOverrides({
        @AttributeOverride(
            name = "lineNumber",
            column = @Column(name = "LINE_NUMBER")),
        @AttributeOverride(
            name = "orderNumber",
            column = @Column(name = "ORDER_NUMBER"))
    })
	private CompKey comp_id = new CompKey();
	
	
	@Column(name="UNIT_PRICE")
	private double unitPrice;
	
	@Column(name="QUANTITY_ORDERED")
	private int quantityOrdered;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PRODUCT_UPC")
	private Product product;
	
	/*
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ORDER_NUMBER", insertable=false, updatable=false)
	private PurchaseOrder order; // Lazy-load
	*/
	
	public OrderLine(int orderNumber, int lineNumber, double unitPrice, int quantityOrdered, Product product) {
		super();
		this.comp_id.setOrderNumber(orderNumber);
		this.comp_id.setLineNumber(lineNumber);
		this.unitPrice = unitPrice;
		this.quantityOrdered = quantityOrdered;
		this.product = product;
	}

	public OrderLine() {
		super();
	}
	
	@JoinColumn(name="ORDER_NUMBER")
	public int getOrderNumber() {
		return comp_id.getOrderNumber();
	}

	
	public void setOrderNumber(int orderNumber) {
		this.comp_id.setOrderNumber(orderNumber);
	}
	
	
	public int getLineNumber() {
		return comp_id.getLineNumber();
	}

	public void setLineNumber(int lineNumber) {
		this.comp_id.setLineNumber(lineNumber);
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

	@Override
	public String toString() {
		return "OrderLine [comp_id=" + comp_id + ", unitPrice=" + unitPrice + ", quantityOrdered=" + quantityOrdered
				+ ", product=" + product + "]";
	}
	
	/*
	public PurchaseOrder getOrder() {
		return order;
	}

	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}
	*/
	
}
