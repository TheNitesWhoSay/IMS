package com.revature.ims_backend.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class ClientType {
	
	@Id
	@Column(name="ims_client_type")
	@GeneratedValue
	private int id;
	
	@Column(name="client_type")
	private String type;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ClientType() {
		super();
	}
}
