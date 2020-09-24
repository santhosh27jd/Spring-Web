package com.example.demo.model;

import java.util.UUID;

import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Category {

	
	private final UUID categoryId;
	@NotBlank
	private final String categoryName;
	
	public UUID getCategoryId() {
		return categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	
	public Category(@JsonProperty("id")UUID categoryId, @JsonProperty("name")String categoryName) {
		// TODO Auto-generated constructor stub
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}
	
}
