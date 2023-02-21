package com.example.backend.controller;

import java.util.List;

import com.example.backend.entity.Publisher;
import com.example.backend.entity.Publisher;
import com.example.backend.exception.NotFoundException;
import com.example.backend.service.PublisherService;
import com.example.backend.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/publisher")
@CrossOrigin(origins = { "http://localhost:4200" })
public class PublisherController {

	@Autowired
	PublisherService PublisherService;



	@PostMapping
	public ResponseEntity<Publisher> add(@RequestBody Publisher Publisher)
			throws NotFoundException {
		return new ResponseEntity<>(PublisherService.createPublisher(Publisher), HttpStatus.CREATED);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Publisher> getById(@PathVariable Long id) throws NotFoundException {
		return new ResponseEntity<Publisher>(PublisherService.findPublisherById(id), HttpStatus.OK);
	}



	@GetMapping()
	public ResponseEntity<List<Publisher>> getAll(){
		return new ResponseEntity<List<Publisher>>(PublisherService.findAllPublishers(), HttpStatus.OK);
	}



	@PutMapping("/{id}")
	public ResponseEntity<Publisher> update(@PathVariable("id") Long id, @RequestBody Publisher Publisher) throws NotFoundException  {
		return new ResponseEntity<Publisher>(PublisherService.updatePublisher(id, Publisher), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) throws NotFoundException{

		PublisherService.deletePublisher(id);

		return new ResponseEntity<String>("deleted", HttpStatus.NO_CONTENT);
	}

}
