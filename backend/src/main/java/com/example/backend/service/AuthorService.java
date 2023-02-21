package com.example.backend.service;

import java.util.List;

import com.example.backend.entity.Author;

public interface AuthorService {

	public List<Author> findAllAuthors();

	public Author findAuthorById(Long id);

	public Author createAuthor(Author author);

	public Author updateAuthor(Long id ,Author author);

	public void deleteAuthor(Long id);

}
