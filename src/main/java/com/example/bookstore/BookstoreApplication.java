package com.example.bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner studentDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			
			log.info("save a couple of categories");
			crepository.save(new Category("Fantasia"));
			crepository.save(new Category("Dokkari"));
			crepository.save(new Category("Draama"));

			log.info("save a couple of books");
			repository.save(new Book("Ensimmäinen kirja", "Marko", 1923, "123-234-2831", 100.00, crepository.findByName("Dokkari").get(0)));
			repository.save(new Book("Toinen kirja", "Daniel", 2020, "123-234-0952", 25.00, crepository.findByName("Draama").get(0)));	
			
			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
	
}