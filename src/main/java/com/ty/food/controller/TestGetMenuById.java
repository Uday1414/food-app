package com.ty.food.controller;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestGetMenuById {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
		Menu menu = menuService.getMenuById(1);
		if (menu != null) {
			System.out.println(menu);
		}else {
			System.out.println("no menu");
		}
	}
}
