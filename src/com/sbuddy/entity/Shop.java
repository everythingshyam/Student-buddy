package com.sbuddy.entity;

public class Shop {

	private int UID;
	private String shop_name;
	private String owner_name;
	private String email;
	private String contact;
//	private String address;
	private String password;
	
	public Shop(int uID, String shop_name, String owner_name, String email,
		String contact, String password, int xCoordinate, int yCoordinate) {
	super();
	UID = uID;
	this.shop_name = shop_name;
	this.owner_name = owner_name;
	this.email = email;
	this.contact = contact;
	this.password = password;
	this.xCoordinate = xCoordinate;
	this.yCoordinate = yCoordinate;
}
	
	
	public Shop(String shop_name, String owner_name, String email,
			String contact, String password, int xCoordinate, int yCoordinate) {
		super();
		this.shop_name = shop_name;
		this.owner_name = owner_name;
		this.email = email;
		this.contact = contact;
		this.password = password;
		this.xCoordinate = xCoordinate;
		this.yCoordinate = yCoordinate;
	}


	public String getShop_name() {
		return shop_name;
	}
	public void setShop_name(String shop_name) {
		this.shop_name = shop_name;
	}
	public String getOwner_name() {
		return owner_name;
	}
	public void setOwner_name(String owner_name) {
		this.owner_name = owner_name;
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
	private int xCoordinate;
	private int yCoordinate;
	public int getUID() {
		return UID;
	}
	public void setUID(int uID) {
		UID = uID;
	}
}
