package com.revature.ims_backend.entities;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="IMS_PURCHASE_ORDER")
public class PurchaseOrder {

	@Id
	@Column(name="ORDER_NUMBER")
	private int orderNumber;
	
	@Column(name="SUBTOTAL")
	private double subTotal;
	
	@Column(name="PURCHASE_DATE")
	private Date purchaseDate;
	
	@Column(name="TAX_AMOUNT")
	private double taxAmount;
	
	@Column(name="PO_TOTAL")
	private double total;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="CLIENT_ID")
	private Client client;

	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="orderNumber")
	private Set<OrderLine> orderLines;
	
	
	public PurchaseOrder(int orderNumber, double subTotal, Date purchaseDate, double taxAmount, double total,
			Client client) {
		super();
		this.orderNumber = orderNumber;
		this.subTotal = subTotal;
		this.purchaseDate = purchaseDate;
		this.taxAmount = taxAmount;
		this.total = total;
		this.client = client;
		this.orderLines = new HashSet<OrderLine>();
	}

	public PurchaseOrder(int orderNumber, double subTotal, Date purchaseDate, double taxAmount, double total) {
		super();
		this.orderNumber = orderNumber;
		this.subTotal = subTotal;
		this.purchaseDate = purchaseDate;
		this.taxAmount = taxAmount;
		this.total = total;
		this.orderLines = new HashSet<OrderLine>();
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public double getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(double subTotal) {
		this.subTotal = subTotal;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}

	public PurchaseOrder() {
		super();
	}
	
}
