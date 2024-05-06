package ru.edu.springdata.service;

import ru.edu.springdata.model.Book;

import java.util.List;

public interface BooksService {

    Book getBook(long id);

    List<Book> getAllBooks();

    void deleteBook(long id);

    long updateBook(Book book);

    long addBook(Book book);

    List<Book> getByCategoryId(Long category);

    List<Book> getByLanguage(String language);

    List<Book> getByLanguageAndCategory(String language, String category);

    List<Book> getByAuthorId(Long authorId);
}
