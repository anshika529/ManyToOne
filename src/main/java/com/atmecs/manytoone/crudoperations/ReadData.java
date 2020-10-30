package com.atmecs.manytoone.crudoperations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;

import com.atmecs.manytoone.entity.Employee;
import com.atmecs.manytoone.util.HibernateUtil;


public class ReadData {
	public void readData() {
		Session session = HibernateUtil.currentSession();
		Scanner sc = new Scanner(System.in);
		try {
			session.beginTransaction();
			System.out.println("Enter id to read the data:");
			Employee emp = (Employee) session.get(Employee.class, sc.nextInt());
			System.out.println("Id is:" + emp.getId());
			System.out.println("First Name : " + emp.getName());
			System.out.println("Record Displayed successfully");
		} catch (SessionException e) {
			System.out.println(e);
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
