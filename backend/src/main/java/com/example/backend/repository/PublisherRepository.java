package com.example.backend.repository;

import com.example.backend.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;




public interface PublisherRepository extends JpaRepository<Publisher, Long> {

}
