package ru.edu.springdata.service;

import org.springframework.stereotype.Service;
import ru.edu.springdata.dao.BookDao;
import ru.edu.springdata.model.Book;

import java.util.List;
import java.util.Optional;

@Service
public class BooksServiceImpl implements BooksService {

    BookDao bookDao;

    public BooksServiceImpl(BookDao bookDao) {
        this.bookDao = bookDao;
    }


    @Override
    public Book getBook(int id) {
        Optional<Book> optionalBook = bookDao.getBook(id);
        return optionalBook.orElse(null);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookDao.getAllBooks();
    }

    @Override
    public int deleteBook(int id) {
        return bookDao.deleteBook(id);
    }

    @Override
    public int updateBook(Book book) {
        return bookDao.updateBook(book);
    }

    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public void init() {
        bookDao.init();
    }
}
