package com.atmecs.manytoone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="address")
public class Addresss {
@Id
private int address_id;
private String Street;
private String city;
private String Country;



public Addresss() {
	super();
}
public Addresss(int address_id, String street, String city, String country) {
	super();
	this.address_id = address_id;
	Street = street;
	this.city = city;
	Country = country;
}
public int getAddress_id() {
	return address_id;
}
public void setAddress_id(int address_id) {
	this.address_id = address_id;
}
public String getStreet() {
	return Street;
}
public void setStreet(String street) {
	Street = street;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public String getCountry() {
	return Country;
}
public void setCountry(String country) {
	Country = country;
}

}
