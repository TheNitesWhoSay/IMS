package com.revature.ims_backend.data.access;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.Session;

import com.revature.ims_backend.entities.StateAbbreviation;

public class StateAbbreviationDAO {
	
	Session session;
	
	public StateAbbreviationDAO(Session session) {
		this.session = session;
	}
	
	public StateAbbreviation getStateAbbreviation(int id) {
		return new StateAbbreviation();
	}
	
	public Set<StateAbbreviation> getStateAbbreviations(int id) {
		return new HashSet<StateAbbreviation>();
	}
	
	public boolean addStateAbbreviation(StateAbbreviation stateAbbreviation) {
		return false;
	}
	
	public boolean updateStateAbbreviation(StateAbbreviation stateAbbreviation) {
		return false;
	}
	
	public boolean removeStateAbbreviation(StateAbbreviation stateAbbreviation) {
		return false;
	}
}
