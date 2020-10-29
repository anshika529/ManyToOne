package com.atmecs.manytoone.crudoperations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;

import com.atmecs.manytoone.util.HibernateUtil;
import com.atmecs.onetoonemapping.entity.UserDetails;
import com.atmecs.onetoonemapping.entity.Users;

public class AddData {
	public void adddata() {
		Session session = HibernateUtil.currentSession();
		Scanner sc = new Scanner(System.in);

		try {
			session.beginTransaction();
			System.out.println("Enter the number of records you want to add");
			int number = sc.nextInt();
			for (int i = 1; i <= number; i++) {
				Users user=new Users();
				System.out.println("Enter Employee Details");
				System.out.println("Enter id:");
				user.setUserid(sc.nextInt());
				System.out.println("Enter User Name:");
				user.setName(sc.next());
				UserDetails userdetail=new UserDetails();
				System.out.println("Email :");
				userdetail.setEmail(sc.next());
				user.setUserdetails(userdetail);
				session.persist(user);
				session.getTransaction().commit();
				System.out.println("Record successfully added");
			}
		} catch (SessionException e) {
			System.out.println(e);
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
