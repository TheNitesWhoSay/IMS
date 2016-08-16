package com.revature.ims_backend.data.access;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.revature.ims_backend.entities.ClientType;

public class ClientTypeDAO {
	
	public ClientType getClientType(int id) {
		return new ClientType();
	}
	
	public Set<ClientType> getClientTypes(int id) {
		return new HashSet<ClientType>();
	}
	
	public boolean addClientType(ClientType clientType) {
		return false;
	}
	
	public boolean updateClientType(ClientType clientType) {
		return false;
	}
	
	public boolean removeClientType(ClientType clientType) {
		return false;
	}
}
