package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestGetMenuByType {
	public static void main(String[] args) {
		MenuService menuService=new MenuService();
		List<Menu> menus=menuService.getMenuByType("Non-veg");
		for (Menu menu : menus) {
			System.out.println(menu);
		}
	}
}
