package com.revature.ims_backend.data.access;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.revature.ims_backend.entities.Address;

@Entity
@Table(name="ims_address")
public class AddressDAO {
	
	public Address getAddress(int id) {
		return new Address();
	}
	
	public Set<Address> getAddresses(int id) {
		return new HashSet<Address>();
	}
	
	public boolean addAddress(Address address) {
		return false;
	}
	
	public boolean updateAddress(Address address) {
		return false;
	}
	
	public boolean removeAddress(Address address) {
		return false;
	}
}
