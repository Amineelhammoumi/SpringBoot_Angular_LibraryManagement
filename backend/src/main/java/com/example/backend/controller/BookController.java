package com.example.backend.controller;

import java.util.List;

import com.example.backend.entity.Book;
import com.example.backend.entity.Book;
import com.example.backend.exception.NotFoundException;
import com.example.backend.service.BookService;
import com.example.backend.service.BookService;
import com.example.backend.service.CategoryService;
import com.example.backend.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/book")
@CrossOrigin(origins = { "http://localhost:4200" })
public class BookController {

	@Autowired
	BookService bookService;

	@Autowired
	CategoryService categoryService;
	@Autowired
	PublisherService publisherService;

	@PostMapping
	public ResponseEntity<Book> add(@RequestBody Book Book)
			throws NotFoundException {
		return new ResponseEntity<>(bookService.createBook(Book), HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Book> getById(@PathVariable Long id) throws NotFoundException {
		return new ResponseEntity<Book>(bookService.findBookById(id), HttpStatus.OK);
	}



	@GetMapping()
	public ResponseEntity<List<Book>> getAll(){
		return new ResponseEntity<>(bookService.findAllBooks(), HttpStatus.OK);
	}



	@PutMapping("/{id}")
	public ResponseEntity<Book> update(@PathVariable("id") Long id, @RequestBody Book Book) throws NotFoundException  {
		return new ResponseEntity<Book>(bookService.updateBook(id, Book), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) throws NotFoundException{

		bookService.deleteBook(id);

		return new ResponseEntity<String>("deleted", HttpStatus.NO_CONTENT);
	}
}
