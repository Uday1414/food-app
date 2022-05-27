package com.ty.food.service;

import static com.ty.food.dto.Tax.CGST;
import static com.ty.food.dto.Tax.SGST;

import java.util.List;

import com.ty.food.dao.FoodOrderDao;
import com.ty.food.dto.FoodOrder;
import com.ty.food.dto.Item;

public class FoodOrderService {
	
	FoodOrderDao foodOrderDao=new FoodOrderDao();
	public FoodOrder saveOrder(FoodOrder foodOrder) {
		return foodOrderDao.saveOrder(foodOrder);
	}
	
	public FoodOrder getOrderById(int id) {
		return foodOrderDao.getOrderById(id);
	}
	
	public List<FoodOrder> getAllOrders(){
		return foodOrderDao.getAllOrders();
	}
	
	public  List<FoodOrder> getOrderByName(String name){
		return foodOrderDao.getOrderByName(name);
	}
	
	public  List<FoodOrder> getOrderByPhone(long phone){
		return foodOrderDao.getOrderByPhone(phone);
	}
	
	public boolean deleteOrderById(int id) {
		return foodOrderDao.deleteOrderById(id);
	}
	
	public FoodOrder updateOrderById(int id,Item item) {
		return foodOrderDao.updateOrderById(id, item);
	}
	
	public double genarateBill(int id) {
		FoodOrder foodOrder=foodOrderDao.getOrderById(id);
		double offer=0;
		if(foodOrder.getTotal()>1000) {
			offer = foodOrder.getTotal()/10;
		}
		double a = (foodOrder.getTotal()/CGST)+(foodOrder.getTotal()/SGST);
		 return foodOrder.getTotal()-offer+a;
	}
}
