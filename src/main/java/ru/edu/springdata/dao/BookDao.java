package ru.edu.springdata.dao;

import ru.edu.springdata.model.Book;

import java.util.List;
import java.util.Optional;

public interface BookDao {

    Optional<Book> getBook(int id);

    List<Book> getAllBooks();

    int deleteBook(int id);

    int updateBook(Book book);

    int addBook(Book book);

    void init();
}
