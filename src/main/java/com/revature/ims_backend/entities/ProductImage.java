package com.revature.ims_backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="IMS_PRODUCT_IMAGE")
public class ProductImage {
	
	@Id
	@Column(name="IMAGE_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	/**
	 * This simply points to a publicly readable image on an S3 Server
	 * For testing purposes this may be set to any image available on the web.
	 */
	@Column(name="IMAGE_ADDRESS")
	private String address;

	
	public ProductImage(int id, String address) {
		super();
		this.id = id;
		this.address = address;
	}

	public ProductImage() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
