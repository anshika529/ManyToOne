package com.atmecs.manytoone.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee2")
public class Employee {
	private String name;

	@Id
	private int emp_id;

	@ManyToOne
	private Addresss address;

	public Addresss getAddress() {
		return address;
	}

	public void setAddress(Addresss address) {
		this.address = address;
	}

	public Employee() {
		super();
	}

	public Employee(String name, int id) {
		super();
		this.name = name;
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return emp_id;
	}

	public void setId(int emp_id) {
		this.emp_id = emp_id;
	}
}
