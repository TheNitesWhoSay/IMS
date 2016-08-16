package com.revature.ims_backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ims_client_type")
public class ClientType {
	
	@Id
	@Column(name="client_type_id")
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
