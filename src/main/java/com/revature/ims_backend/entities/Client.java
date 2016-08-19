package com.revature.ims_backend.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.junit.validator.ValidateWith;

@Entity
@Table(name="ims_client")
public class Client implements Serializable {
	
	@Id
	@Column(name="ims_client_id")
	@GeneratedValue
	private int id;
	
	@Column(name="client_name")
	@NotEmpty
	private String name;
	
	@Column(name="client_email")
	@NotEmpty
	@Email
	private String email;
	
	@Column(name="point_of_contact_name")
	@NotEmpty
	private String pointOfContactName;
	
	@Column(name="client_phone")
	@NotEmpty
	private String phoneNumber;
	
	@Column(name="client_fax")
	@NotEmpty
	private String faxNumber;
	
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="address_id")
	private Address address;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="client_type_id")
	private ClientType clientType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPointOfContactName() {
		return pointOfContactName;
	}
	public void setPointOfContactName(String pointOfContactName) {
		this.pointOfContactName = pointOfContactName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getFaxNumber() {
		return faxNumber;
	}
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public ClientType getClientType() {
		return clientType;
	}
	public void setClientType(ClientType clientType) {
		this.clientType = clientType;
	}
	public Client() {
		super();
	}
}
