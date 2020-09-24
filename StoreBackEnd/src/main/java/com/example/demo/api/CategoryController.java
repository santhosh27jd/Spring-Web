package com.example.demo.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void addCategory(@RequestBody Category category) {
		categoryService.addCategory(category);
	}
	
	@GetMapping
	public List<Category> getAllCategory() {
		return categoryService.getAllCategory();
	}
	
}
