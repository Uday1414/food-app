package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.User;
import com.ty.food.service.UserService;

public class TestGetAllUsers {
	public static void main(String[] args) {
		UserService userService= new UserService();
		List<User> users=userService.getAllUsers();
		if(users.size()>0) {
			for(User user : users) {
				System.out.println(user.getId());
				System.out.println(user.getName());
				System.out.println(user.getEmail());
				System.out.println(user.getPhone());
				System.out.println("----------------------");
			}
		}else {
			System.out.println("No Data in DataBase");
		}
	}
}
