package com.revature.ims_backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="ims_address")
public class Address {
	
	@Id
	@Column(name="ims_address_id")
	@GeneratedValue
	private int id;
	
	@Column(name="street_address_1")
	@NotEmpty
	private String address1;
	
	@Column(name="street_address_2")
	private String address2;
	
	@Column(name="address_city")
	@NotEmpty
	private String city;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="state_id")
	@Valid
	private StateAbbreviation state;
	
	@Column(name="address_zip")
	@NotEmpty
	@Size(min=5, max=5)
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
	public String toString() {
		if (this.getAddress2() != null && !this.getAddress2().equals(""))
			return String.format("%s, %s, %s, %s %s", 
					this.getAddress1(),
					this.getAddress2(),
					this.getCity(),
					this.getState(),
					this.getZip());
		else
			return String.format("%s, %s, %s %s", 
					this.getAddress1(),
					this.getCity(),
					this.getState(),
					this.getZip());
	}
	
}
