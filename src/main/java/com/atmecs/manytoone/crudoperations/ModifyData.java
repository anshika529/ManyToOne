package com.atmecs.manytoone.crudoperations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;

import com.atmecs.manytoone.util.HibernateUtil;
import com.atmecs.onetoonemapping.entity.Users;



public class ModifyData {
	public void updateData() {
		Session session = HibernateUtil.currentSession();
		Scanner sc = new Scanner(System.in);
		try {
			session.beginTransaction();
			System.out.println("Enter id to modify record:");
			Users user = (Users) session.get(Users.class, sc.nextInt());

			if (user != null) {
				System.out.println("Enter the new email to update");
			//	user.setEmail(sc.next());
				session.saveOrUpdate(user);

				session.getTransaction().commit();
				System.out.println("Record updated successfully..!!");
			} else {
				System.out.println("Record not found for given id, please enter a correct id");
			}
		} catch (SessionException e) {
			System.out.println(e);
		} finally {
			HibernateUtil.closeSession();
		}

	}
}
