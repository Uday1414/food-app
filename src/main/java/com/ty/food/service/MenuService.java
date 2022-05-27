package com.ty.food.service;

import java.util.List;

import com.ty.food.dao.MenuDao;
import com.ty.food.dto.Menu;

public class MenuService {

	MenuDao menuDao = new MenuDao();

	public Menu saveMenu(Menu menu) {
		return menuDao.saveMenu(menu);
	}

	public Menu getMenuById(int id) {
		return menuDao.getMenuById(id);
	}
	
	public List<Menu> getMenuByType(String type){
		return menuDao.getMenuByType(type);
	}

	public boolean deleteMenuById(int id) {
		return menuDao.deleteMenuById(id);
	}

	public List<Menu> getAllMenu() {
		return menuDao.getAllMenu(); 
	}
	
	public Menu updateMenuById(int id,Menu menu) {
		return menuDao.updateMenuById(id, menu);
	}
}
