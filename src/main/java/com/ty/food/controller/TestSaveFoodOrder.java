package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestSaveFoodOrder {
	public static void main(String[] args) {
		FoodOrder foodOrder = new FoodOrder();
		foodOrder.setName("uday");
		foodOrder.setPhone(9985564878l);

		Item item1 = new Item();
		item1.setName("Burger");
		item1.setQuantity(2);
		item1.setCost(200);

		Item item2 = new Item();
		item2.setName("French Fries");
		item2.setQuantity(1);
		item2.setCost(100);

		Item item3 = new Item();
		item3.setName("Pepsi");
		item3.setQuantity(2);
		item3.setCost(120);

		List<Item> items = new ArrayList<Item>();
		items.add(item1);
		items.add(item2);
		items.add(item3);

		foodOrder.setItems(items);
		item1.setFoodOrder(foodOrder);
		item2.setFoodOrder(foodOrder);
		item3.setFoodOrder(foodOrder);

		double total = 0;
		for (Item item : items) {
			total += (item.getCost()*item.getQuantity());
		}
		foodOrder.setTotal(total);

		FoodOrderService foodOrderService = new FoodOrderService();
		FoodOrder foodOrder2 = foodOrderService.saveOrder(foodOrder);
		if(foodOrder2!=null) {
			System.out.println("Order is placed Successfully");
		}else {
			System.out.println("order not placed");
		}
	}
}
