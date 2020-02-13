package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository) {
	return (args) -> {
		log.info("save a couple of books");
		repository.save(new Book(0, "Marko Maessen", "Kevätkaamos", "987-123-456-789-0", 10.00, 1997));
		repository.save(new Book(0, "Marko Maessen", "Leipätehdas", "789-321-654-987-0", 15.00,  2020));	
		
		log.info("fetch all students");
		for (Book book : repository.findAll()) {
			log.info(book.toString());
	}
	
	};
}

}
