package com.ty.food.controller;

import java.util.ArrayList;
import java.util.List;

import com.ty.food.dao.Bill;
import com.ty.food.dto.Item;
import com.ty.food.service.FoodOrderService;

public class TestGenerateBill {
	public static void main(String[] args) {
		FoodOrderService foodOrderService = new FoodOrderService();

		List<Bill> bills = new ArrayList<Bill>();

		for (Item item : foodOrderService.getOrderById(2).getItems()) {
			Bill bill = new Bill();
			bill.setItem(item.getName());
			bill.setCost(item.getCost());
			bill.setQuantity(item.getQuantity());
			bill.setTotal((item.getCost() * item.getQuantity()));
			bills.add(bill);
		}
		double total = 0;
		for (Bill bill : bills) {
			System.out.println(bill);
			total += bill.getTotal();
		}
		System.out.println("total amount for order = ");
		System.out.println(total);
		System.out.println("offer 10% for bill>1000");
		System.out.println("payable ammount including gst and offer = ");
		double b = foodOrderService.genarateBill(2);
		System.out.println(b);
	}
}
