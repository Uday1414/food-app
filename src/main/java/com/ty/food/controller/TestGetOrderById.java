package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestGetOrderById {
	public static void main(String[] args) {
		FoodOrderService foodOrderService = new FoodOrderService();
		FoodOrder foodOrder = foodOrderService.getOrderById(1);
		if (foodOrder != null) {
			System.out.println("Order name : " + foodOrder.getName());
			System.out.println("Order phone : " + foodOrder.getPhone());
			System.out.println("Order total : " + foodOrder.getTotal());

			List<Item> items = foodOrder.getItems();
			for (Item item : items) {
				System.out.println("Item name : " + item.getName());
				System.out.println("Item cost : " + item.getCost());
				System.out.println("Item quantity : " + item.getQuantity());
				System.out.println("****************************");
			}
		} else {
			System.out.println("No order with given id");
		}
	}
}
