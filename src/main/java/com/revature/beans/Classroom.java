package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.*;

@Entity
@Table(name="UOP_CLASSROOM")
public class Classroom {

	@Id
	@Column(name="ROOM_ID")
	private int id;
	
	@Column(name="ROOM_NUMBER")
	private int roomNumber;
	
	@Column(name="BUILDING_NAME")
	private String building;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getBuilding() {
		return building;
	}
	public void setBuilding(String building) {
		this.building = building;
	}
	public Classroom(int id, int roomNumber, String building) {
		super();
		this.id = id;
		this.roomNumber = roomNumber;
		this.building = building;
	}
	public Classroom() {
		super();
	}
}
