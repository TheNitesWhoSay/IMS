package com.revature.ims_backend.data.access;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.revature.ims_backend.entities.Client;

public class ClientDAO {
	
	public Client getClient(int id) {
		return new Client();
	}
	
	public Set<Client> getClients(int id) {
		return new HashSet<Client>();
	}
	
	public boolean addClient(Client client) {
		return false;
	}
	
	public boolean updateClient(Client client) {
		return false;
	}
	
	public boolean removeClient(Client client) {
		return false;
	}
}
