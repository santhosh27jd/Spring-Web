package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.example.demo.dao.CategoryDao;
import com.example.demo.model.Category;

@Repository
public class CategoryDataAccessService implements CategoryDao{
	
	
	List<Category> categoryList = new ArrayList<Category>();
	
	@Override
	public int insertCategory(UUID categoryId, Category category) {
		// TODO Auto-generated method stub
		categoryList.add(new Category(categoryId, category.getCategoryName()));
		return 1; // Since it allways insert category
	}
	
	public List<Category> selectAll(){
		return categoryList;
	}

}
