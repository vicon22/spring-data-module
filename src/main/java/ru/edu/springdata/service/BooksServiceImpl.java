package ru.edu.springdata.service;

import org.springframework.stereotype.Service;
import ru.edu.springdata.model.Book;
import ru.edu.springdata.repository.BookRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    private final BookRepository repository;

    public BooksServiceImpl(BookRepository repository) {
        this.repository = repository;
    }


    @Override
    public Book getBook(long id) {
        Optional<Book> optionalBook = repository.findById(id);
        return optionalBook.orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    @Override
    public void deleteBook(long id) {
        repository.deleteById(id);
    }

    @Override
    public long updateBook(Book book) {
        return repository.save(book).getId();
    }

    @Override
    public long addBook(Book book) {
        System.out.println("addBook: " + book.toString());
        return repository.save(book).getId();
    }

    @Override
    public List<Book> getByCategoryId(Long category) {
        return repository.findByCategoryId(category);
    }

    @Override
    public List<Book> getByLanguage(String language) {
        return repository.findByLanguage(language);
    }

    @Override
    public List<Book> getByLanguageAndCategory(String language, String category) {
        return repository.findByLanguageAndCategoryName(language, category);
    }

    @Override
    public List<Book> getByAuthorId(Long authorId) {
        return repository.findByAuthorsId(authorId);
    }
}
