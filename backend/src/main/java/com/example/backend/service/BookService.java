package com.example.backend.service;

import com.example.backend.entity.Book;

import java.util.List;



public interface BookService {

	public List<Book> findAllBooks();
	
	public List<Book> searchBooks(String keyword);

	public Book findBookById(Long id);

	public Book createBook(Book book);

	public Book updateBook(Long id,Book book);

	public void deleteBook(Long id);

}
