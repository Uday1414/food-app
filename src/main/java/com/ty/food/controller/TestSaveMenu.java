package com.ty.food.controller;

import com.ty.food.dto.Menu;
import com.ty.food.service.MenuService;

public class TestSaveMenu {
	public static void main(String[] args) {
		Menu menu=new Menu();
		menu.setName("biryani");
		menu.setCost(150);
		menu.setOffer(-10);
		menu.setType("veg");
		menu.setDescription("vegetables");
		menu.setImage("https://www.google.com/url?sa=i&url=https%3A%2F%2Fwww.facebook.com%2FPixabay.social%2F&psig=AOvVaw1xKLdeWxtV3NuPRKZeFBc9&ust=1653583321448000&source=images&cd=vfe&ved=0CAwQjRxqFwoTCJig-4aM-_cCFQAAAAAdAAAAABAD");
		
		MenuService menuService=new MenuService();
		if(menuService.saveMenu(menu)!=null) {
			System.out.println("Saved");
		}else {
			System.out.println("not saved");
		}
	}
}
