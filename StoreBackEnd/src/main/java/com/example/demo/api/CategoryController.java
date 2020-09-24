package com.example.demo.api;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.service.CategoryService;

@RequestMapping("api/category")
@RestController
public class CategoryController {

	private final CategoryService categoryService;
	
	@Autowired
	public CategoryController(CategoryService categoryService) {
		// TODO Auto-generated constructor stub
		this.categoryService = categoryService;
	}
	@PostMapping
	public void addCategory(@Valid @NonNull @RequestBody Category category) {
		categoryService.addCategory(category);
	}
	
	@GetMapping
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}
	
	@GetMapping(path="{id}")
	public Category getCategoryByID(@PathVariable("id")UUID id) {
		return categoryService.getCategoryByID(id).orElse(null);
	}
	
	@DeleteMapping(path="{id}")
	public void deleteCategoryByID(@PathVariable("id")UUID id) {
		 categoryService.deleteCategoryById(id);
	}
	
	@PutMapping(path="{id}")
	public void updateCategoryByID(@PathVariable("id")UUID id,@Valid @NonNull @RequestBody Category category) {
		 categoryService.updateCategoryById(id, category);
	}
}
