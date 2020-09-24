package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.example.demo.model.Category;

public interface CategoryDao {
	
	int insertCategory(UUID categoryId, Category category);
	
	default int insertCategory(Category category) {
		UUID id = UUID.randomUUID();
		return insertCategory(id, category);
	}

	public List<Category> selectAll();
	
	Optional<Category> selectCategoryById(UUID id);
	
	int deleteCategoryById(UUID id);
	
	int updateCategoryById(UUID id,Category category);
	
}
