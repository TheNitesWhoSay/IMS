package com.revature.ims_backend.data.access;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import com.revature.ims_backend.entities.Client;

public class ClientDAO {
	
	Session session;
	
	public ClientDAO(Session session) {
		this.session = session;
	}
	
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
