package com.example.backend.controller;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

import com.example.backend.entity.Author;
import com.example.backend.exception.NotFoundException;
import com.example.backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/author")
@CrossOrigin(origins = { "http://localhost:4200" })
public class AuthorController {

	@Autowired
	AuthorService authorService;



	@PostMapping
	public ResponseEntity<Author> add(@RequestBody Author author)
			throws NotFoundException {
		return new ResponseEntity<>(authorService.createAuthor(author), HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Author> getById(@PathVariable Long id) throws NotFoundException {
		return new ResponseEntity<Author>(authorService.findAuthorById(id), HttpStatus.OK);
	}



	@GetMapping()
	public ResponseEntity<List<Author>> getAll(){
		return new ResponseEntity<List<Author>>(authorService.findAllAuthors(), HttpStatus.OK);
	}



	@PutMapping("/{id}")
	public ResponseEntity<Author> update(@PathVariable("id") Long id, @RequestBody Author author) throws NotFoundException  {
		return new ResponseEntity<Author>(authorService.updateAuthor(id, author), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) throws NotFoundException{

		authorService.deleteAuthor(id);

		return new ResponseEntity<String>("deleted", HttpStatus.NO_CONTENT);
	}

}
