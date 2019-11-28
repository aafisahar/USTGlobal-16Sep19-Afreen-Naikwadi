package com.ustglobal.jpawithhibernateapp.jpql;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicUpdateDemo {

	public static void main(String[] args) {
		 EntityManager entityManager = null;
		 EntityTransaction entityTransaction = null;
		 
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("TestPersistence");
			entityManager = entityManagerFactory.createEntityManager();
			entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "update Product set pname=:name where pid=:id";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("name", "Phone");
			query.setParameter("id", 1);
			int res = query.executeUpdate();
			System.out.println(res+" Record Updated");
			entityTransaction.commit();
		} catch (Exception e) {
			e.printStackTrace();
			entityTransaction.rollback();
		}
		entityManager.close();
	}
}
