package com.sbuddy.entity;

public class Student {
	private int UID;
	private String name;
	private String email;
	private String contact;
	private String address;
	private String password;
	private int xCoordinate;
	private int yCoordinate;
	
	public Student(int uID, String name, String email, String contact, String address,String password,int xCoordinate, int yCoordinate) {
		super();
		UID = uID;
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address=address;
		this.setPassword(password);
		this.setxCoordinate(xCoordinate);
		this.setyCoordinate(yCoordinate);
	}

	public Student(String name, String email, String contact,String address,String password,int xCoordinate, int yCoordinate) {
		super();
		this.name = name;
		this.email = email;
		this.contact = contact;
		this.address = address;
		this.setPassword(password);
		this.setxCoordinate(xCoordinate);
		this.setyCoordinate(yCoordinate);
	}

	public int getUID() {
		return UID;
	}

	public void setUID(int uID) {
		UID = uID;
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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}
	
	public String getAddress()
	{
		return address;
	}
	
	public void setAddress(String address)
	{
		this.address=address;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getxCoordinate() {
		return xCoordinate;
	}

	public void setxCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public int getyCoordinate() {
		return yCoordinate;
	}

	public void setyCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}
	
	
	
	
}
