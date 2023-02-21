package com.example.backend.service;

import com.example.backend.entity.Publisher;
import com.example.backend.entity.Publisher;

import java.util.List;



public interface PublisherService {

	public List<Publisher> findAllPublishers();

	public Publisher findPublisherById(Long id);

	public Publisher createPublisher(Publisher Publisher);

	public Publisher updatePublisher(Long id ,Publisher Publisher);

	public void deletePublisher(Long id);

}
