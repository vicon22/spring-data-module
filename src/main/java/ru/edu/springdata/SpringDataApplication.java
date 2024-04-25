package ru.edu.springdata;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import ru.edu.springdata.model.Book;
import ru.edu.springdata.service.BooksService;

@Slf4j
@SpringBootApplication
public class SpringDataApplication implements CommandLineRunner {

	ApplicationContext context;

	public SpringDataApplication(ApplicationContext context) {
		this.context = context;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringDataApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		log.info("=====start initialization db====");
		BooksService booksService = context.getBean(BooksService.class);
		booksService.init();

		booksService.addBook(new Book(1L, "War and Peace", "Russian", "Novel"));
		booksService.addBook(new Book(2L, "Spring in action", "English", "Textbook"));
		booksService.addBook(new Book(3L, "Steven Jobs", "English", "Biography"));

		log.info("=====end of initialization db====");
	}
}
