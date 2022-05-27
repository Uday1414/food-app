package com.ty.food.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderDao {

	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uday");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public FoodOrder saveOrder(FoodOrder foodOrder) {
		entityTransaction.begin();

		entityManager.persist(foodOrder);
		entityTransaction.commit();
		return entityManager.find(FoodOrder.class, foodOrder.getId());
	}

	public FoodOrder getOrderById(int id) {
		return entityManager.find(FoodOrder.class, id);

	}

	public List<FoodOrder> getAllOrders() {
		Query query = entityManager.createQuery("SELECT f FROM FoodOrder f");
		return query.getResultList();
	}

	public List<FoodOrder> getOrderByName(String name) {
		Query query = entityManager.createQuery("SELECT f FROM FoodOrder f WHERE name=?1");
		query.setParameter(1, name);
		return query.getResultList();
	}

	public List<FoodOrder> getOrderByPhone(long phone) {
		Query query = entityManager.createQuery("SELECT f FROM FoodOrder f WHERE phone=?1");
		query.setParameter(1, phone);
		return query.getResultList();
	}

	public boolean deleteOrderById(int id) {
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		if (foodOrder != null) {
			entityTransaction.begin();

			entityManager.remove(foodOrder);
			entityTransaction.commit();
			return true;
		} else {
			return false;
		}
	}

	public FoodOrder updateOrderById(int id, Item item) {
		FoodOrder foodOrder = entityManager.find(FoodOrder.class, id);
		foodOrder.getItems().add(item);
		entityTransaction.begin();

		double total = 0;
		for (Item i : foodOrder.getItems()) {
			total += (i.getCost() * i.getQuantity());
			i.setFoodOrder(foodOrder);
		}
		foodOrder.setTotal(total);
		entityManager.merge(foodOrder);
		entityTransaction.commit();
		return foodOrder;
	}
	
	
}
