package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.*;

public class UserDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uday");
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	public User saveUser(User user) {

		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		entityManager.persist(user);
		entityTransaction.commit();
		return entityManager.find(User.class, user.getId());
	}

	public User getUserById(int id) {

		return entityManager.find(User.class, id);
	}

	public List<User> getAllUsers() {

		String sql = "SELECT u FROM User u";

		Query query = entityManager.createQuery(sql);
		return query.getResultList();
	}

	public User validateUser(String email, String password) {
		String sql = "SELECT u FROM User u WHERE email=?1 AND password=?2";
		Query query = entityManager.createQuery(sql);
		query.setParameter(1, email);
		query.setParameter(2, password);
		List<User> users = query.getResultList();
		return users.get(0);
	}

	public boolean deleteUserById(int id) {
		EntityTransaction entityTransaction = entityManager.getTransaction();
		
		User user=entityManager.find(User.class, id);
		if(user!=null) {
			entityTransaction.begin();
			entityManager.remove(user);
			entityTransaction.commit();
			return true;
		}
		else {
			return false;
		}
	}
}
