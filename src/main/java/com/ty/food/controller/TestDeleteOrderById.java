package com.ty.food.controller;

import com.ty.food.service.FoodOrderService;

public class TestDeleteOrderById {
	public static void main(String[] args) {
		FoodOrderService foodOrderService=new FoodOrderService();
		boolean flag=foodOrderService.deleteOrderById(2);
		if(flag) {
			System.out.println("order cancelled");
		}else {
			System.out.println("No order with given id");
		}
	}
}
