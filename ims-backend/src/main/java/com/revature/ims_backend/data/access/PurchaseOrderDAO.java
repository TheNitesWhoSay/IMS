package com.revature.ims_backend.data.access;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.revature.ims_backend.entities.PurchaseOrder;

public class PurchaseOrderDAO {

	public PurchaseOrder getPurchaseOrder(int id) {
		return new PurchaseOrder();
	}
	
	public Set<PurchaseOrder> getPurchaseOrders(int id) {
		return new HashSet<PurchaseOrder>();
	}
	
	public boolean addPurchaseOrder(PurchaseOrder purchaseOrder) {
		return false;
	}
	
	public boolean updatePurchaseOrder(PurchaseOrder purchaseOrder) {
		return false;
	}
	
	public boolean removePurchaseOrder(PurchaseOrder purchaseOrder) {
		return false;
	}
}
