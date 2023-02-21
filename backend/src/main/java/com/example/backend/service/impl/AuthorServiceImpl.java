package com.example.backend.service.impl;

import java.util.List;

import com.example.backend.entity.Author;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.AuthorRepository;
import com.example.backend.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class AuthorServiceImpl implements AuthorService {

	@Autowired
	AuthorRepository authorRepository;



	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Author> findAllAuthors() {
		return authorRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Author findAuthorById(Long id) {
		return authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));
	}

	@Override
	public Author createAuthor(Author author) {
		authorRepository.save(author);
		return author;
	}

	@Override
	public Author updateAuthor(Long id , Author author) {

		Author author1 = authorRepository.findById(id).get();

		author.setName(author1.getName());
		author.setDescription(author1.getDescription());

		authorRepository.save(author);
		return author;



	}

	@Override
	public void deleteAuthor(Long id) {
		final Author author = authorRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Author not found with ID %d", id)));

		authorRepository.deleteById(author.getId());
	}

}
