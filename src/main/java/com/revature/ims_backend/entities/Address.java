package com.revature.ims_backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ims_address")
public class Address {
	
	@Id
	@Column(name="ims_address_id")
	private int id;
	
	@Column(name="street_address_1")
	private String address1;
	
	@Column(name="street_address_2")
	private String address2;
	
	@Column(name="address_city")
	private String city;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="state_id")
	private StateAbbreviation state;
	
	@Column(name="address_zip")
	private String zip;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public StateAbbreviation getState() {
		return state;
	}
	public void setState(StateAbbreviation state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public Address() {
		super();
	}
}
