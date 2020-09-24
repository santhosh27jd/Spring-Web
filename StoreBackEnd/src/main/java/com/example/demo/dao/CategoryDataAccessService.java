package com.example.demo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

	@Override
	public Optional<Category> selectCategoryById(UUID id) {
		// TODO Auto-generated method stub
		return categoryList.stream().filter(category -> category.getCategoryId().equals(id)).findFirst();
	}

	@Override
	public int deleteCategoryById(UUID id) {
		// TODO Auto-generated method stub
		Optional<Category> category = selectCategoryById(id);
		if(!category.isPresent()) {
			return 0;
		}
		categoryList.remove(category.get());
		return 1;
	}

	@Override
	public int updateCategoryById(UUID id, Category category) {
		// TODO Auto-generated method stub
		return selectCategoryById(id).map(categ -> {
			int indexofcategorytoupdate = categoryList.indexOf(categ);
			if(indexofcategorytoupdate >= 0) {
				categoryList.set(indexofcategorytoupdate, new Category(id, category.getCategoryName()));
				return 1;
			}
			return 0;
		}).orElse(0);
	}
}
