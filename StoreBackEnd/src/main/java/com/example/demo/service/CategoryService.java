package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.CategoryDao;
import com.example.demo.model.Category;

@Service
public class CategoryService {
	
	private final CategoryDao dao;
	@Autowired
	public CategoryService(CategoryDao dao) {
		// TODO Auto-generated constructor stub
		this.dao = dao;
	}
	
	public int addCategory(Category category) {
		return dao.insertCategory(category);
	}
	
	public List<Category> getAllCategory(){
		return dao.selectAll();
	}
	
}