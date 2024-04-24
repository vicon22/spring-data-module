package ru.edu.springdata.service;

import ru.edu.springdata.model.Book;

import java.util.List;

public interface BooksService {

    Book getBook(int id);

    List<Book> getAllBooks();

    int deleteBook(int id);

    int updateBook(Book book);

    int addBook(Book book);

    void init();
}
