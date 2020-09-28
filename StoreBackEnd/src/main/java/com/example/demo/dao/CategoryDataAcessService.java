package com.example.demo.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Category;

@Repository("postgres")
public class CategoryDataAcessService implements CategoryDao{
	
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	public CategoryDataAcessService(JdbcTemplate jdbcTemplate) {
		// TODO Auto-generated constructor stub
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public int insertCategory(UUID categoryId, Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Category> selectAll() {
		// TODO Auto-generated method stub
		final String sql = "SELECT categoryid,categoryname FROM category";
		return jdbcTemplate.query(sql, (resultSet,i) -> {
			UUID id = UUID.fromString(resultSet.getString("categoryid"));
			String name = resultSet.getString("categoryname");
			return new Category(id,name);
		});
	}

	@Override
	public Optional<Category> selectCategoryById(UUID id) {
		// TODO Auto-generated method stub
		final String sql = "SELECT categoryid,categoryname FROM category WHERE categoryid = ?";
	    Category category =jdbcTemplate.queryForObject(sql, new Object[] {id}, (resultSet,i) ->{
	    	UUID cId = UUID.fromString(resultSet.getString("categoryid"));
			String name = resultSet.getString("categoryname");
			return new Category(cId,name);
		});
		return Optional.ofNullable(category);
	}

	@Override
	public int deleteCategoryById(UUID id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCategoryById(UUID id, Category category) {
		// TODO Auto-generated method stub
		return 0;
	}

}
