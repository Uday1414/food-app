package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.FoodOrder;
import com.ty.food.service.FoodOrderService;

public class TestGetAllOrders {
	public static void main(String[] args) {
		FoodOrderService foodOrderService=new FoodOrderService();
		List<FoodOrder> foodOrders=foodOrderService.getAllOrders();
		for (FoodOrder foodOrder : foodOrders) {
			System.out.println(foodOrder);
		}
	}
}
