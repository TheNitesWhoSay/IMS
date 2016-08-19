package com.revature.ims_backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="IMS_PRODUCT_STOCK")
public class Stock {

	@Id
	@Column(name="STOCK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	
	@Column(name="PRODUCT_UPC")
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="PRODUCT_UPC")
	int upc;
	
	@Column(name="NUM_IN_STOCK")
	int numInStock;
}
