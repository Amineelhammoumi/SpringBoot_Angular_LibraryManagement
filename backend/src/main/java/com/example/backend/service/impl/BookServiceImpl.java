package com.example.backend.service.impl;

import java.util.List;

import com.example.backend.entity.Book;
import com.example.backend.entity.Book;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.BookRepository;
import com.example.backend.repository.BookRepository;
import com.example.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookRepository bookRepository;



	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Book findBookById(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));
	}

	@Override
	public Book createBook(Book Book) {
		bookRepository.save(Book);
		return Book;
	}

	@Override
	public Book updateBook(Long id , Book Book) {

		Book Book1 = bookRepository.findById(id).get();

		Book.setName(Book1.getName());
		Book.setDescription(Book1.getDescription());

		bookRepository.save(Book);
		return Book;



	}

	@Override
	public void deleteBook(Long id) {
		final Book Book = bookRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Book not found with ID %d", id)));

		bookRepository.deleteById(Book.getId());
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Book> searchBooks(String keyword) {
		if (keyword != null) {
			return bookRepository.search(keyword);
		}
		return bookRepository.findAll();
	}
}
