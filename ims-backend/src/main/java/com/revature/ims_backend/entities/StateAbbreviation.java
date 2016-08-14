package com.revature.ims_backend.entities;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class StateAbbreviation {
	
	@Id
	@Column(name="abbrv_id")
	@GeneratedValue
	private int id;
	
	@Column(name="state_name")
	private String name;
	
	@Column(name="state_abbrv")
	private String abbreviation;
	
	
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
	public String getAbbreviation() {
		return abbreviation;
	}
	public void setAbbreviation(String abbreviation) {
		this.abbreviation = abbreviation;
	}
	public StateAbbreviation() {
		super();
	}	
}
