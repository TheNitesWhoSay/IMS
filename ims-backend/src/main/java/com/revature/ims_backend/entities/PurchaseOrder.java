package com.revature.ims_backend.entities;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private LocalDateTime purchaseDate;
	
	@Column(name="TAX_AMOUNT")
	private double taxAmount;
	
	@Column(name="PO_TOTAL")
	private double total;
	
	@Column(name="CLIENT_ID")
	private int clientId; // TODO: Change me to an association

	@OneToMany(fetch=FetchType.EAGER)
	private Set<OrderLine> orderLines;
	
	
	public PurchaseOrder(int orderNumber, double subTotal, LocalDateTime purchaseDate, double taxAmount, double total,
			int clientId) {
		super();
		this.orderNumber = orderNumber;
		this.subTotal = subTotal;
		this.purchaseDate = purchaseDate;
		this.taxAmount = taxAmount;
		this.total = total;
		this.clientId = clientId;
	}

	public PurchaseOrder(int orderNumber, double subTotal, LocalDateTime purchaseDate, double taxAmount, double total) {
		super();
		this.orderNumber = orderNumber;
		this.subTotal = subTotal;
		this.purchaseDate = purchaseDate;
		this.taxAmount = taxAmount;
		this.total = total;
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

	public LocalDateTime getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(LocalDateTime purchaseDate) {
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

	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}

	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	
}
