package com.example.backend.service;

import java.util.List;

import com.example.backend.entity.Category;
import com.example.backend.entity.Category;

public interface CategoryService {

	public List<Category> findAllCategorys();

	public Category findCategoryById(Long id);

	public Category createCategory(Category Category);

	public Category updateCategory(Long id ,Category Category);

	public void deleteCategory(Long id);

}
