package com.example.backend.controller;

import java.util.List;

import com.example.backend.entity.Category;
import com.example.backend.entity.Category;
import com.example.backend.exception.NotFoundException;
import com.example.backend.service.CategoryService;
import com.example.backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/category")
@CrossOrigin(origins = { "http://localhost:4200" })
public class CategoryController {

	@Autowired
	CategoryService CategoryService;



	@PostMapping
	public ResponseEntity<Category> add(@RequestBody Category Category)
			throws NotFoundException {
		return new ResponseEntity<>(CategoryService.createCategory(Category), HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Category> getById(@PathVariable Long id) throws NotFoundException {
		return new ResponseEntity<Category>(CategoryService.findCategoryById(id), HttpStatus.OK);
	}



	@GetMapping()
	public ResponseEntity<List<Category>> getAll(){
		return new ResponseEntity<List<Category>>(CategoryService.findAllCategorys(), HttpStatus.OK);
	}



	@PutMapping("/{id}")
	public ResponseEntity<Category> update(@PathVariable("id") Long id, @RequestBody Category Category) throws NotFoundException  {
		return new ResponseEntity<Category>(CategoryService.updateCategory(id, Category), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) throws NotFoundException{

		CategoryService.deleteCategory(id);

		return new ResponseEntity<String>("deleted", HttpStatus.NO_CONTENT);
	}

}
