package ru.edu.springdata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.edu.springdata.model.Book;
import ru.edu.springdata.service.BooksService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("books")
public class BooksController {

    private final BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping
    public long addBook(@RequestBody Book book) {
        log.info(book.toString());
        return booksService.addBook(book);
    }

    @GetMapping()
    public List<Book> GetAllBooks() {
        log.info("getAllBooks");
        return booksService.getAllBooks();
    }

    @PutMapping
    public long updateBook(@RequestBody Book book) {
        log.info(String.valueOf(book));
        return booksService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable long id) {
        log.info(String.valueOf(id));
        booksService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        log.info(String.valueOf(id));
        return booksService.getBook(id);
    }

    @GetMapping("/get/language/{language}")
    public List<Book> getByLanguage(@PathVariable String language) {
        return booksService.getByLanguage(language);
    }

    @GetMapping("/get/category/{category}")
    public List<Book> getByCategory(@PathVariable Long category) {
        return booksService.getByCategoryId(category);
    }

    @GetMapping("/get/category/{category}/language/{language}")
    public List<Book> getByLanguageAndCategory(@PathVariable String category, @PathVariable String language) {
        return booksService.getByLanguageAndCategory(language, category);
    }

    @GetMapping("/get/authorId/{authorId}")
    public List<Book> getByAuthor(@PathVariable Long authorId) {
        return booksService.getByAuthorId(authorId);
    }

    @GetMapping("/hello")
    public String hello() {
        return "\n=====Hello from BooksController!=====";
    }
 }
