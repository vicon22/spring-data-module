package ru.edu.springdata.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.edu.springdata.model.Book;
import ru.edu.springdata.service.BooksService;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("books")
public class BooksController {

    BooksService booksService;

    public BooksController(BooksService booksService) {
        this.booksService = booksService;
    }

    @PostMapping
    public int addBook(@RequestBody Book book) {
        log.info(book.toString());
        return booksService.addBook(book);
    }

    @GetMapping()
    public List<Book> GetAllBooks() {
        log.info("getAllBooks");
        return booksService.getAllBooks();
    }

    @PutMapping
    public int updateBook(@RequestBody Book book) {
        log.info(String.valueOf(book));
        return booksService.updateBook(book);
    }

    @DeleteMapping("/{id}")
    public int deleteBook(@PathVariable int id) {
        log.info(String.valueOf(id));
        return booksService.deleteBook(id);
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id) {
        log.info(String.valueOf(id));
        return booksService.getBook(id);
    }

    @GetMapping("/hello")
    public String hello() {
        return "\n=====Hello from BooksController!=====";
    }
 }
