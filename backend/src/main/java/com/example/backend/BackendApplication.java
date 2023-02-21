package com.example.backend;

import com.example.backend.entity.Book;
import com.example.backend.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication

public class BackendApplication  implements CommandLineRunner {

    @Autowired
    BookService bookService;
    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);




    }



    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
//		List<Training> trainingResponseList = new ArrayList<>();
//
//		trainingResponseList = trainingService.getTrainingsByProject(1l);
//
//		System.out.println(trainingResponseList.size() + "************");
        System.out.println("Hello Library Management \n"
                + "");

        List<Book> books = new ArrayList<>();
        books = bookService.findAllBooks();

        for(Book b : books)
        {
            System.out.println(b.getName());
        }



//		roleRepository.save(new Role(ERole.ROLE_ADMIN));
//		roleRepository.save(new Role(ERole.ROLE_USER));
//		roleRepository.save(new Role(ERole.ROLE_MODERATOR));


    }




}
