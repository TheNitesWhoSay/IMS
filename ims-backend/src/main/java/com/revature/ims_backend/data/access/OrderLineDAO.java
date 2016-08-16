package com.revature.ims_backend.data.access;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.revature.ims_backend.entities.OrderLine;

public class OrderLineDAO {
	
	public OrderLine getOrderLine(int id) {
		return new OrderLine();
	}
	
	public Set<OrderLine> getOrderLines(int id) {
		return new HashSet<OrderLine>();
	}
	
	public boolean addOrderLine(OrderLine orderLine) {
		return false;
	}
	
	public boolean updateOrderLine(OrderLine orderLine) {
		return false;
	}
	
	public boolean removeOrderLine(OrderLine orderLine) {
		return false;
	}
	
}
