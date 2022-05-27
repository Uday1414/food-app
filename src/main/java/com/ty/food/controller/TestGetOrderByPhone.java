package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestGetOrderByPhone {
	public static void main(String[] args) {
		FoodOrderService foodOrderService = new FoodOrderService();
		List<FoodOrder> foodOrders = foodOrderService.getOrderByPhone(8855478965l);
		for (FoodOrder foodOrder : foodOrders) {
			System.out.println(foodOrder);
			for (Item item : foodOrder.getItems()) {
				System.out.println(item);
			}
		}
	}
}
