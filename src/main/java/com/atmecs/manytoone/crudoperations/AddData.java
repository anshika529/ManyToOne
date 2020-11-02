package com.atmecs.manytoone.crudoperations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;

import com.atmecs.manytoone.entity.Addresss;
import com.atmecs.manytoone.entity.Employee;
import com.atmecs.manytoone.util.HibernateUtil;

public class AddData {
	public void adddata() {
		Session session = HibernateUtil.currentSession();
		Scanner sc = new Scanner(System.in);

		try {
			session.beginTransaction();
			System.out.println("Enter the number of records you want to add");
			int number = sc.nextInt();
			for (int i = 1; i <= number; i++) {
				Employee emp = new Employee();
				System.out.println("Enter the id");
				emp.setId(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter the name");
				emp.setName(sc.nextLine());
				Addresss adrs = new Addresss();
				System.out.println("Enter address id");
				adrs.setAddress_id(sc.nextInt());
				sc.nextLine();
				System.out.println("Enter Street");
				adrs.setStreet(sc.nextLine());
				System.out.println("Enter city");
				adrs.setCity(sc.nextLine());
				System.out.println("Enter country");
				adrs.setCountry(sc.nextLine());
				emp.setAddress(adrs);
				session.persist(emp);
				session.persist(adrs);
				session.getTransaction().commit();
			}
		} catch (SessionException e) {
			System.out.println(e);
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
