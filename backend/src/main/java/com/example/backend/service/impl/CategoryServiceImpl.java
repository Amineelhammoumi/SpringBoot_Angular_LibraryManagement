package com.example.backend.service.impl;

import java.util.List;

import com.example.backend.entity.Category;
import com.example.backend.entity.Category;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.repository.CategoryRepository;
import com.example.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	CategoryRepository CategoryRepository;



	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Category> findAllCategorys() {
		return CategoryRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Category findCategoryById(Long id) {
		return CategoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Category not found with ID %d", id)));
	}

	@Override
	public Category createCategory(Category Category) {
		CategoryRepository.save(Category);
		return Category;
	}

	@Override
	public Category updateCategory(Long id , Category Category) {

		Category Category1 = CategoryRepository.findById(id).get();

		Category.setName(Category1.getName());


		CategoryRepository.save(Category);
		return Category;



	}

	@Override
	public void deleteCategory(Long id) {
		final Category Category = CategoryRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Category not found with ID %d", id)));

		CategoryRepository.deleteById(Category.getId());
	}

}
