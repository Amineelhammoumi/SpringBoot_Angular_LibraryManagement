package com.example.backend.service.impl;

import java.util.List;

import com.example.backend.entity.Publisher;
import com.example.backend.entity.Publisher;
import com.example.backend.exception.NotFoundException;
import com.example.backend.repository.PublisherRepository;
import com.example.backend.repository.PublisherRepository;
import com.example.backend.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;



@Service
public class PublisherServiceImpl implements PublisherService {

	@Autowired
	PublisherRepository PublisherRepository;



	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<Publisher> findAllPublishers() {
		return PublisherRepository.findAll();
	}

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public Publisher findPublisherById(Long id) {
		return PublisherRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Publisher not found with ID %d", id)));
	}

	@Override
	public Publisher createPublisher(Publisher Publisher) {
		PublisherRepository.save(Publisher);
		return Publisher;
	}

	@Override
	public Publisher updatePublisher(Long id , Publisher Publisher) {

		Publisher Publisher1 = PublisherRepository.findById(id).get();

		Publisher.setName(Publisher1.getName());


		PublisherRepository.save(Publisher);
		return Publisher;



	}

	@Override
	public void deletePublisher(Long id) {
		final Publisher Publisher = PublisherRepository.findById(id)
				.orElseThrow(() -> new NotFoundException(String.format("Publisher not found with ID %d", id)));

		PublisherRepository.deleteById(Publisher.getId());
	}

}
