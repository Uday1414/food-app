package com.ty.food.controller;

import java.util.List;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestGetAllMenu {
	public static void main(String[] args) {
		MenuService menuService = new MenuService();
		List<Menu> menus=menuService.getAllMenu();
		if (menus != null) {
			System.out.println(menus);
		}else {
			System.out.println("no menu");
		}
	}
}
