package com.atmecs.manytoone.crudoperations;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionException;

import com.atmecs.manytoone.util.HibernateUtil;
import com.atmecs.onetoonemapping.entity.Users;



public class DeleteData {
	public void deleteData() {
		Session session = HibernateUtil.currentSession();
		Scanner sc = new Scanner(System.in);
		try {
			session.beginTransaction();
			System.out.println("Enter id to delete record:");
			Users user = (Users) session.get(Users.class, sc.nextInt());

			if (user != null) {
				session.delete(user);
				session.getTransaction().commit();
				System.out.println("Record deleted successfully..!!");
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
